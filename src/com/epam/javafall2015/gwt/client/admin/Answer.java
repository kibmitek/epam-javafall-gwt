package com.epam.javafall2015.gwt.client.admin;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Answer extends Composite {
	VerticalPanel vPanel;

	public Answer(VerticalPanel vPanel){
		this.vPanel = vPanel;
		HorizontalPanel hPanel = new HorizontalPanel();
		
		TextArea txt = new TextArea();
		txt.setHeight("20px");
		txt.setWidth("300px");
		
		TextBox txtBx = new TextBox();
		Button deleteAnswer = new Button("Удалить");

		hPanel.add(txt);
		hPanel.add(txtBx);
		
		vPanel.add(hPanel);
	}
}

