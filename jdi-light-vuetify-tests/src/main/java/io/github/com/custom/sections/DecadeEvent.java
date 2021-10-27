package io.github.com.custom.sections;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DecadeEvent extends Section {

    @UI("h2")
    protected UIElement header;

    @UI("div")
    protected UIElement body;

    public UIElement header() {
        return header;
    }

    public UIElement body() {
        return body;
    }
}
