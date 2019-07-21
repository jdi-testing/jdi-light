package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.IButton;

public class Button extends UIBaseElement<TextAssert>
        implements IButton {
    public String getValue() { return getText(); }
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
