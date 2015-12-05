package com.epam.javafall2015.gwt.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MenuBar;

public class Menu extends Composite {
	
	HorizontalPanel hPanel = new HorizontalPanel();
	private MainView main;
	
	public Menu(MainView main){
		initWidget(this.hPanel);
		this.main = main;
		this.hPanel.setBorderWidth(1);
		
		Button landscape1Btn = new Button("Landscape button 1");
		landscape1Btn.addClickHandler(new LS1ClickHandler());
		this.hPanel.add(landscape1Btn);
		
		Button landscape2Btn = new Button("Landscape button 2");
		landscape2Btn.addClickHandler(new LS2ClickHandler());
		this.hPanel.add(landscape2Btn);
		
		Button showTestDescriptionBtn = new Button("Добавить описание теста");
		showTestDescriptionBtn.addClickHandler(new TDClickHandler());
		this.hPanel.add(showTestDescriptionBtn);

		Button showQuestionaryBtn = new Button("Задать список вопросов");
		showQuestionaryBtn.addClickHandler(new TQClickHandler());
		this.hPanel.add(showQuestionaryBtn);
	}

	private class LS1ClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			main.openLandscape1();
		}
	}
	
	private class LS2ClickHandler implements ClickHandler {
		@Override
		public void onClick(ClickEvent event) {
			main.openLandscape2();
		}
	}
	
	private class TDClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			main.openTestDescription();
		}
	}
	
	private class TQClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			main.openTestQuestionary();
		}
	}
	
}
