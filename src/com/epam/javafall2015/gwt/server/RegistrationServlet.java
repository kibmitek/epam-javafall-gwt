package com.epam.javafall2015.gwt.server;

import java.util.Random;

import com.epam.javafall2015.gwt.client.login.request.RegistrationService;
import com.epam.javafall2015.gwt.shared.RegistrationToken;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class RegistrationServlet extends RemoteServiceServlet implements RegistrationService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long uuid;

	public RegistrationToken submit(String login, String password) {
		Random rand = new Random();
		uuid = rand.nextLong();
		RegistrationToken token = new RegistrationToken();
		token.setId(uuid);
		token.setLogin(login);
		token.setPassword(password);
		return token;
	}
}
