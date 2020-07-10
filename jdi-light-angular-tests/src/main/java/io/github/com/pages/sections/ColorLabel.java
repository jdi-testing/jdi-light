package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.ui.html.asserts.ColorAssert;

public class ColorLabel extends Label {

    public String color() {
        System.out.println(uiElement.getAttribute("style.background"));
        return uiElement.getCssValue("background-color");
    }

}
