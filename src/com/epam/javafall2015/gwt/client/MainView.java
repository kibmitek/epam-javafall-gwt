package com.epam.javafall2015.gwt.client;

import com.epam.javafall2015.gwt.client.tutor.view.Question;
import com.epam.javafall2015.gwt.client.tutor.view.TestDescription;
import com.epam.javafall2015.gwt.client.tutor.view.TestQuestionary;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class MainView extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private VerticalPanel contentPanel;
	
	public MainView(){
		initWidget(this.vPanel);
		this.vPanel.setBorderWidth(1);
		
		Menu menu = new Menu(this);
		this.vPanel.add(menu);
		
		this.contentPanel = new VerticalPanel();
		this.vPanel.add(contentPanel);
		
		Label textLbl = new Label("press the button to see a nice landscape!");
		this.contentPanel.add(textLbl);
	}
	
	public void openTestDescription(){
		this.contentPanel.clear();
		TestDescription testDescription = new TestDescription(this);
		this.contentPanel.add(testDescription);
	}
	
	public void openTestQuestionary(){
		this.contentPanel.clear();
		TestQuestionary testQuestionary = new TestQuestionary(this);
		this.contentPanel.add(testQuestionary);
	}
	
	public void openOneMoreQuestion(){
		Question question = new Question(this);
		this.contentPanel.add(question);
	}
	
	public void removeWidget(Widget widget){
		this.contentPanel.remove(widget);
	}
	
}
