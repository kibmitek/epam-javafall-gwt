package com.epam.javafall2015.gwt.client.ui.web;

import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.Widget;

public class AppLoadingView extends PopupPanel{

    private final FlowPanel container = new FlowPanel();
 
    public AppLoadingView()
    {        
    	final Image ajaxImage = new Image("ajax-loader.gif");
        final Grid grid = new Grid(1, 2);  
        grid.setWidget(0, 0, ajaxImage);
        grid.setText(0, 1, "Loading...");    
        this.container.add(grid);
        add(this.container);       
    }
 
    @Override
    public Widget asWidget()
    {
        return this;
    }
 
    public void stopProcessing()
    {
        hide();
    }
 
    public void startProcessing()
    {
        center();
        show();
    }
 
    public void showWidget()
    {
        startProcessing();
    }
}
