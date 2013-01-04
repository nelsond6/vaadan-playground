package com.vaadan.playground.examples.embeddedapp;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

@Theme("playground")
public class VaadinDemoApp extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        Label lbl = new Label("This is a Vaadin application");
        layout.addComponent(lbl);
        Button btn = new Button("Don't Click Me");
        btn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Notification.show("You clicked me!");
            }
        });
        layout.addComponent(btn);
        setContent(layout);
    }
}
