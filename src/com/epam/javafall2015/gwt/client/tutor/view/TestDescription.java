package com.epam.javafall2015.gwt.client.tutor.view;

import com.epam.javafall2015.gwt.client.tutor.MainView;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TestDescription extends Composite {
	DecoratorPanel decoratorPanel = new DecoratorPanel();
	VerticalPanel vPanel = new VerticalPanel();
	private MainView main;
	
	public TestDescription(MainView main){
		initWidget(this.decoratorPanel);
		this.main = main;
		
		Label lbl1 = new Label("Введите описание всего теста.");
		Label lbl2 = new Label("Этот текст будет виден респонденту.");
		
		TextArea txt = new TextArea();
		txt.setHeight("100px");
		txt.setWidth("450px");
		//TODO: set Description text from Data Base.
		
		Button saveBtn = new Button("Сохранить");
		saveBtn.addClickHandler(new SaveBtnHandler());
		
		this.vPanel.add(lbl1);
		this.vPanel.add(lbl2);
		this.vPanel.add(txt);
		this.vPanel.add(saveBtn);
		
		this.decoratorPanel.add(vPanel);
	}
	
//	private void openTestsFillingPage(){
//		main.openTestsFillingPage();
//	}
	
	private class SaveBtnHandler implements ClickHandler{
	@Override
	public void onClick(ClickEvent event) {
//		TODO: save test description into the DB
	}
		
	}
}
