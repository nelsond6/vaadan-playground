package com.vaadan.playground;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;


public class ExampleView extends HorizontalLayout {

    private VerticalLayout main;

    private Example currentExample;

    public ExampleView(){
       setSizeFull();
       main = new VerticalLayout();
       main.setSizeFull();
       addComponent(main);
    }


    public void setExample(Example example){
        if(example != currentExample){
            currentExample = example;
            main.removeAllComponents();
            main.addComponent(example.getExample());
        }
    }

}
