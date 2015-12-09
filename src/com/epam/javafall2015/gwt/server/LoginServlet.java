package com.epam.javafall2015.gwt.server;

import com.epam.javafall2015.gwt.client.login.request.LoginService;
import com.epam.javafall2015.gwt.shared.GUID;
import com.epam.javafall2015.gwt.shared.UserDTO;

public class LoginServlet extends AdvancedServlet implements LoginService {

	private String uuid;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void logout() {
		setUser(null);
	}

	public UserDTO isLoggedIn() {
		return getUser(); // helper method from AdvancedServlet
	}
	
	public UserDTO login(String email, String password) {
		//check to see if the email exist in the datastore
		//check passwords
		// *** Test Code ****
		UserDTO user = new UserDTO();
		uuid = GUID.get();
		if(email.contains("tutor") || email.contains("student")){
			user.setEmail(email);
			user.setId(1);
			user.setLogin("NameFromDb");
			
			//set the current_user for this session
			setUser(user);//see AdvncedServlet (Parent Class)
			
		}else{
			user = null;//force showLogin
		}
		
		return user;
	}

}
