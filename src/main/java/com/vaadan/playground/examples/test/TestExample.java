package com.vaadan.playground.examples.test;


import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class TestExample extends VerticalLayout {

    public TestExample(){
        addComponent(new Label("Test example content goes here 1"));
        addComponent(new Label("Test example content goes here 2"));
        addComponent(new Label("Test example content goes here 3"));
    }
}
