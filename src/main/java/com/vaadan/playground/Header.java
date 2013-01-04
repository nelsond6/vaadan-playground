package com.vaadan.playground;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.*;

import java.util.List;

public class Header extends HorizontalLayout {

    private Example currentExample;

    public Header(){
        setWidth("100%");
        setHeight("50px");
        setStyleName("header");
        setSpacing(true);

        BeanItemContainer<Example> examples = new BeanItemContainer<Example>(Example.class);
        List<Example> theExamples = ExampleSet.EXAMPLES.getExamples();
        examples.addAll(theExamples);

        ComboBox examplesCB = new ComboBox();
        examplesCB.setContainerDataSource(examples);
        examplesCB.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        examplesCB.setItemCaptionPropertyId("name");
        examplesCB.setNullSelectionAllowed(false);
        examplesCB.setInputPrompt("Choose an example");
        addComponent(examplesCB);
        setComponentAlignment(examplesCB, Alignment.MIDDLE_LEFT);


        /*Button btn1 = new Button("Test 1");
        addComponent(btn1);
        setComponentAlignment(btn1, Alignment.MIDDLE_LEFT);

        Button btn2 = new Button("Test 2");
        addComponent(btn2);
        setExpandRatio(btn2, 1);
        setComponentAlignment(btn2, Alignment.MIDDLE_LEFT);

        Button btn3 = new Button("Test 3");
        addComponent(btn3);
        setComponentAlignment(btn3, Alignment.MIDDLE_LEFT);*/


    }

    public void setExample(Example example){
         currentExample = example;
    }
}
