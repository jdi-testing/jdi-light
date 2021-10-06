package io.github.com.custom.windows;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class MySection extends Section {

    @UI("input")
    public UIElement input;

}
