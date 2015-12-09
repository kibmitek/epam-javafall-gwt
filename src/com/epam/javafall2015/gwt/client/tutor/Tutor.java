package com.epam.javafall2015.gwt.client.tutor;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Tutor implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		MainView mainView = new MainView();
		RootPanel.get().add(mainView);
	}
}
