package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.ui.html.asserts.ProgressAssert;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ProgressBar extends UIBaseElement<ProgressAssert> implements HasLabel, HasValue {
    // region Actions
    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public int max() { return getInt(uiElement.attr("max")); }
    @JDIAction("Get '{name}' progress value ")
    public int value() { return getInt(uiElement.attr("value")); }
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
