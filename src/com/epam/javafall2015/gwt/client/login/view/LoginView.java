package com.epam.javafall2015.gwt.client.login.view;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite {

	private static LoginViewUiBinder uiBinder = GWT
			.create(LoginViewUiBinder.class);

	interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
	}

	@UiField TextBox email;
	@UiField PasswordTextBox password;
	@UiField Button submit_button;
	@UiField Anchor register_link;
	@UiField SimplePanel message;

	
	public LoginView() {
		initWidget(uiBinder.createAndBindUi(this));
		submit_button.setText("Login");
		register_link.setText("Not register yet?");
	}
	
	public String getEmailValue(){
		return email.getValue();
	}
	public String getPasswordValue(){
		return getHash(password.getValue());
	}
	public Button getSubmitButton(){
		return submit_button;
	}
	public Anchor getRegisterLink(){
		return register_link;
	}
	public TextBox getEmailBox(){
		return email;
	}
	public PasswordTextBox getPasswordBox(){
		return password;
	}
	public SimplePanel getMessage(){
		return message;
	}
	
	public String getHash(String text){
		byte[] salt = new byte[16];
		Random random = new Random();
		random.nextBytes(salt);
		KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
		SecretKeyFactory f = null;
		try {
			f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] hash;
		try {
			hash = f.generateSecret(spec).getEncoded();
			Base64.Encoder enc = Base64.getEncoder();
			System.out.printf("salt: %s%n", enc.encodeToString(salt));
			System.out.printf("hash: %s%n", enc.encodeToString(hash));
			return enc.encodeToString(hash);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}
