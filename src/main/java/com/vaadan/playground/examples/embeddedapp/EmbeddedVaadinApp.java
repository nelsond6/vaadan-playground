package com.vaadan.playground.examples.embeddedapp;

import com.vaadan.playground.Example;

import java.util.ArrayList;
import java.util.List;

public class EmbeddedVaadinApp extends Example {

    @Override
    public String getName() {
        return "Embedded Vaadin App";
    }

    @Override
    public List<String> getAdditionalSources(){
        List<String> sources = new ArrayList<String>();
        sources.add(themesPlaygroundExamplesBasePath+"embeddedapp/existingapplication.html");
        sources.add(javaBasePath+getClass().getPackage().getName().replace(".","/")+"/VaadinDemoApp.java");
        return sources;
    }


}
