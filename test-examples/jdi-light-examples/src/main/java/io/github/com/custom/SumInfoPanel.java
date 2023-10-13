package io.github.com.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import static com.epam.jdi.light.common.TextTypes.TEXT;

public class SumInfoPanel extends Section {
    @UI(".div[class='info-panel-header']")
    public static UIElement header;


    // Element is located in another panel, but we can find element due to @Root
    @Css("li[class='summ-res']") @GetTextAs(TEXT) @Root
    public static UIElement sumGetTextAs;

    @Css("ul.results") @Root
    public static UIElement sumItems;
}
