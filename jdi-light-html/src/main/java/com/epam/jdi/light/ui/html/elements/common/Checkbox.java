package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.html.asserts.CheckboxAssert;

import static com.epam.jdi.light.common.Exceptions.exception;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Checkbox extends UIBaseElement<CheckboxAssert>
    implements HasLabel, SetValue, HasClick, HasCheck, CanBeSelected {

    @Override
    public Label label() {
        Label label = safeGetLabel();
        if (label != null) {
            return label;
        }
        throw exception("Can't find label for element %s", this);
    }
    private Label safeGetLabel() {
        if (core().label().isDisplayed()) {
            return core().label();
        }
        com.epam.jdi.light.elements.common.uiElement input = core().find("input[type=checkbox]");
        boolean hasLabelInput;
        try {
            hasLabelInput = input.label().isDisplayed();
        } catch (Exception ignore) { hasLabelInput = false; }
        return hasLabelInput ? input.label() : null;
    }
    @Override
    public void click() {
        Label label = safeGetLabel();
        if (label != null) {
            label.click();
        } else {
            core().click();
        }
    }
    @Override
    public boolean isDisplayed() {
        return label().isDisplayed();
    }

    // region Actions
    public void check(String value) {
        if (value.equalsIgnoreCase("true") || value.equals("1"))
            check();
        else uncheck();
    }
    @JDIAction("Check '{name}'")
    public void check() {
        if (!isSelected())
            click();
    }
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if (isSelected())
            click();
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        check(value);
    }
    public String getValue() {
        return isSelected()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
    // endregion
}
