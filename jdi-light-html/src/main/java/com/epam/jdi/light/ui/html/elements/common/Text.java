package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.ui.html.aserts.TextAssert;

public class Text<A extends TextAssert> extends UIBaseElement<A> implements HasValue {
    // region Actions
    @JDIAction("Get '{name}' text")
    public String getText() {
        return element.getText();
    }
    // endregion

    // region Set and get value for Forms
    public String getValue() {
        return getText();
    }
    // endregion

    // region Extend assertions
    @Override
    public A is() { return (A) new TextAssert().set(this); }
    // endregion
}
