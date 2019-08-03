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
	 * @param ��ȡ�����ļ�
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
	 * @return ����һ������
	 */
	private static Connection getConnection (){
		Connection connection = null;
		try {
			//��������
			Class.forName(className);
			//��ȡ����
			connection = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	/**
	 * @param sql ����һ��sql���
	 * @return ���ز�ѯ���ı�����
	 */
	public static List<Map<String,Object>> doQuery(String sql,Object...objects){
		/**��Ų�ѯ��������*/
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		/**���ݿ��ͷ����Ϊ��������������Ϊֵ�ŵ��ü�ֵ��ӳ����*/
		Map<String,Object> map = null;
		/**����һ�����Ӷ���*/
		Connection connection = null;
		/**��������sql���Ĵ���ʽ���÷�ʽΪԤ����Ĵ���ʽ���ڵ��øö���֮ǰ
		 * SQL ��䱻Ԥ���벢�洢�� PreparedStatement �����С�
		 * Ȼ�����ʹ�ô˶����θ�Ч��ִ�и���䣬������Ч�ķ�ֹsql��ע��*/
		PreparedStatement preparedStatement =null;
		/**����һ�����������*/
		ResultSet resultSet = null;
		/**����Ԫ���ݶ���������Ŵ����ݿ��л�ȡ����Ԫ���ݣ�
		 * �����ڻ�ȡ���� ResultSet �������е����ͺ�������Ϣ�Ķ���*/
		ResultSetMetaData resultSetMetaData = null;
		try {
			//��ȡ����
			connection = getConnection();
			//����sql���
			preparedStatement = connection.prepareStatement(sql);
			//ѭ��������̬�������������ռλ��λ�ã��Ӷ���ֹsql��ע��
			if(objects.length > 0){
				for(int i = 1;i<=objects.length;i++){
					preparedStatement.setObject(i,objects[i-1]);
				}
			}
			//����ȡ�������ݴ�ŵ����������resultSet��
			resultSet = preparedStatement.executeQuery();
			//��ȡ����Ϣ
			resultSetMetaData = resultSet.getMetaData();
			//ͨ������Ϣ��ȡ������
			int cols = resultSetMetaData.getColumnCount();
			//�ж��Ƿ�����һ������
			while(resultSet.next()){
				//����һ��HashMap��ֵ��ӳ��
				map = new HashMap<String, Object>();
				//��ȡÿһ�����ݽ����ŵ�map��
				for(int i = 1;i<=cols;i++){
					//����ͷ��Ϣ��Ϊ��������������Ϊֵ
					map.put(resultSetMetaData.getColumnName(i), resultSet.getObject(i));
				}
				//��һ����������ӵ���ά��list������
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//�ͷŶ����ݿ����Դ����
			close(connection,preparedStatement,resultSet);
		}
		return list;
	}
	/**
	 * @param sql ����һ��sql��䣬���ݸ�sql�����и������ݿ�
 	 * @return ����һ���������͵Ľ�������Ϊtrue����³ɹ����������ʧ��
	 */
	public static boolean doUpdate(String sql,Object...objects){
		/**����һ���������͵ı�����Ϊ����ֵ*/
		boolean flag = false;
		/**����һ�����Ӷ���*/
		Connection connection =null ;
		/**������sql���Ĵ���ʽ*/
		PreparedStatement preparedStatement = null;
		try {
			//��ȡ����
			connection = getConnection();
			//����sql���
			preparedStatement =connection.prepareStatement(sql);
			//ѭ��������̬�������������ռλ��λ�ã��Ӷ���ֹsql��ע�� ���� delete from student where id = 1 or 1=1;�ȼ���delete from student ;����ɾ������student��
			if(objects.length > 0){
				for(int i = 1;i<=objects.length;i++){
					preparedStatement.setObject(i, objects[i-1]);
				}
			}
			//ͨ��ָ����sql��䴦��ʽ���ж�sql���Ĵ���
			int rows = preparedStatement.executeUpdate();
			//�������ֵ����0�����ʾ�޸ĳɹ���
			if(rows>0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ͷŶ����ݿ����Դ����
			close(connection,preparedStatement,null);
		}
		return flag;
	}
	/**
	 * @param connection ����һ����Ҫ���رյ�����
	 * @param statement ����һ����Ҫ���رյ�sql���ִ�ж���
	 * @param resultSet ����һ����Ҫ���رյĽ��������
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
