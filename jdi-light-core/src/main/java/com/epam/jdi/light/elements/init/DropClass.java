package com.epam.jdi.light.elements.init;

import com.epam.jdi.light.elements.common.UIElement;

import static com.epam.jdi.light.elements.init.UIFactory.$;

public class DropClass {
    UIElement dragElement;

    public DropClass(String locator) {
        this.dragElement = $(locator);
    }

    public void andDropTo(String locator) {
        dragElement.dragAndDropTo($(locator));
    }
}
