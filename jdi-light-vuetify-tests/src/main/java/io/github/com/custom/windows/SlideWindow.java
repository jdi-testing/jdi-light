package io.github.com.custom.windows;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class SlideWindow extends Section {

    @UI("h1")
    private UIElement header;

    public UIElement header() {
        return header;
    }

}
