package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.SetValue;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.ui.html.aserts.DateTimeAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class DateTimeSelector extends WithLabel<DateTimeAssert> implements SetValue {
    // region Actions
    @JDIAction("Get '{name}' date-time ")
    public String value() { return element.attr("value"); }
    @JDIAction(value = "Get '{name}' min date-time value", level = DEBUG)
    public String min() { return element.attr("min"); }
    @JDIAction(value = "Get '{name}' max date-time value", level = DEBUG)
    public String max() { return element.attr("max"); }
    @JDIAction("Set date '{0}' for '{name}'")
    public void setDateTime(String dateTime) {
        setValue(dateTime);
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
