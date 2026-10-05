package com.foodApp.utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class MyConnection {
	
	private MyConnection() {
	}
	
	static private MyConnection connection =new MyConnection();
	
	public static MyConnection getMyConnection() {
		return connection;
	}
	
	
	public static Connection connect() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_delivary","root","root");
		}
		catch (Exception e) {
			e.printStackTrace();
			
			throw new RuntimeException("Database connection failed", e);
		}
	}

}
