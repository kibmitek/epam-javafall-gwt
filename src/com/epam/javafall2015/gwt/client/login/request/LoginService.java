package com.epam.javafall2015.gwt.client.login.request;

import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("login.rpc")
public interface LoginService extends RemoteService{
	UserDTO isLoggedIn();
	UserDTO login(String login, String password);
	void logout();
}
