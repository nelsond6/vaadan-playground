package com.vaadan.playground;

import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;

import java.util.List;


public class SourceView extends Window {

    final private Example currentExample;

    public SourceView(Example example){
        super(example.getName()+" Source");
        currentExample = example;

        VerticalLayout layout = new VerticalLayout();
        layout.setSpacing(false);
        List<String> sources = example.getSources();
        for(String source : sources){
            Link link = new Link(source,new ExternalResource("https://github.com/nelsond6/vaadan-playground/blob/master/"+source));
            link.setTargetName("_blank");
            layout.addComponent(link);
        }

        Label expandingLabel = new Label("");
        expandingLabel.setHeight("100%");
        layout.addComponent(expandingLabel);
        layout.setExpandRatio(expandingLabel, 1.0f);

        setContent(layout);
        setPositionX(100);
        setPositionY(100);
    }


}
