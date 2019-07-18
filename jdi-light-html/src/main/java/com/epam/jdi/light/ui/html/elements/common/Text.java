package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.HasValue;
import com.epam.jdi.light.ui.html.asserts.TextAssert;

public class Text extends UIBaseElement<TextAssert> implements HasValue {

    // region Set and get value for Forms
    public String getValue() {
        return getText();
    }
    // endregion

    // region Extend assertions
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
    // endregion
}
