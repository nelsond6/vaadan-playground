package com.vaadan.playground;


import com.vaadan.playground.examples.embeddedapp.EmbeddedVaadinApp;
import com.vaadan.playground.examples.test.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ExampleSet {


    public static final ExampleSet EXAMPLES = new ExampleSet(new Example[]{
        new EmbeddedVaadinApp(),
        new Test()
    });

    private static HashMap<String, Example> exampleList;

    private final Example[] content;

    public ExampleSet(Example[] examples){
       if(exampleList == null){
           exampleList = new HashMap<String, Example>();
       }

       this.content = examples;

       for (Example example : examples){
           String fragmentName = example.getFragmentName();
            if(exampleList.containsKey(fragmentName)){
                throw new IllegalArgumentException("Duplicate example was added:"+fragmentName);
            }
           exampleList.put(fragmentName.toLowerCase(), example);
       }
    }

    public Example getExample(String exampleFragmentName){
        return exampleList.get(exampleFragmentName.toLowerCase());
    }

    public List<Example> getExamples(){
        return Arrays.asList(content);
    }


}

