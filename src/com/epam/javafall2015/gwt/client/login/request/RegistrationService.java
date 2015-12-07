package com.epam.javafall2015.gwt.client.login.request;

import com.epam.javafall2015.gwt.shared.RegistrationToken;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("registration.rpc")
public interface RegistrationService extends RemoteService{ 
	RegistrationToken submit(String login, String password);
}
