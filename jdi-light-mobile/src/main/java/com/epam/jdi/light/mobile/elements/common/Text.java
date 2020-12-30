package com.epam.jdi.light.mobile.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileBaseElement;
import com.epam.jdi.light.mobile.elements.base.MobileUIElement;

public class Text extends MobileBaseElement<TextAssert> implements HasValue, IsText {
    @Override
    public MobileUIElement core() {
        return super.core();
    }

    public String getValue() {
        return getText();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
