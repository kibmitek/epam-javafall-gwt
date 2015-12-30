package com.epam.javafall2015.gwt.client.registration.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class RegistrationView extends Composite {

		private static RegistrationViewUiBinder uiBinder = GWT
				.create(RegistrationViewUiBinder.class);

		interface RegistrationViewUiBinder extends UiBinder<Widget, RegistrationView> {
		}

		@UiField TextBox login;
		@UiField TextBox email;
		@UiField PasswordTextBox password;
		@UiField PasswordTextBox repeat_password;
		@UiField TextBox firstname;
		@UiField TextBox lastname;
		@UiField ListBox gender;
		@UiField RadioButton male;
		@UiField RadioButton female;
		@UiField Button submit_button;
		@UiField SimplePanel message;

		
		public RegistrationView() {
			initWidget(uiBinder.createAndBindUi(this));
			submit_button.setText("Submit");
		}
		
		public String getLoginValue(){
			return login.getValue();
		}
		public String getEmailValue(){
			return email.getValue();
		}
		public String getPasswordValue(){
			return password.getValue();
		}
		public String getPasswordRepeatValue(){
			return repeat_password.getValue();
		}
		public String getFNValue(){
			return firstname.getValue();
		}
		public String getLNValue(){
			return lastname.getValue();
		}
		public String getGenderValue(){
			return gender.getSelectedValue();
		}
		public String getSex(){// :)
			if(male.getValue()){
				return male.getFormValue();
			}
			else if(female.getValue()){
				return female.getFormValue();
			}
			return null;
		}

		
//		public Button getSubmitButton(){
//			return submit_button;
//		}
//		public TextBox getEmailBox(){
//			return email;
//		}
//		public PasswordTextBox getPasswordBox(){
//			return password;
//		}
//		public SimplePanel getMessage(){
//			return message;
//		}
		
//		public String getHash(String text){
//			byte[] salt = new byte[16];
//			Random random = new Random();
//			random.nextBytes(salt);
//			KeySpec spec = new PBEKeySpec("password".toCharArray(), salt, 65536, 128);
//			SecretKeyFactory f = null;
//			try {
//				f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//			} catch (NoSuchAlgorithmException e) {
//				e.printStackTrace();
//			}
//			byte[] hash;
//			try {
//				hash = f.generateSecret(spec).getEncoded();
//				Base64.Encoder enc = Base64.getEncoder();
//				System.out.printf("salt: %s%n", enc.encodeToString(salt));
//				System.out.printf("hash: %s%n", enc.encodeToString(hash));
//				return enc.encodeToString(hash);
//			} catch (InvalidKeySpecException e) {
//				e.printStackTrace();
//			}
//			return "";
//		}
		

}
