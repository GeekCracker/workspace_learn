package com.muck.shardingsphere.task;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class CopyDataRemoteToLocal {
	@Autowired
	private DataSource dataSourceLocal;
	
	private static String filePath = "D:\\muck\\static\\temp\\copyData\\lastQueryId.txt";
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Scheduled(cron="0/1 * * * * ?")//每1秒钟执行一次
	public void copy(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://36.26.92.24:3306/muck?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true");
		dataSource.setUsername("root");
		dataSource.setPassword("wkq123456Q");
		Connection connection = null;
		Connection connectionLocal = null;
		PreparedStatement statement = null;
		/**创建一个结果集对象*/
		ResultSet resultSet = null;
		/**创建元数据对象，用来存放从数据库中获取到的元数据，
		 * 可用于获取关于 ResultSet 对象中列的类型和属性信息的对象。*/
		ResultSetMetaData resultSetMetaData = null;
		Map<String,Object> map = null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			connection = dataSource.getConnection();
			String startTime = "2019-05-04 00:00:00";
			String endTime = "2019-05-04 00:00:29";
			
			Long lastQueryId = getLastQueryId();
			
			Long startId = lastQueryId;
			Long endId = (lastQueryId += 5000l);
			StringBuilder sb = new StringBuilder("");
			//sb.append("select * from t_biz_gps_data where gps_time >='"+startTime+"' and gps_time <= '"+endTime+"';");
			sb.append("select * from t_biz_gps_data where id >= "+startId+" and id < "+endId+";");
			System.out.println("========开始执行=======");
			System.out.println(sb.toString());
			statement = connection.prepareStatement(sb.toString());
			resultSet = statement.executeQuery();
			//获取列信息
			resultSetMetaData = resultSet.getMetaData();
			//通过列信息获取到列数
			int cols = resultSetMetaData.getColumnCount();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//判断是否有下一行数据
			while(resultSet.next()){
				//定义一个HashMap键值对映射
				map = new HashMap<String, Object>();
				//获取每一列数据将其存放到map中
				for(int i = 1;i<=cols;i++){
					//将表头信息作为键，将表数据作为值
					Object obj = resultSet.getObject(i);
					if(obj != null){
						if(obj instanceof Timestamp){
							Timestamp time = (Timestamp) obj;
							Date date = new Date(time.getTime());
							obj = sdf.format(date);
						}
						map.put(resultSetMetaData.getColumnName(i),obj);
					}
				}
				//将一个行数据添加到二维的list集合中
				list.add(map);
			}
			System.out.println("查询成功，查询到"+list.size()+"条数据；");
			/*Integer rows = gpsDataMapper.insertAll(list);*/
			if(list.size() > 0){
				System.out.println("开始向指定数据库添加>>>");
				String insertSql = insertToLocal("t_biz_gps_data",list);
				connectionLocal = dataSourceLocal.getConnection();
				Integer rows = connectionLocal.createStatement().executeUpdate(insertSql);
				System.out.println("添加成功，受影响行数："+rows);
				initLastQueryId(endId);
			}
			System.out.println("========执行完毕=======");
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				if(resultSet != null){
					resultSet.close();
				}
				if(statement != null){
					statement.close();
				}
				if(connection != null){
					connection.close();
				}
				if(connectionLocal != null){
					connectionLocal.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public String insertToLocal(String tableName, List<Map<String, Object>> listData) {
		if(tableName == null || "".equals(tableName)){
			throw new RuntimeException("数据库表名为空");
		}
		StringBuilder sql = new StringBuilder("");
		if(listData != null && listData.size() > 0){
			sql.append("insert into ").append(tableName);
			sql.append("( ");
			Map<String,Object> map = listData.get(0);
			List<String> keys = new ArrayList<String>(map.keySet());
			for(String key : keys ){
				sql.append(key);
				sql.append(",");
			}
			sql.deleteCharAt(sql.length()-1);
			sql.append(" ) ");
			sql.append(" values ");
			for(Map<String,Object> data : listData){
				sql.append(" ( ");
				for(String key : keys){
					Object obj = data.get(key);
					if(obj != null){
						if(obj instanceof Integer || obj instanceof Double || obj instanceof Long){
							sql.append(data.get(key));
						}else if (obj instanceof String){
							sql.append("'").append(data.get(key)).append("'");
						}else if (obj instanceof Boolean){
							sql.append(data.get(key));
						}else {
							sql.append("'").append(data.get(key)).append("'");
						}
					}else {
						sql.append("''");
					}
					sql.append(",");
				}
				sql.deleteCharAt(sql.length()-1);
				sql.append(" ) ");
				sql.append(",");
			}
			sql.deleteCharAt(sql.length()-1);
			/*sql.append(" ON DUPLICATE KEY UPDATE ");
			for(String key : keys){
				if(!"id".equals(key)){
					sql.append(key + "=values("+key+")");
					sql.append(",");
				}
			}
			sql.deleteCharAt(sql.length()-1);
			sql.append(";");*/
		}
		return sql.toString();
	}
	
	
	private static Long getLastQueryId(){
		Long lastId = 0L;
		BufferedReader br = null;
		try {
			File file = new File(filePath);
			if(file.exists() && file.isFile()){
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
				return Long.parseLong(br.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lastId;
	}
	private static void initLastQueryId(Long curId){
		File file = new File(filePath);
		File parentFile = file.getParentFile();
		if(!parentFile.exists()){
			if(!parentFile.mkdirs()){
			}
		}
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			bw.write(curId+"");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bw != null){
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
