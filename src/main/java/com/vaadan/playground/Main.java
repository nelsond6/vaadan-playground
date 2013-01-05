package com.vaadan.playground;

import com.vaadin.data.Property;
import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.VerticalLayout;

public class Main extends VerticalLayout {

    final private ObjectProperty<Example> currentExample;
    private HomeView homeView = new HomeView();

    public Main(ObjectProperty<Example> currentExample){
       this.currentExample = currentExample;
       setSizeFull();

       currentExample.addValueChangeListener(new Property.ValueChangeListener() {
            @Override
            public void valueChange(Property.ValueChangeEvent valueChangeEvent) {
                Example example = (Example)valueChangeEvent.getProperty().getValue();
                if(example != null){
                    setExample(example);
                }
                else {
                    //since example is null, just show the home screen
                    removeAllComponents();
                    addComponent(homeView);
                }
            }
       });

    }

   private void setExample(Example example){
        removeAllComponents();
        addComponent(example.getExample());
    }

}
