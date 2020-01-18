package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.html.asserts.CheckboxAssert;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Checkbox extends UIBaseElement<CheckboxAssert>
    implements HasLabel, SetValue, HasClick, HasCheck {

    @Override
    public Label label() {
        if (core().label().isDisplayed()) {
            return core().label();
        }
        UIElement input = core().find("input[type=checkbox]");
        if (input.label().isDisplayed()) {
            return input.label();
        }
        throw exception("Can't find label for element %s", this);
    }
    @Override
    public void click() {
        if (label().isDisplayed()) {
            label().click();
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
    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return core().isSelected();
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
