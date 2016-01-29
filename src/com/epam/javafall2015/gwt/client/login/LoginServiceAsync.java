package com.epam.javafall2015.gwt.client.login;

import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {

	void isLoggedIn(AsyncCallback<UserDTO> callback);

	void login(String login, String password, AsyncCallback<UserDTO> callback);

	void logout(AsyncCallback<Void> callback);

}
