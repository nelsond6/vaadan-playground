package com.vaadan.playground;

import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;


public class HomeView extends VerticalLayout {

    public HomeView(){
        addComponent(new Label("This is the home view"));
    }
}
