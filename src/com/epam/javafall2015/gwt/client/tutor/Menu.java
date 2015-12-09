package com.epam.javafall2015.gwt.client.tutor;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;

public class Menu extends Composite {
	
	HorizontalPanel hPanel = new HorizontalPanel();
	private MainView main;
	
	public Menu(MainView main){
		initWidget(this.hPanel);
		this.main = main;
		this.hPanel.setBorderWidth(1);
		
		Button showTestDescriptionBtn = new Button("Добавить описание теста");
		showTestDescriptionBtn.addClickHandler(new TDClickHandler());
		this.hPanel.add(showTestDescriptionBtn);

		Button showQuestionaryBtn = new Button("Задать список вопросов");
		showQuestionaryBtn.addClickHandler(new TQClickHandler());
		this.hPanel.add(showQuestionaryBtn);
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
