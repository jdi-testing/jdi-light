package com.epam.jdi.light.ui.html.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.WithLabel;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.ui.html.aserts.ProgressAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class ProgressBar extends WithLabel<ProgressAssert> implements HasValue {
    // region Actions
    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public String max() { return element.attr("max"); }
    @JDIAction("Get '{name}' progress value ")
    public String value() { return element.attr("value"); }
    // endregion

    // region Set and get value for Forms
    public String getValue() {
        return value()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }
    // endregion
}
