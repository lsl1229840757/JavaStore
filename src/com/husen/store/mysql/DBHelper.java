package com.husen.store.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	//1.��������
		//��������url
		static String url;
		//����Properties����
		static Properties info = new Properties();
		//��̬�����
		static {
			//��ȡ�����ļ���������
			InputStream in = DBHelper.class.getClassLoader().getResourceAsStream("com/husen/store/mysql/info.properties");
			try {
				//���������ļ���Ϣ
				info.load(in);
				//�������ļ��ж�ȡurl
				url = info.getProperty("url");
				//�������ļ��ж�ȡdriver
				String driverClassName = info.getProperty("driver");
				Class.forName(driverClassName);
			}catch(ClassNotFoundException e) {
				System.out.println("�����������ʧ��");
			}catch(IOException e) {
				System.out.println("�����������ʧ��");
			}
		}
		
		//2.�������ݿ�����
		public static Connection getConnection() throws SQLException {
			//�������ݿ�����
			Connection conn = DriverManager.getConnection(url,info);
			return conn;
		}
		
}
