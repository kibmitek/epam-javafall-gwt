package com.epam.javafall2015.gwt.server;

import com.epam.javafall2015.gwt.client.registration.RegistrationService;
import com.epam.javafall2015.gwt.shared.JDBCHelper;
import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrationServlet extends RemoteServiceServlet implements RegistrationService {
	
	@Override
	public UserDTO submit(String login, String email, String password, String firstName, String lastName, String gender) {
	
		//1) check login for unique and throws an exception if its not.
		JDBCHelper jdbcHelper = new JDBCHelper();
		if(jdbcHelper.isValueExistsInTable("users", "login", login)){
			try {
				throw new Exception("Sorry, the user with login " + login
						+ " is already registered. "
						+ "\n\r"
						+ "Try another one.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//2) check the email
		if(jdbcHelper.isValueExistsInTable("users","email", email)){
			try {
				throw new Exception("Sorry, the user with email " + email
						+ " is already registered.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		UserDTO user = new UserDTO();
		user.setLogin(login);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setRole("User");
		
		jdbcHelper.storeUser(user);
		return user;
	}
}
