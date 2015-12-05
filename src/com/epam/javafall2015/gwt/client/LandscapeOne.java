package com.epam.javafall2015.gwt.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LandscapeOne extends Composite {

	private VerticalPanel vPanel = new VerticalPanel();
	private MainView main;
	
	public LandscapeOne(MainView main){
		initWidget(this.vPanel);
		this.main = main;
		
		Image landscape1 = new Image("images/unnamed1.jpg");
		landscape1.setWidth("600px");
		this.vPanel.add(landscape1);
		
		Anchor anchor = new Anchor("Go to Landscape Two");
		anchor.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				openLanscapeTwo();
			}
		});
		this.vPanel.add(anchor);
	}
	private void openLanscapeTwo(){
		main.openLandscape2();
	}
	
}
