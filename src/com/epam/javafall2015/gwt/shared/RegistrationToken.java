package com.epam.javafall2015.gwt.shared;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RegistrationToken implements IsSerializable {
	private long id;
	private String login;
	private String password;
	
	public long getId(){
		return id;
	}
	public String getLogin(){
		return login;
	}
	public String getPassword(){
		return password;
	}
	public void setId(long id){
		this.id = id;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public void setPassword(String password){
		this.password = password;
	}
}