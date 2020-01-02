package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.CheckboxAssert;

/**
 * To see an example of Checkbox web element as form please visit https://getbootstrap.com/docs/4.3/components/forms/#default-stacked
 */

public class Checkbox extends UIBaseElement<CheckboxAssert>
        implements HasLabel, SetValue, HasClick, HasCheck {

    @UI("input")
    private UIElement input;

    // region Actions
    public void check(String value) {
        if ("true".equalsIgnoreCase(value) || "1".equals(value)) {
            check();
        } else {
            uncheck();
        }
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (!isSelected()) {
            click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isSelected()) {
            click();
        }
    }

    @JDIAction("Click at '{name}'")
    public void click() {
        if (input.isDisplayed()) {
            input.click();
        } else {
            label().click();
        }
    }

    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return input.isSelected();
    }

    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return input.isEnabled();
    }

    @Override

    public Label label() {
        return input.label();
    }

    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        check(value);
    }

    public String getValue() {
        return String.valueOf(isSelected());
    }
    // endregion

    // region Extend assertions
    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
    // endregion
}
