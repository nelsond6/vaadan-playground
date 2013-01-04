package com.vaadan.playground;

import com.vaadin.ui.VerticalLayout;

public class ExampleView extends VerticalLayout {

    private Example currentExample;

    public ExampleView(){
       setSizeFull();

    }

    public void setExample(Example example){
        if(example != currentExample){
            currentExample = example;
            removeAllComponents();
            addComponent(example.getExample());
        }
    }

}
