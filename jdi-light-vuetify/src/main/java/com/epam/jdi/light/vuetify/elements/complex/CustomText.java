package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.CustomTextAssert;

public class CustomText extends UIBaseElement<CustomTextAssert>
        implements IsText {

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return core().getText();
    }

    @Override
    public CustomTextAssert is() {
        return new CustomTextAssert().set(this);
    }
}
