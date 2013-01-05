package com.vaadan.playground;

import com.vaadin.data.Property;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.event.LayoutEvents;
import com.vaadin.ui.*;

import java.util.List;

public class Header extends HorizontalLayout {

    final private ObjectProperty<Example> currentExample;

    final private Button viewSourceBtn;
    final private Button viewInfoBtn;

    public Header(ObjectProperty<Example> currentExample){
        this.currentExample = currentExample;

        setWidth("100%");
        setHeight("40px");
        setStyleName("header");
        setSpacing(true);

        CssLayout logo = new CssLayout();
        logo.setStyleName("logo");
        addComponent(logo);
        setComponentAlignment(logo, Alignment.MIDDLE_LEFT);
        logo.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                UI.getCurrent().getPage().setUriFragment("home");
            }
        });

        BeanItemContainer<Example> examples = new BeanItemContainer<Example>(Example.class);
        List<Example> theExamples = ExampleSet.EXAMPLES.getExamples();
        examples.addAll(theExamples);

        final ComboBox examplesCB = new ComboBox();
        examplesCB.setContainerDataSource(examples);
        examplesCB.setItemCaptionMode(AbstractSelect.ItemCaptionMode.PROPERTY);
        examplesCB.setItemCaptionPropertyId("name");
        examplesCB.setNullSelectionAllowed(false);
        examplesCB.setInputPrompt("Choose an example");
        examplesCB.setImmediate(true);
        examplesCB.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Example selectedValue = (Example)valueChangeEvent.getProperty().getValue();
                if(selectedValue != null){ //it will be null if use goes back to home view
                    //set the Uri fragment to selected example
                    UI.getCurrent().getPage().setUriFragment(selectedValue.getFragmentName());
                }
            }
        });
        addComponent(examplesCB);
        setComponentAlignment(examplesCB, Alignment.MIDDLE_LEFT);

        viewSourceBtn = new Button("Source");
        addComponent(viewSourceBtn);
        viewSourceBtn.setVisible(false);
        setComponentAlignment(viewSourceBtn, Alignment.MIDDLE_LEFT);
        viewSourceBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                displaySource();
            }
        });

        viewInfoBtn = new Button("Info");
        addComponent(viewInfoBtn);
        viewInfoBtn.setVisible(false);
        setComponentAlignment(viewInfoBtn, Alignment.MIDDLE_LEFT);
        viewInfoBtn.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                displayInfo();
            }
        });

        //this will push the logo,combobox,source and info buttons to the left and everything else to the right
        Label expandingGap = new Label();
        expandingGap.setWidth("100%");
        addComponent(expandingGap);
        setExpandRatio(expandingGap, 1.0f);

        currentExample.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Example example = (Example)valueChangeEvent.getProperty().getValue();
                if(example != null){
                    examplesCB.setValue(example);
                    viewSourceBtn.setVisible(true);
                    viewInfoBtn.setVisible(true);
                }
                else {
                    //home is showing, so hide all the buttons and reset the combobox
                    viewSourceBtn.setVisible(false);
                    viewInfoBtn.setVisible(false);
                    examplesCB.setValue(null);
                }
            }
        });

    }

    private void displaySource(){
        Example example = (Example)currentExample.getValue();
        Notification.show("Show source for:"+example.getName());
    }

    private void displayInfo(){
        Example example = (Example)currentExample.getValue();
        Notification.show("Show info for:"+example.getName());
    }


}
