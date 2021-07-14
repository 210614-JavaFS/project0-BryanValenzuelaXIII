package com.revature.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException {
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:postgresql://database-1.c2ebawtrdthw.us-east-2.rds.amazonaws.com:5432/demos";
		String username = "postgres";
		String password = "password";
		
		return DriverManager.getConnection(url, username, password);	}
}
