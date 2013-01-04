package com.vaadan.playground;

import com.vaadin.annotations.Theme;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Theme("playground")
public class PlaygroundUI extends UI
{

    private final ExampleView exampleView = new ExampleView();

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        setupUriFragmentListener();
    }

    private void setupLayout(){
        VerticalLayout layout = new VerticalLayout();

        //header
        HorizontalLayout header = new HorizontalLayout();
        header.setWidth("100%");
        header.setHeight("44px");
        header.setStyleName("header");
        header.setSpacing(true);

        Button btn1 = new Button("Test 1");
        header.addComponent(btn1);
        header.setComponentAlignment(btn1, Alignment.MIDDLE_LEFT);

        Button btn2 = new Button("Test 2");
        header.addComponent(btn2);
        header.setExpandRatio(btn2, 1);
        header.setComponentAlignment(btn2, Alignment.MIDDLE_LEFT);

        Button btn3 = new Button("Test 3");
        header.addComponent(btn3);
        header.setComponentAlignment(btn3, Alignment.MIDDLE_LEFT);

        layout.addComponent(header);

        layout.addComponent(exampleView);
        setContent(layout);
    }

    private void setupUriFragmentListener(){
        //listen for URI fragment changes
        getPage().addUriFragmentChangedListener(new Page.UriFragmentChangedListener() {
            @Override
            public void uriFragmentChanged(Page.UriFragmentChangedEvent uriFragmentChangedEvent) {
                handleUriFragmentChange(uriFragmentChangedEvent.getUriFragment());
            }
        });

        //handle initial Uri fragment
        String uriFragment = getPage().getUriFragment();
        if(uriFragment == null){
            //no fragment was found so go to examples home
            getPage().setUriFragment("home");
        }
        else {
            handleUriFragmentChange(uriFragment);
        }
    }

    private void handleUriFragmentChange(String uriFragment) {
        if(uriFragment.equals("home")){
            Notification.show("Choose an example from above.");
        }else {
            Example example = ExampleSet.EXAMPLES.getExample(uriFragment);
            if(example == null){
                Notification.show("The example "+uriFragment+" does not exist.  Maybe try again...");
            }
            else {
                setExample(example);
            }
        }
    }

    private void setExample(Example example){
        exampleView.setExample(example);
    }

}
