package com.epam.javafall2015.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class UserDTO implements IsSerializable{
	private int id;
	private String login;
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
