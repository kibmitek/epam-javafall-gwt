package com.epam.javafall2015.gwt.client.admin;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Answer extends Composite {
	VerticalPanel vPanel;

	public Answer(VerticalPanel vPanel){
		this.vPanel = vPanel;
		
		TextArea txt = new TextArea();
		txt.setHeight("20px");
		txt.setWidth("300px");
		
		vPanel.add(txt);
	}
}

