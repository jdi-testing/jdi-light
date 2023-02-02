package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.TextAssert;
import com.epam.jdi.light.vuetify.interfaces.HasColor;

public class Text extends UIBaseElement<TextAssert> implements IsText, HasColor {
    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return core().getText();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
