package com.epam.javafall2015.gwt.client.admin;

import com.epam.javafall2015.gwt.client.MainView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestQuestionary extends Composite {
	VerticalPanel vPanel = new VerticalPanel();
	MainView main;
	
	public TestQuestionary(MainView main) {
		initWidget(vPanel);
		this.main = main;
		
		Label lbl = new Label("Вопросник");
		Button btn = new Button();
		btn.setText("Добавить вопрос");
		btn.addClickHandler(new AddQuestionHandler());
		
		vPanel.add(lbl);
		vPanel.add(btn);
	}
	
	private class AddQuestionHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			main.openOneMoreQuestion();
		}
	}
}
