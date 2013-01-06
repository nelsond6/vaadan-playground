package com.vaadan.playground;

import com.vaadin.ui.Component;

import java.util.ArrayList;
import java.util.List;

abstract public class Example {

    final protected String basePath = "src/main/";
    final protected String javaBasePath = basePath+"java/";
    final protected String themesBasePath = basePath+"webapp/VAADIN/themes/";
    final protected String themesPlaygroundBasePath = themesBasePath + "playground/";
    final protected String themesPlaygroundExamplesBasePath = themesPlaygroundBasePath+"examples/";

    abstract public String getName();

    public String getFragmentName(){
        return getClass().getSimpleName();
    }

    private String getExampleSourcePath(){
        String fullClassPath = getExampleClassObject().getName();
        fullClassPath = fullClassPath.replace(".","/")+".java";
        return javaBasePath+fullClassPath;
    }

    public List<String> getSources(){
        List<String> sources = new ArrayList<String>();
        sources.add(getExampleSourcePath());

        List<String> additionalSources = getAdditionalSources();
        if(additionalSources != null){
            sources.addAll(additionalSources);
        }

        return sources;
    }

    public List<String> getAdditionalSources(){
        return null;
    }

    public Component getExample(){
        try {
            Class<?> classObject = getExampleClassObject();
            return (Component) classObject.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
         return null;
    }

    private String getExampleClassName(){
        return getClass().getName() + "Example";
    }

    private Class<?> getExampleClassObject(){
        Class<?> classObject = null;
        try {
            classObject = getClass().getClassLoader().loadClass(getExampleClassName());
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return classObject;
    }




}
