package com.epam.jdi.light.elements.init;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class InClass {
    String text;

    public InClass(String text) {
        this.text = text;
    }

    public void in(String locator) {
        $(locator).input(text);
    }
}
