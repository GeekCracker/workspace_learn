package com.muck.shardingsphere.init.bean.sharding.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.common.collect.Range;

import io.shardingsphere.core.api.ShardingDataSourceFactory;
import io.shardingsphere.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.RangeShardingValue;
import io.shardingsphere.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import io.shardingsphere.core.api.algorithm.sharding.standard.RangeShardingAlgorithm;
import io.shardingsphere.core.api.config.ShardingRuleConfiguration;
import io.shardingsphere.core.api.config.TableRuleConfiguration;
import io.shardingsphere.core.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.core.api.config.strategy.StandardShardingStrategyConfiguration;

@Component("ShardingJDBC")
public class ShardingJDBC {

	Logger logger = LoggerFactory.getLogger(ShardingJDBC.class);

	@Bean
	public DataSource initShardingDataSource() throws FileNotFoundException, SQLException, IOException {
		logger.info("初始化数据源>>>>");
		Map<String, DataSource> dataSourceMap = new HashMap<String, DataSource>();
		// 第一个数据源
		BasicDataSource dataSource0 = new BasicDataSource();
		dataSource0.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource0.setUrl("jdbc:mysql://192.168.2.7:3306/muck0?useUnicode=true&characterEncoding=utf8");
		dataSource0.setUsername("root");
		dataSource0.setPassword("123456");
		dataSourceMap.put("muck0", dataSource0);
		// 第二个数据源
		BasicDataSource dataSource1 = new BasicDataSource();
		dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource1.setUrl("jdbc:mysql://192.168.2.7:3306/muck1?useUnicode=true&characterEncoding=utf8");
		dataSource1.setUsername("root");
		dataSource1.setPassword("123456");
		dataSourceMap.put("muck1", dataSource1);
		// 第三个数据源
		BasicDataSource dataSource2 = new BasicDataSource();
		dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource2.setUrl("jdbc:mysql://192.168.2.7:3306/muck2?useUnicode=true&characterEncoding=utf8");
		dataSource2.setUsername("root");
		dataSource2.setPassword("123456");
		dataSourceMap.put("muck2", dataSource2);

		// 第四个数据源
		/*
		 * BasicDataSource dataSource3 = new BasicDataSource();
		 * dataSource3.setDriverClassName("com.mysql.jdbc.Driver");
		 * dataSource3.setUrl(
		 * "jdbc:mysql://192.168.2.7:3306/muck3?useUnicode=true&characterEncoding=utf8"
		 * ); dataSource3.setUsername("root");
		 * dataSource3.setPassword("123456");
		 * dataSourceMap.put("muck3",dataSource3);
		 */

		// 装载数据库表的分片规则
		TableRuleConfiguration tableRuleConfiguration = new TableRuleConfiguration();
		// 设置表名
		tableRuleConfiguration.setLogicTable("t_biz_gps_data");
		// 设置节点规则
		tableRuleConfiguration.setActualDataNodes("muck${0..2}.t_biz_gps_data_${2018..2019}_${01..12}");

		// 配置分库+分表策略
		tableRuleConfiguration
				.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "muck${id % 3}"));
		// tableRuleConfiguration.setTableShardingStrategyConfig(new
		// InlineShardingStrategyConfiguration("year,month","t_biz_gps_data_${year}_${month}"));
		// tableRuleConfiguration.setTableShardingStrategyConfig(new
		// InlineShardingStrategyConfiguration("gps_time","t_biz_gps_data_${gps_time.getAt(0..3)}_${gps_time.getAt(5..6)}"));
		tableRuleConfiguration.setTableShardingStrategyConfig(
				
				new StandardShardingStrategyConfiguration("gps_time",
			   /**
			     * 自定义按照时间进行分片，增加时会走这里 
			     *	标准分片算法
				 */
				new PreciseShardingAlgorithm<Comparable<?>>() {
					@Override
					public String doSharding(Collection<String> collection,
							PreciseShardingValue<Comparable<?>> shardingValue) {
						String[] value = ((String) shardingValue.getValue()).split(" ")[0].split("-");
						Integer year = Integer.parseInt(value[0]);
						Integer month = Integer.parseInt(value[1]);
						for (String each : collection) {
							if (each.endsWith(year + "_" + month)) {
								return each;
							}
						}
						return null;
					}
				}, 
				/**
				 * 范围查找的分片算法（暂时[2019-5-7 22:30:00]这里未生效）
				 * @author 
				 */
				new RangeShardingAlgorithm<Comparable<String>>() {
					@Override
					public Collection<String> doSharding(Collection<String> collection,
							RangeShardingValue<Comparable<String>> shardingValue) {
						//collection数据源列表
						//shardingValue分片键列表
						Collection<String> collect = new ArrayList<>();
						
						Range<Comparable<String>> valueRange = shardingValue.getValueRange();
						//获取请求的开始和结束条件
						String lowerEndpoint = (String) valueRange.lowerEndpoint();
						String upperEndpoint = (String) valueRange.upperEndpoint();
						
						//获取请求参数的相对应的年月日
						String [] lowerValue = lowerEndpoint.split(" ")[0].split("-");
						String [] upperValue = upperEndpoint.split(" ")[0].split("-");
						
						//获取请求参数的相对应的年份
						Integer lowerYear = Integer.parseInt(lowerValue[0]);
						Integer lowerMonth = Integer.parseInt(lowerValue[1]);
						
						//获取请求参数的相对应的月份
						Integer upperYear = Integer.parseInt(upperValue[0]);
						Integer upperMonth = Integer.parseInt(upperValue[1]);
						
						//遍历时间轴开始到结束的条件
						//外层循环是条件开始年份到结束年份
						for(int i = lowerYear ; i <= upperYear ;i++){
							//如果开始时间和结束时间是同一年
							if(lowerYear.equals(upperYear)){
								for(int j = lowerMonth ;j<=upperMonth;j++){
									for (String each : collection) {
						            	if (each.endsWith(i + "_" + j)) {
						            		collect.add(each);
										}
									}
								}
							}else if(i == lowerYear){
								//如果遍历到最早的一年，则遍历月份是从最早的一张表的月份开始到当年12月份结束
								for(int j = lowerMonth ;j<=12;j++){
									for (String each : collection) {
						            	if (each.endsWith(i + "_" + j)) {
						            		collect.add(each);
										}
									}
								}
							}else if(i == upperYear){
								//如果遍历到最后的一年，则遍历月份是从1月份到最后的一张表的月份结束
								for(int j = 1;j<=upperMonth ;j++){
									for (String each : collection) {
						            	if (each.endsWith(i + "_" + j)) {
						            		collect.add(each);
										}
									}
								}
							}else {
								//如果是中间的年份，则遍历所有月份
								for(int j = 1;j<=12;j++){
									for (String each : collection) {
						            	if (each.endsWith(i + "_" + j)) {
						            		collect.add(each);
										}
									}
								}
							}
						}
						return collect;
				}
			})
		);
		// 配置分片规则
		ShardingRuleConfiguration shardingRuleConfiguration = new ShardingRuleConfiguration();
		shardingRuleConfiguration.getTableRuleConfigs().add(tableRuleConfiguration);

		Properties props = new Properties();
		props.setProperty("sql.show", "false");
		DataSource dataSource = ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfiguration,
				new ConcurrentHashMap<String, Object>(), props);
		logger.info("数据源初始化成功.....");
		/*logger.info("开始初始化表>>>>>");
		initShardingTable(dataSource);
		logger.info("数据库表初始化成功.....");*/
		return dataSource;
	}

	public void initShardingTable(DataSource dataSource) {
		BufferedReader reader = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = dataSource.getConnection();
			reader = new BufferedReader(
					new InputStreamReader(ShardingJDBC.class.getResourceAsStream("/createTable.sql")));
			StringBuilder sb = new StringBuilder("");
			String line = null;
			String tableName = "";
			while ((line = reader.readLine()) != null) {
				// 如果当前行存在drop语句
				if (line.toLowerCase().contains("drop")) {
					// 如果是false 表示不删除旧的表 则不拼接删除的sql
					if ("false".equals("false")) {
						continue;
					}
				}
				sb.append(line + "\n");
				if (line.contains("CREATE TABLE")) {
					tableName = line.toLowerCase().replaceAll(" ", "").replaceAll("createtableifnotexists", "")
							.replaceAll("`", "").replaceAll("\\(", "");
				}
				if (line.endsWith(";")) {
					System.out.println(sb.toString());
					preparedStatement = connection.prepareStatement(sb.toString());
					preparedStatement.executeUpdate();
					System.out.println(">>>创建" + tableName + "表成功");
					sb = new StringBuilder("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
