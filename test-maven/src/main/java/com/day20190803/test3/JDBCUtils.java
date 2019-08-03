package com.day20190803.test3;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JDBCUtils {
	private static String className ;
	private static String url;
	private static String user;
	private static String password;
	/**
	 * @param 读取属性文件
	 * */
	static {
		Properties properties = new Properties();
		try {

			properties.load(JDBCUtils.class.getResourceAsStream("jdbc.properties"));
			className = properties.getProperty("className");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @return 返回一个连接
	 */
	private static Connection getConnection (){
		Connection connection = null;
		try {
			//加载驱动
			Class.forName(className);
			//获取连接
			connection = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * @param sql 传入一个sql语句
	 * @return 返回查询到的表数据
	 */
	public static List<Map<String,Object>> doQuery(String sql,Object...objects){
		/**存放查询到的数据*/
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		/**数据库表头名作为键，将表数据作为值放到该键值对映射中*/
		Map<String,Object> map = null;
		/**创建一个连接对象*/
		Connection connection = null;
		/**声明处理sql语句的处理方式，该方式为预编译的处理方式，在调用该对象之前
		 * SQL 语句被预编译并存储在 PreparedStatement 对象中。
		 * 然后可以使用此对象多次高效地执行该语句，可以有效的防止sql的注入*/
		PreparedStatement preparedStatement =null;
		/**创建一个结果集对象*/
		ResultSet resultSet = null;
		/**创建元数据对象，用来存放从数据库中获取到的元数据，
		 * 可用于获取关于 ResultSet 对象中列的类型和属性信息的对象。*/
		ResultSetMetaData resultSetMetaData = null;
		try {
			//获取连接
			connection = getConnection();
			//处理sql语句
			preparedStatement = connection.prepareStatement(sql);
			//循环遍历动态参数，让其代替占位符位置，从而防止sql的注入
			if(objects.length > 0){
				for(int i = 1;i<=objects.length;i++){
					preparedStatement.setObject(i,objects[i-1]);
				}
			}
			//将获取到的数据存放到结果集对象resultSet中
			resultSet = preparedStatement.executeQuery();
			//获取列信息
			resultSetMetaData = resultSet.getMetaData();
			//通过列信息获取到列数
			int cols = resultSetMetaData.getColumnCount();
			//判断是否有下一行数据
			while(resultSet.next()){
				//定义一个HashMap键值对映射
				map = new HashMap<String, Object>();
				//获取每一列数据将其存放到map中
				for(int i = 1;i<=cols;i++){
					//将表头信息作为键，将表数据作为值
					map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
				}
				//将一个行数据添加到二维的list集合中
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//释放对数据库的资源访问
			close(connection,preparedStatement,resultSet);
		}
		return list;
	}
	/**
	 * @param sql 传入一个sql语句，根据该sql语句进行更新数据库
 	 * @return 返回一个布尔类型的结果，如果为true则更新成功，否则更新失败
	 */
	public static boolean doUpdate(String sql,Object...objects){
		/**声明一个布尔类型的变量作为返回值*/
		boolean flag = false;
		/**声明一个连接对象*/
		Connection connection =null ;
		/**声明对sql语句的处理方式*/
		PreparedStatement preparedStatement = null;
		try {
			//获取连接
			connection = getConnection();
			//处理sql语句
			preparedStatement =connection.prepareStatement(sql);
			//循环遍历动态参数，让其代替占位符位置，从而防止sql的注入 例如 delete from student where id = 1 or 1=1;等价于delete from student ;等于删除整张student表
			if(objects.length > 0){
				for(int i = 1;i<=objects.length;i++){
					preparedStatement.setObject(i, objects[i-1]);
				}
			}
			//通过指定的sql语句处理方式进行对sql语句的处理
			int rows = preparedStatement.executeUpdate();
			//如果返回值大于0，则表示修改成功了
			if(rows>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//释放对数据库的资源访问
			close(connection,preparedStatement,null);
		}
		return flag;
	}
	/**
	 * @param connection 传入一个需要被关闭的连接
	 * @param statement 传入一个需要被关闭的sql语句执行对象
	 * @param resultSet 传入一个需要被关闭的结果集对象
	 */
	private static void close(Connection connection,Statement statement,ResultSet resultSet){
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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
