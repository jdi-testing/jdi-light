package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;

import static com.epam.jdi.light.common.TextTypes.TEXT;

public class Button extends UIBaseElement<TextAssert> implements IsButton {
    public String getText() { return text(TEXT); }

    @Override
    public TextAssert is() { return new TextAssert().set(this); }

}