package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import org.openqa.selenium.By;

/**
 * To see an example of Select web element please visit https://vuetifyjs.com/en/components/selects/
 */

public class Select extends Dropdown {

    protected String messageLocator = ".v-messages__message";
    protected String displayedElement = "//div[@class = 'v-select__selections']//*[text()]";

    public UIElement input() {
        return core().find("input");
    }

    public UIElement message() {
        return core().find(messageLocator);
    }

    @Override
    public Label label() {
        return new Label().setup(Label.class, j -> j
                .setLocator(By.cssSelector("[for=" + input().attr("id") + "]"))
                .setName(getName() + " label").setTypeName("Label"));
    }

    @Override
    public void close() {
        if (isExpanded()) {
            core().click(-1, -1);
        }
    }

    @Override
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
        return input().isEnabled();
    }
}
