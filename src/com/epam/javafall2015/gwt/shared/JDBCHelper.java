package com.epam.javafall2015.gwt.shared;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCHelper {
	public boolean isValueExistsInTable(String table, String param, String value){
		Connection connection = JDBCConnection.getConnection();
		final String query = "SELECT * FROM ? WHERE ? = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, table);
			ps.setString(2, param);
			ps.setString(3, value);
			final ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				resultSet.close();//prevents memory leaks
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public String getStoredPasswordField(String login){
		Connection connection = JDBCConnection.getConnection();
		final String query = "SELECT password FROM users WHERE login = ?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, login);
			final ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				String pass =  resultSet.toString();
				resultSet.close();//prevents memory leaks
				return pass;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
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

	public void storeUser(UserDTO user) {
		Connection connection = JDBCConnection.getConnection();
		final String query = "INSERT INTO users SET login=?, email=?, password=?, firstname=?, lastname=?, gender=?, role=?";
//		final String query2 = "INSERT INTO users(login,email,password,firstname,lastname,gender,role) values(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(query);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getGender());
			ps.setString(7, user.getRole().toString());
			
			final ResultSet resultSet = ps.executeQuery();
			if(resultSet.next()){
				resultSet.close();//prevents memory leaks
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
