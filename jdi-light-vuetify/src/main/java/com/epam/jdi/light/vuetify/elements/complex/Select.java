package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;

import static org.openqa.selenium.Keys.ESCAPE;

/**
 * To see an example of Select web element please visit https://v2.vuetifyjs.com/en/components/selects/
 */

public class Select extends Dropdown {
    protected String hintLocator = ".v-messages__message";
    protected String displayedElement = "//div[@class = 'v-select__selections']//*[text()]";

    public UIElement input() {
        return core().find("input");
    }

    public UIElement hint() {
        return core().find(hintLocator);
    }

    @Override
    public Label label() {
        return new Label().setCore(Label.class, core().find("//label"));
    }

    @JDIAction("Close select")
    @Override
    public void close() {
        if (isExpanded()) {
            // click outside doesn't work, we can click on another object or select/deselect one of the items
            press(ESCAPE);
        }
    }

    @JDIAction("Get selected value") @Override
    public String selected() {
        return setupDone ? value().getAttribute("value") : ds().selected();
    }

    @Override
    public String getText() {
        return setupDone ? value().getAttribute("value") : ds().getText();
    }

    @Override
    public boolean isDisplayed() {
        return core().find(displayedElement).isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        return !core().hasClass("v-input--is-disabled");
    }
}
