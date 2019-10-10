package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.html.asserts.CheckboxAssert;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Checkbox extends UIBaseElement<CheckboxAssert>
    implements HasLabel, SetValue, HasClick, HasCheck {
    // region Actions
    public void check(String value) {
        if (("true").equalsIgnoreCase(value) || ("1").equals(value))
            check();
        else uncheck();
    }
    @JDIAction("Check '{name}'")
    public void check() {
        uiElement.check();
    }
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        uiElement.uncheck();
    }
    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
        return uiElement.isSelected();
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
