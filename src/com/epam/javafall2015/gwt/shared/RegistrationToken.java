package com.epam.javafall2015.gwt.shared;

import java.util.UUID;

import com.google.gwt.user.client.rpc.IsSerializable;

public class RegistrationToken implements IsSerializable {
	private UUID id;
	private String login;
	private String password;
	
	public UUID getId(){
		return id;
	}
	public String getLogin(){
		return login;
	}
	public String getPassword(){
		return password;
	}
	public void setId(UUID id){
		this.id = id;
	}
	public void setLogin(String login){
		this.login = login;
	}
	public void setPassword(String password){
		this.password = password;
	}
}