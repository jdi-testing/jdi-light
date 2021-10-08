package com.epam.jdi.light.vuetify.elements.composite;

import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.light.vuetify.asserts.OverflowButtonAssert;

public class OverflowButton extends UIBaseElement<OverflowButtonAssert> implements HasPlaceholder {

    protected String expanderLocator = ".v-input__append-inner";
    protected String openPanelClass = "v-select--is-menu-active";
    protected String counterLocator = ".v-counter";
    protected String messageLocator = ".v-messages__message";
    protected String placeholderLocator = ".v-label";
    protected String selectLocator = ".v-select__selection";
    protected String progressBarLocator = ".v-progress-linear";
    protected String inputLocator = "input[type = 'text']";

    protected String listID() {
        return core().find(".v-input__slot").getAttribute("aria-owns");
    }

    public UIElement expander() {
        return core().find(expanderLocator);
    }

    public WebList dropDownList() {
        return finds("//ancestor::div[@id = 'app']//div[@id = '" + listID() + "']//div[@class = 'v-list-item__title']");
    }

    @JDIAction("Open '{name}'")
    public void expand() {
        if (isClosed()) {
            expander().click();
        }
    }

    @JDIAction("Close '{name}'")
    public void close() {
        if (isExpanded()) {
            expander().click();
        }
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(String text) {
        try {
            expand();
            dropDownList().select(text);
        } catch (RuntimeException e) {
            throw Exceptions.exception("List don't have element %s", text);
        }
    }

    @JDIAction("Select '{0}' in '{name}'")
    public void select(int index) {
        expand();
        if (index < dropDownList().getStartIndex() || index > dropDownList().size()) {
            throw Exceptions.exception("Can't get element with index '%s'. Index should be from 1 to " + dropDownList().size(), index);
        }
        dropDownList().select(index);
    }

    @JDIAction("Set '{0}' in '{name}' input text field")
    public void sendText(String text) {
        core().find(inputLocator).sendKeys(text);
    }

    @JDIAction("Clear '{name}' text field")
    public void clear() {
        core().find(inputLocator).clear();
    }

    @JDIAction("Get '{name}' selected text")
    public String selected() {
        if (core().find(selectLocator).isNotExist()) {
            return "Nothing selected";
        }
        return core().find(selectLocator).getText();
    }

    @JDIAction("Get '{name}' hint")
    public String hint() {
        if (core().find(messageLocator).isNotExist()) {
            return "Hint doesn't exist";
        }
        return core().find(messageLocator).getText();
    }

    @Override
    public String placeholder() {
        if (core().find(placeholderLocator).isNotExist()) {
            return "Placeholder doesn't exist";
        }
        return core().find(placeholderLocator).getText();
    }

    @JDIAction("Get '{name}' counter")
    public String counterMessage() {
        if (core().find(counterLocator).isNotExist()) {
            return "Counter doesn't exist";
        }
        return core().find(counterLocator).getText();
    }

    @JDIAction("Check that '{name}' is expanded")
    public Boolean isExpanded() {
        return core().hasClass(openPanelClass);
    }

    @JDIAction("Check that '{name}' is closed")
    public Boolean isClosed() {
        return !isExpanded();
    }

    @Override
    public boolean isDisabled() {
        return core().hasClass("v-input--is-disabled");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Check that '{name}' is editable")
    public boolean isEditable() {
        return core().hasClass("v-overflow-btn--editable");
    }

    @JDIAction("Check that '{name} is read only'")
    public boolean readOnly() {
        return core().hasClass("v-input--is-readonly");
    }

    @JDIAction("Check that '{name}' has progressbar")
    public Boolean hasProgressBar() {
        return core().find(progressBarLocator).isExist();
    }

    public OverflowButtonAssert is() {
        return new OverflowButtonAssert().set(this);
    }
}
