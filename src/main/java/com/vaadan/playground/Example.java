package com.vaadan.playground;

import com.vaadin.ui.Component;

abstract public class Example {

    abstract public String getName();

    public String getFragmentName(){
        return getClass().getSimpleName();
    }

    public Component getExample(){
        String className = this.getClass().getName() + "Example";
        try {
            Class<?> classObject = getClass().getClassLoader().loadClass(className);
            return (Component) classObject.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
         return null;
    }


}
