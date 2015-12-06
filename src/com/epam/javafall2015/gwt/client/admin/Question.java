package com.epam.javafall2015.gwt.client.admin;

import com.epam.javafall2015.gwt.client.MainView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Question extends Composite {
	VerticalPanel vPanel = new VerticalPanel();
	MainView main;
		
	public Question(MainView main) {
		initWidget(vPanel);
		this.main = main;
		
		Label lbl1 = new Label("Введите текст вопроса");
		
		TextArea txt = new TextArea();
		txt.setWidth("500px");
		txt.setHeight("70px");
		
	    ListBox list = new ListBox();
	    list.setVisibleItemCount(1);
	    for (int i = 10; i > 0; i--) {
	      list.addItem("Группа " + i);
	    }
		
		Label lbl2 = new Label("Введите варианты ответа");
		
		Button btnAddAnswer = new Button();
		btnAddAnswer.setText("Добавить ответ");
		btnAddAnswer.addClickHandler(new AABtnClickHandler());
		
		Button btnRemoveQuestion = new Button();
		btnRemoveQuestion.setText("Удалить вопрос");
		btnRemoveQuestion.addClickHandler(new RQBtnClickHandler());

		this.vPanel.add(lbl1);
		vPanel.add(txt);
		vPanel.add(list);
		vPanel.add(lbl2);
		vPanel.add(btnAddAnswer);
		vPanel.add(btnRemoveQuestion);
	}
	
	private class AABtnClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			addAnswerForm();
		}
	}
	
	private class RQBtnClickHandler implements ClickHandler{
		@Override
		public void onClick(ClickEvent event) {
			removeQuestion();
		}
	}
	
	private void addAnswerForm(){
		Answer answer = new Answer(this.vPanel);
		this.vPanel.add(answer);
	}
	
	private void removeQuestion(){
		main.removeWidget(this);
	}
	
}
