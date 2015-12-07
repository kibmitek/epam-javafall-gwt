package com.epam.javafall2015.gwt.client.login.request;

import com.epam.javafall2015.gwt.shared.RegistrationToken;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RegistrationServiceAsync {
	void submit(String login, String password, AsyncCallback<RegistrationToken> asyncCallback);
}
