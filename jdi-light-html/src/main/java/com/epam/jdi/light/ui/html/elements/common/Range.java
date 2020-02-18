package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.html.asserts.RangeAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.asInt;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Range extends UIBaseElement<RangeAssert> implements HasLabel, SetValue {

    // region Actions
    @JDIAction(value = "Get '{name}' value", level = DEBUG)
    public int value() {
        return getInt("value", uiElement);
    }

    @JDIAction(value = "Get '{name}' min limit", level = DEBUG)
    public String min() { return uiElement.attr("min"); }

    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public String max() { return uiElement.attr("max"); }

    @JDIAction(value = "Get '{name}' step size", level = DEBUG)
    public String step() { return uiElement.attr("step"); }

    @JDIAction(value = "Set value '{0}' for '{name}'", level = DEBUG)
    public void setRangeValue(int value) {
        uiElement.setAttribute("value", value+"");
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        setRangeValue(asInt(value));
    }
    public String getValue() {
        return value()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public RangeAssert is() {
        return new RangeAssert().set(this);
    }
    // endregion
}
