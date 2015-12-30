package com.epam.javafall2015.gwt.client.registration;

import com.epam.javafall2015.gwt.client.registration.view.RegistrationView;
import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public class RegistrationClientImpl implements RegistrationClientInt{

	private final RegistrationServiceAsync registrationService;
	private RegistrationView registrationView;
	
	public RegistrationClientImpl(String url){
		this.registrationService = GWT.create(RegistrationService.class);
		ServiceDefTarget endpoint = (ServiceDefTarget) this.registrationService;
		endpoint.setServiceEntryPoint(url);
		this.registrationView = new RegistrationView();
	}
	
	@Override
	public UserDTO submit(String login, String email, String password, String firstName, String lastName, String gender) {
		this.registrationService.submit(login, email, password, firstName, lastName, gender, new DefaultCallback());
		return null;
	}
	
	private class DefaultCallback implements AsyncCallback{

		@Override
		public void onFailure(Throwable caught) {
			System.out.println("An error has occured");
		}

		@Override
		public void onSuccess(Object result) {
			System.out.println("Response received");
		}
		
	}
	
//	private TextBox login;
//	private PasswordTextBox password;
//	private PasswordTextBox repeatPassword;
//	private SubmitButton submitButton;
//
//
//
//	public TextBox getLogin() {
//		return login;
//	}
//	public void setLogin(TextBox login) {
//		this.login = login;
//	}
//	public TextBox getPassword() {
//		return password;
//	}
//	public void setPassword(PasswordTextBox password) {
//		this.password = password;
//	}
//	public TextBox getRepeatPassword() {
//		return repeatPassword;
//	}
//	public void setRepeatPassword(PasswordTextBox repeatPassword) {
//		this.repeatPassword = repeatPassword;
//	}
//	public RegistrationClientImpl() {
//		final FormPanel formPanel = new FormPanel();
//		formPanel.setStyleName("gwt-Label-Login");
//		formPanel.setMethod(FormPanel.METHOD_POST);
//		formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
//		formPanel.setAction("/myFormHandler");
//		initWidget(formPanel);
//		formPanel.setSize("203px", "247px");
//
//		VerticalPanel verticalPanel = new VerticalPanel();
//		verticalPanel.setStyleName("gwt-Label-Login");
//		formPanel.setWidget(verticalPanel);
//		verticalPanel.setSize("205px", "246px");
//
//		Label lblRegistrationForm = new Label("Registration form");
//		lblRegistrationForm.setStyleName("h3");
//		verticalPanel.add(lblRegistrationForm);
//		
//		final SimplePanel simplePanel = new SimplePanel();
//		verticalPanel.add(simplePanel);
//
//		VerticalPanel verticalPanel_1 = new VerticalPanel();
//		verticalPanel.add(verticalPanel_1);
//
//		Label lblChooseLogin = new Label("Enter login:");
//		lblChooseLogin.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		lblChooseLogin.setStyleName("gwt-Label-Login");
//		verticalPanel_1.add(lblChooseLogin);
//		lblChooseLogin.setSize("178px", "19px");
//
//		login = new TextBox();
//		login.setAlignment(TextAlignment.CENTER);
//		login.setStyleName("gwt-Label-Login");
//		verticalPanel_1.add(login);
//		login.setWidth("203px");
//
//		VerticalPanel verticalPanel_3 = new VerticalPanel();
//		verticalPanel.add(verticalPanel_3);
//
//		Label lblYourPassword = new Label("Enter password:");
//		lblYourPassword.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		lblYourPassword.setStyleName("gwt-Label-Login");
//		verticalPanel_3.add(lblYourPassword);
//		lblYourPassword.setSize("178px", "19px");
//
//		password = new PasswordTextBox();
//		password.setStyleName("gwt-Label-Login");
//		verticalPanel_3.add(password);
//		password.setWidth("203px");
//
//		VerticalPanel verticalPanel_2 = new VerticalPanel();
//		verticalPanel.add(verticalPanel_2);
//
//		Label lblRepeatPassword = new Label("Repeat password:");
//		lblRepeatPassword.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
//		lblRepeatPassword.setStyleName("gwt-Label-Login");
//		verticalPanel_2.add(lblRepeatPassword);
//
//		repeatPassword = new PasswordTextBox();
//		repeatPassword.setStyleName("gwt-Label-Login");
//		verticalPanel_2.add(repeatPassword);
//		repeatPassword.setWidth("202px");
//
//		submitButton = new SubmitButton();
//		submitButton.setText("Submit");
//		submitButton.setStyleName("gwt-Label-Login");
//		verticalPanel.add(submitButton);
//		verticalPanel.setCellHorizontalAlignment(submitButton, HasHorizontalAlignment.ALIGN_RIGHT);
//
//		formPanel.addSubmitHandler(new SubmitHandler() {
//			public void onSubmit(SubmitEvent event) {
//				if (getPassword().getText().equals(getRepeatPassword().getValue()) & !getLogin().getText().equals("")
//						& !getPassword().getValue().equals("")) {
//					//submit();
//				} else
//					Window.alert("Complete form first! \nProvide login details and make sure that passwords are same");
//			}
//
//			private void submit() {
//				registrationService.submit(getLogin().getText(), getPassword().getValue(),
//						new AsyncCallback<UserDTO>() {
//					public void onFailure(Throwable caught) {
//						simplePanel.setWidget(new HTML("That... was a mistake! \n" + caught.getMessage()));
//						Window.alert("That... was a mistake! \n" + caught.getMessage());
//					}
//
//					public void onSuccess(UserDTO token) {
//						if (token == null) {
//							simplePanel.setWidget(new HTML("???? Success registration with null ???"));
//							Window.alert("???? Success registration with null ???");
//						} else
//							simplePanel.setWidget(new HTML("Registration Succesfull! Please login with this credentials"));
//							Window.alert("Registration Succesfull! Please login with this credentials");
//							formPanel.getParent().getParent().setVisible(false);
//					}
//				});
//			}
//		});
//	}
}
