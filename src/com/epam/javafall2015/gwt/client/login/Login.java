package com.epam.javafall2015.gwt.client.login;
import com.epam.javafall2015.gwt.client.login.request.LoginService;
import com.epam.javafall2015.gwt.client.login.request.LoginServiceAsync;
import com.epam.javafall2015.gwt.client.login.view.LoginView;
import com.epam.javafall2015.gwt.client.registration.view.RegistrationView;
import com.epam.javafall2015.gwt.shared.UserDTO;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class Login implements EntryPoint {
	private LoginView loginView = GWT.create(LoginView.class);
	private final LoginServiceAsync loginService = GWT.create(LoginService.class);
	
	@Override
	public void onModuleLoad() {
		RootPanel.get().add(loginView);	
		
		loginService.isLoggedIn(new AsyncCallback<UserDTO>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(UserDTO user) {
				if (user == null) {
					// open login widget
					openLoginView();
				} else {
					if (Window.Location.getHref().contains("/tutor/")) {
						Window.Location.assign("/tutor/");
					} else {
						Window.Location.assign("/student/");
					}
				}
			}
		});
	}
	
	private void openLoginView() {
		SubmitHandler submitHandler = new SubmitHandler();
		loginView.getSubmitButton().addClickHandler(submitHandler);
		loginView.getEmailBox().addKeyUpHandler(submitHandler);
		loginView.getPasswordBox().addKeyUpHandler(submitHandler);
		loginView.getRegisterLink().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PopupPanel pp = new PopupPanel(true);
				pp.setWidget(new RegistrationView());
				pp.center();
			}
		});
		RootLayoutPanel.get().clear();
		RootLayoutPanel.get().add(loginView);
	}
	
	private class SubmitHandler implements ClickHandler, KeyUpHandler {
		public void onClick(ClickEvent event) {
			login();
		}

		public void onKeyUp(KeyUpEvent event) {
			if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
				login();
			}
		}
	}
	
	private void login(){
		disableLogin();
		loginService.login(loginView.getEmailValue(), loginView.getPasswordValue(), new AsyncCallback<UserDTO>(){
			public void onFailure(Throwable caught) {
				System.err.println("Login failed");
			}
			
			public void onSuccess(UserDTO user) {
				if(user == null){
					loginView.getMessage().setWidget(new HTML("Пользователь " +loginView.getEmailValue()+ " не существует в системе, либо пароль введен неверно.  Попробуйте еще раз."));
					enableLogin();
				} else if (user.getEmail().equals("tutor")) {
						Window.Location.assign("/tutor/");
					}
					 else if (user.getEmail().equals("student")) {
						Window.Location.assign("/student/");
					}
				}
		});
	}
	
	public void disableLogin() {
		loginView.getMessage().clear();
		loginView.getSubmitButton().setText("Checking...");
		loginView.getSubmitButton().setEnabled(false);
		loginView.getEmailBox().setEnabled(false);
		loginView.getPasswordBox().setEnabled(false);
		loginView.getRegisterLink().setEnabled(false);
	}

	public void enableLogin() {
		loginView.getSubmitButton().setText("Login");
		loginView.getSubmitButton().setEnabled(true);
		loginView.getEmailBox().setEnabled(true);
		loginView.getPasswordBox().setEnabled(true);
		loginView.getRegisterLink().setEnabled(true);
	}
	

}
