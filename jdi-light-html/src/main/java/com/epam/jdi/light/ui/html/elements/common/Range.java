package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.html.asserts.RangeAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;

public class Range extends UIBaseElement<RangeAssert> implements HasLabel, SetValue {

    // region Actions
    @JDIAction(value = "Get '{name}' volume", level = DEBUG)
    public double value() {
        return getDouble("value", uiElement);
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

    public String getValue() {
        return value() + "";
    }

    @JDIAction(value = "Set value '{0}' for '{name}'", level = DEBUG)
    public void setValue(String value) {
        uiElement.setAttribute("value", value + "");
    }

    @JDIAction(value = "Set value '{0}' for '{name}'", level = DEBUG)
    public void setValue(double value) {
        uiElement.setAttribute("value", value + "");
    }
    // endregion

    // region Extend assertions
    @Override
    public RangeAssert is() {
        return new RangeAssert().set(this);
    }
    // endregion
}
