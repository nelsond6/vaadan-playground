package com.vaadan.playground.examples.horizontallayoutalignment;

import com.vaadin.ui.*;


public class HorizontalLayoutAlignmentExample extends VerticalLayout {

    final private String baseStyleName  = getClass().getSimpleName()+"-";

    public HorizontalLayoutAlignmentExample(){

        setSpacing(true);

        //default behavior
        HorizontalLayout defaultLayout = new HorizontalLayout();
        defaultLayout.setWidth("100%");
        defaultLayout.setHeight("50px");
        defaultLayout.setCaption("Default Alignment Behavior");
        Button btn1 = new Button("Btn 1");
        defaultLayout.addComponent(btn1);
        defaultLayout.setComponentAlignment(btn1, Alignment.MIDDLE_LEFT);
        Button btn2 = new Button("Btn 2");
        defaultLayout.addComponent(btn2);
        defaultLayout.setComponentAlignment(btn2, Alignment.MIDDLE_LEFT);
        Button btn3 = new Button("Btn 3");
        defaultLayout.addComponent(btn3);
        defaultLayout.setComponentAlignment(btn3, Alignment.MIDDLE_LEFT);
        defaultLayout.setStyleName(baseStyleName+"default-behavior");
        addComponent(defaultLayout);

        //left aligned
        HorizontalLayout leftAligned = new HorizontalLayout();
        leftAligned.setWidth("100%");
        leftAligned.setHeight("50px");
        leftAligned.setCaption("Left Aligned");
        btn1 = new Button("Btn 1");
        leftAligned.addComponent(btn1);
        leftAligned.setComponentAlignment(btn1, Alignment.MIDDLE_LEFT);
        btn2 = new Button("Btn 2");
        leftAligned.addComponent(btn2);
        leftAligned.setComponentAlignment(btn2, Alignment.MIDDLE_LEFT);
        btn3 = new Button("Btn 3");
        leftAligned.addComponent(btn3);
        leftAligned.setComponentAlignment(btn3, Alignment.MIDDLE_LEFT);
        Label expandingGap = new Label();
        expandingGap.setWidth("100%");
        leftAligned.addComponent(expandingGap);
        leftAligned.setExpandRatio(expandingGap, 1.0f);
        leftAligned.setStyleName(baseStyleName+"default-behavior");
        addComponent(leftAligned);

        //right aligned
        HorizontalLayout rightAligned = new HorizontalLayout();
        rightAligned.setWidth("100%");
        rightAligned.setHeight("50px");
        rightAligned.setCaption("Right Aligned");
        expandingGap = new Label();
        expandingGap.setWidth("100%");
        rightAligned.addComponent(expandingGap);
        rightAligned.setExpandRatio(expandingGap, 1.0f);
        btn1 = new Button("Btn 1");
        rightAligned.addComponent(btn1);
        rightAligned.setComponentAlignment(btn1, Alignment.MIDDLE_RIGHT);
        btn2 = new Button("Btn 2");
        rightAligned.addComponent(btn2);
        rightAligned.setComponentAlignment(btn2, Alignment.MIDDLE_RIGHT);
        btn3 = new Button("Btn 3");
        rightAligned.addComponent(btn3);
        rightAligned.setComponentAlignment(btn3, Alignment.MIDDLE_RIGHT);
        rightAligned.setStyleName(baseStyleName+"default-behavior");
        addComponent(rightAligned);

        //both left and right aligned
        HorizontalLayout leftRightAlign = new HorizontalLayout();
        leftRightAlign.setWidth("100%");
        leftRightAlign.setHeight("50px");
        leftRightAlign.setCaption("Left and Right Aligned");
        btn1 = new Button("Btn 1");
        leftRightAlign.addComponent(btn1);
        leftRightAlign.setComponentAlignment(btn1, Alignment.MIDDLE_LEFT);
        btn2 = new Button("Btn 2");
        leftRightAlign.addComponent(btn2);
        leftRightAlign.setComponentAlignment(btn2, Alignment.MIDDLE_LEFT);
        btn3 = new Button("Btn 3");
        leftRightAlign.addComponent(btn3);
        leftRightAlign.setComponentAlignment(btn3, Alignment.MIDDLE_LEFT);
        expandingGap = new Label();
        expandingGap.setWidth("100%");
        leftRightAlign.addComponent(expandingGap);
        leftRightAlign.setExpandRatio(expandingGap, 1.0f);
        btn1 = new Button("Btn 4");
        leftRightAlign.addComponent(btn1);
        leftRightAlign.setComponentAlignment(btn1, Alignment.MIDDLE_RIGHT);
        btn2 = new Button("Btn 5");
        leftRightAlign.addComponent(btn2);
        leftRightAlign.setComponentAlignment(btn2, Alignment.MIDDLE_RIGHT);
        btn3 = new Button("Btn 6");
        leftRightAlign.addComponent(btn3);
        leftRightAlign.setComponentAlignment(btn3, Alignment.MIDDLE_RIGHT);
        leftRightAlign.setStyleName(baseStyleName+"default-behavior");
        addComponent(leftRightAlign);

        CssLayout cssLeftAligned = new CssLayout();
        cssLeftAligned.setCaption("Using CSS Layout to left align");
        cssLeftAligned.setWidth("100%");
        cssLeftAligned.setHeight("50px");
        cssLeftAligned.addComponent(new Button("Btn 1"));
        cssLeftAligned.addComponent(new Button("Btn 2"));
        cssLeftAligned.addComponent(new Button("Btn 3"));
        cssLeftAligned.setStyleName(baseStyleName+"cssLeftAligned");
        addComponent(cssLeftAligned);

        CssLayout cssLeftAlignedVertical = new CssLayout();
        cssLeftAlignedVertical.setCaption("Using CSS Layout to left align and vertically center elements");
        cssLeftAlignedVertical.setWidth("100%");
        cssLeftAlignedVertical.setHeight("50px");
        CssLayout innerDiv = new CssLayout();
        innerDiv.addComponent(new Button("Btn 1"));
        innerDiv.addComponent(new Button("Btn 2"));
        innerDiv.addComponent(new Button("Btn 3"));
        innerDiv.setStyleName(baseStyleName+"cssLeftAlignedVertical-innerDiv");
        cssLeftAlignedVertical.addComponent(innerDiv);
        cssLeftAlignedVertical.setStyleName(baseStyleName+"cssLeftAlignedVertical");
        addComponent(cssLeftAlignedVertical);


    }

}
