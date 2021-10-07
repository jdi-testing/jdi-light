package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.vuetify.asserts.OverflowButtonAssert;

public class OverflowButton extends UIBaseElement<OverflowButtonAssert> {

    protected String expanderLocator = ".v-input__append-inner";
    protected String openPanelClass = "v-select--is-menu-active";
    protected String counterLocator = ".v-counter";
    protected String messageLocator = ".v-messages__message";

    protected String listID() {
        return core().find(".v-input__slot").getAttribute("aria-owns");
    }

    public UIElement expander() {
        return core().find(expanderLocator);
    }

    public WebList dropDownList() {
        return finds("//ancestor::div[@id = 'app']//div[@id = '" + listID() + "']//div[@class = 'v-list-item__title']");
    }


    public void expand() {
        if (isClosed()) {
            expander().click();
        }
    }

    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    public void select(String text) {
        try {
            expand();
            dropDownList().select(text);
        } catch (RuntimeException e) {
            throw Exceptions.exception("List don't have element %s", text);
        }
    }

    public void select(int index) {
        expand();
        if (index < dropDownList().getStartIndex() || index > dropDownList().size()) {
            throw Exceptions.exception("Can't get element with index '%s'. Index should be from 1 to " + dropDownList().size(), index);
        }
        dropDownList().select(index);
    }

    public String getCounterMessage() {
        if (!core().find(counterLocator).isDisplayed()) {
            return "Counter doesn't exist";
        }
        return core().find(counterLocator).getText();
    }

    public String getMessage() {
        if (!core().find(messageLocator).isDisplayed()) {
            return "Message doesn't exist";
        }
        return core().find(messageLocator).getText();
    }

    public Boolean isExpanded() {
        return core().hasClass(openPanelClass);
    }

    public Boolean isClosed() {
        return !isExpanded();
    }
}
