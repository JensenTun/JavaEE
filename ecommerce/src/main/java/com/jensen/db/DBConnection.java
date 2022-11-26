package com.jensen.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	private static Connection conn;
	
	public static Connection getconnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp", "root", "admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
