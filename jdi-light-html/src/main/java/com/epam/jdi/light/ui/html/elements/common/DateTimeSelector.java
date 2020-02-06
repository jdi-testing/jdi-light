package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.html.asserts.DateTimeAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DateTimeSelector extends UIBaseElement<DateTimeAssert>
        implements HasLabel, SetValue {
    // region Actions
    @JDIAction("Get '{name}' date-time ")
    public String value() { return uiElement.attr("value"); }
    @JDIAction(value = "Get '{name}' min date-time value", level = DEBUG)
    public String min() { return uiElement.attr("min"); }
    @JDIAction(value = "Get '{name}' max date-time value", level = DEBUG)
    public String max() { return uiElement.attr("max"); }
    @JDIAction("Set date '{0}' for '{name}'")
    public void setDateTime(String dateTime) {
        uiElement.setAttribute("value", dateTime);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        setDateTime(value);
    }
    public String getValue() {
        return value();
    }
    // endregion

    // region Extend assertions
    @Override
    public DateTimeAssert is() {
        return new DateTimeAssert().set(this);
    }
    // endregion

}
