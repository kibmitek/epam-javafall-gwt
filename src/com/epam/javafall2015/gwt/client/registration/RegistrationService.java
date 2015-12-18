package com.epam.javafall2015.gwt.client.registration;

import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registration")
public interface RegistrationService extends RemoteService{ 
	UserDTO submit(String login, String email, String password,
			String firstName, String lastName, String gender);
}
