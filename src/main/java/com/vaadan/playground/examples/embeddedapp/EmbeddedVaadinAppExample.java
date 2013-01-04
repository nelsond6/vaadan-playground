package com.vaadan.playground.examples.embeddedapp;


import com.vaadin.server.ThemeResource;
import com.vaadin.ui.*;

public class EmbeddedVaadinAppExample extends HorizontalLayout {

    public EmbeddedVaadinAppExample(){
        Embedded content = new Embedded("", new ThemeResource("examples/embeddedapp/existingapplication.html"));
        content.setType(Embedded.TYPE_BROWSER);
        content.setWidth("100%");
        content.setHeight("500px");

        addComponent(content);

        setSizeFull();

        /*Button myButton = new Button("My button 3");
        addComponent(myButton);
        setComponentAlignment(myButton, Alignment.BOTTOM_RIGHT);*/

    }

}