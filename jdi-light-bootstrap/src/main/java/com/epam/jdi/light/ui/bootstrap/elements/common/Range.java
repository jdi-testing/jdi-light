package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.bootstrap.asserts.RangeAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.bootstrap.BootstrapUtils.asDouble;
import static com.epam.jdi.light.ui.bootstrap.BootstrapUtils.getDouble;

public class Range extends UIBaseElement<UIAssert> implements HasLabel, SetValue {

    @JDIAction(value = "Get '{name}' thumbValue", level = DEBUG)
    public double thumbValue() {
        return Double.parseDouble(uiElement.getAttribute("value"));
    }

    @JDIAction(value = "Get '{name}' min limit", level = DEBUG)
    public double min() {
        return getDouble("min", uiElement);
    }

    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public double max() {
        return getDouble("max", uiElement);
    }

    @JDIAction(value = "Get '{name}' step size", level = DEBUG)
    public double step() {
        return getDouble("step", uiElement);
    }

    @JDIAction(value = "Set thumbValue '{0}' for '{name}'", level = DEBUG)
    public void setThumbValue(double thumbValue) {
        uiElement.setAttribute("value", String.valueOf(thumbValue));
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        setThumbValue(asDouble(value));
    }

    public String getValue() {
        return String.valueOf(thumbValue());
    }
    // endregion

    // region Extend assertions
    @Override
    public RangeAssert is() {
        return new RangeAssert().set(this);
    }
}