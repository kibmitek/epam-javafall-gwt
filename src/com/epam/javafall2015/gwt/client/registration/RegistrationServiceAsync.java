package com.epam.javafall2015.gwt.client.registration;

import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationServiceAsync {
	void submit(String login, String email, String password, 
			String firstName, String lastName, String gender,
			 AsyncCallback<UserDTO> callback);
}
