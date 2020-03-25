package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.ui.bootstrap.asserts.ProgressAssert;

import java.util.List;

import static com.epam.jdi.light.logger.LogLevels.*;
import static com.epam.jdi.light.ui.html.HtmlUtils.*;
import static com.epam.jdi.tools.PrintUtils.*;

/**
 * To see an example of bootstrap Progress bar please visit https://getbootstrap.com/docs/4.3/components/progress/
 */

public class Progress extends UIBaseElement<ProgressAssert> implements HasValue {
    // region Actions
    @JDIAction(value = "Get '{name}' max limit", level = DEBUG)
    public int max() { return getInt("aria-valuemax", uiElement.finds(".progress-bar").first()); }
    @JDIAction(value = "Get '{name}' min limit", level = DEBUG)
    public int min() { return getInt("aria-valuemin", uiElement.finds(".progress-bar").first()); }
    @JDIAction("Get '{name}' progress value ")
    public String value() { return print(values(), ";"); }
    @JDIAction(value = "Get '{name}' min limit")
    public List<String> values() { return uiElement.finds(".progress-bar").values(); }
    // endregion

    // region Set and get value for Forms
    public String getValue() { return value(); }
    // endregion

    // region Extend assertions
    @Override
    public ProgressAssert is() {
        return new ProgressAssert().set(this);
    }
    // endregion
}
