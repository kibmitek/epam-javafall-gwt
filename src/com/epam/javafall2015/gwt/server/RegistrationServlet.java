package com.epam.javafall2015.gwt.server;

import java.util.UUID;

import com.epam.javafall2015.gwt.client.login.request.RegistrationService;
import com.epam.javafall2015.gwt.shared.RegistrationToken;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrationServlet extends RemoteServiceServlet implements RegistrationService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UUID uuid;

	public RegistrationToken submit(String login, String password) {
		uuid = UUID.randomUUID();
		RegistrationToken token = new RegistrationToken();
		token.setId(uuid);
		token.setLogin(login);
		token.setPassword(password);
		return token;
	}
}
