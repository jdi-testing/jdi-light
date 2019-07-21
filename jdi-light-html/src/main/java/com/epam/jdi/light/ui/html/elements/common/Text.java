package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.HasText;
import com.epam.jdi.light.elements.interfaces.HasValue;

public class Text extends UIBaseElement<TextAssert>
        implements HasValue, HasText {

    public String getValue() { return getText(); }
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
