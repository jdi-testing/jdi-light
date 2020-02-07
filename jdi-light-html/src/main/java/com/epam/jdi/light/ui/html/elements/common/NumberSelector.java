package com.epam.jdi.mobile.ui.html.elements.common;

import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.base.UIBaseElement;
import com.epam.jdi.mobile.elements.interfaces.base.HasLabel;
import com.epam.jdi.mobile.elements.interfaces.base.HasPlaceholder;
import com.epam.jdi.mobile.elements.interfaces.base.HasValue;
import com.epam.jdi.mobile.ui.html.asserts.NumberAssert;

import static com.epam.jdi.mobile.logger.LogLevels.DEBUG;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class NumberSelector extends UIBaseElement<NumberAssert>
        implements HasLabel, HasValue, HasPlaceholder {
    // region Actions

    @JDIAction(value = "Get '{name}' min value", level = DEBUG)
    public String min() { return uiElement.attr("min"); }
    @JDIAction(value = "Get '{name}' max value", level = DEBUG)
    public String max() { return uiElement.attr("max"); }
    @JDIAction(value = "Get '{name}' value", level = DEBUG)
    public String value() { return uiElement.attr("value"); }
    @JDIAction(value = "Get '{name}' step size", level = DEBUG)
    public String step() { return uiElement.attr("step"); }
    @JDIAction("Select number '{0}' for '{name}'")
    public void setNumber(String number) {
        uiElement.setAttribute("value", number);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        setNumber(value);
    }
    public String getValue() {
        return value()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public NumberAssert is() {
        return new NumberAssert().set(this);
    }
    // endregion

}
