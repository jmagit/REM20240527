package com.example.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSingleton {
	private static JDBCSingleton cache;
	private Connection connection;
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.err.println("No encuentro el driver");
		}
	}

	private JDBCSingleton() {}
	
	public static JDBCSingleton getInstance() throws SQLException {
		if(cache == null) {
			cache = new JDBCSingleton();
			cache.connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "usuario", "contraseña");
		}
		
		return cache;
	}

	public Connection getConnection() throws SQLException {
		return connection;
	}

}
