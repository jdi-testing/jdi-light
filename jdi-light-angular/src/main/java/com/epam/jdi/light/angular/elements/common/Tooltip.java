package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;

public class Tooltip extends UIBaseElement<TextAssert> implements IsText {

    protected String tooltipLocator = ".mat-tooltip";

    public Tooltip() {
        this.core().setLocator(tooltipLocator);
    }

    public String text() {
        return this.getText();
    }

    public String color() {
        return this.css("background-color");
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
