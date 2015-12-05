package com.epam.javafall2015.gwt.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LandscapeTwo extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private MainView main;
	
	public LandscapeTwo(MainView main){
		initWidget(this.vPanel);
		this.main = main;
		
		Image landscape2 = new Image("images/Workflow_log.png");
		landscape2.setWidth("600px");
		this.vPanel.add(landscape2);
		
		Anchor anchor = new Anchor("Go to Landscape One");
		anchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				openLandscape1();
			}
		});
		this.vPanel.add(anchor);
	}
	private void openLandscape1(){
		main.openLandscape1();
	}
}