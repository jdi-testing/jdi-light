package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.Label;

public class ColorLabel extends Label {

    public String color() {
        return uiElement.getCssValue("background-color");
    }

}
