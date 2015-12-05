package com.epam.javafall2015.gwt.client.admin;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Question extends Composite {
	VerticalPanel vPanel = new VerticalPanel();
	
	public Question() {
		Label lbl1 = new Label("Введите текст вопроса");
		
		TextArea txt = new TextArea();
		txt.setWidth("450px");
		txt.setHeight("100px");
		
		Label lbl2 = new Label("Введите варианты ответа");
		
		Button btnAddAnswer = new Button();
		btnAddAnswer.setText("Добавить ответ");

		vPanel.add(lbl1);
		vPanel.add(txt);
		vPanel.add(lbl2);
		vPanel.add(btnAddAnswer);
	}
}
