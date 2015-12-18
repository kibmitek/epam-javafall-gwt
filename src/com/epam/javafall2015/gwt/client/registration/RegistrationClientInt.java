package com.epam.javafall2015.gwt.client.registration;

import com.epam.javafall2015.gwt.shared.UserDTO;

public interface RegistrationClientInt {
	UserDTO submit(String login, String email, String password,
			String firstName, String lastName, String gender);
}
