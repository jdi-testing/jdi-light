package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;

public class Alert extends UIBaseElement<TextAssert> implements IsText, HasValue {

    @Override
    public String getValue() {
        return getText();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
