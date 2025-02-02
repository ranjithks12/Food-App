package com.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyConnector {
	
	private MyConnector() {
	}
	static private MyConnector myConnector = new MyConnector();
	
	public static MyConnector getMyConnector() {
		return myConnector;
	}
	
	public Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/foodapp", "root", "root");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void disConnect(ResultSet result, Statement statement, Connection connection) {
		try {
			if(result != null)
				result.close();
			if(statement != null)
				statement.close();
			if(connection != null)
				connection.close();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

}
