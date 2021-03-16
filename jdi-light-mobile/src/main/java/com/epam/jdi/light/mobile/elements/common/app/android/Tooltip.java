package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;

public class Tooltip extends MobileAppBaseElement<TextAssert> implements IsText {
    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
