package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileBaseElement;

public class Label extends MobileBaseElement<TextAssert> implements HasValue, IsText {
    public String getValue() {
        return getText();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }

}