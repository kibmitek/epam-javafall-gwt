
package com.epam.javafall2015.gwt.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JDBCConnection {
		
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		try{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tutordb", "root", "root");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
