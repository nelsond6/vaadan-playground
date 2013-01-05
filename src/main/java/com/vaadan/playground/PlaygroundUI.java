package com.vaadan.playground;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
@Theme("playground")
public class PlaygroundUI extends UI
{
    private final ObjectProperty<Example> currentExample = new ObjectProperty<Example>(null, Example.class);
    private final Header header = new Header(currentExample);
    private final Main main = new Main(currentExample);

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        setupUriFragmentListener();
    }

    private void setupLayout(){
        VerticalLayout layout = new VerticalLayout();

        layout.addComponent(header);
        layout.addComponent(main);

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
            setExample(null);
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
        currentExample.setValue(example);
    }

}
