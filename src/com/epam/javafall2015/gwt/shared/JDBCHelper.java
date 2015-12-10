package com.epam.javafall2015.gwt.shared;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {

	public ResultSet executeQuery(String query){
		Connection connection = JDBCConnection.getConnection();
		try{
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			printRS(rs);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public void printRS(ResultSet rs){
		try{
			while(rs.next()){
				System.out.println(rs.getString(1));
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
}
