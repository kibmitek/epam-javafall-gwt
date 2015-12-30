package com.epam.javafall2015.gwt.server;

import com.epam.javafall2015.gwt.client.login.request.LoginService;
import com.epam.javafall2015.gwt.shared.GUID;
import com.epam.javafall2015.gwt.shared.JDBCHelper;
import com.epam.javafall2015.gwt.shared.Password;
import com.epam.javafall2015.gwt.shared.UserDTO;

public class LoginServlet extends AdvancedServlet implements LoginService {

	private String uuid;
	private Password pass = new Password();
	
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
	
	public UserDTO login(String login, String password) {
		JDBCHelper helper = new JDBCHelper();
		//identification
		if(!helper.isValueExistsInTable("users", "login", login)){
			System.out.println("Пользователь " + login + " не существует в системе.");
			return null;
		}
		//authentification
		try {
			if(!pass.check(password, helper.getStoredPasswordField(login))){
				System.out.println("Неверное сочетание имени пользователя и пароля.");
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// *** Test Code ****
		UserDTO user = new UserDTO();
		//TODO: get userDTO instance from DataBase
		
		uuid = GUID.get();
//		if(email.contains("tutor") || email.contains("student")){
			//user.setEmail(email);
			user.setId(1);
			user.setLogin("NameFromDb");
			
			//set the current_user for this session
			setUser(user);//see AdvncedServlet (Parent Class)
			
//		}else{
//			user = null;//force showLogin
//		}
		
		return user;
	}

}
