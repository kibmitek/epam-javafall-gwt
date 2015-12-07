package com.epam.javafall2015.gwt.server;

import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AdvancedServlet  extends RemoteServiceServlet{

	public UserDTO getUser(){
		return (UserDTO)getThreadLocalRequest().getSession().getAttribute("current_user");
	}
	
	public void setUser(UserDTO user){
		getThreadLocalRequest().getSession().setAttribute("current_user", user);
	}
}
