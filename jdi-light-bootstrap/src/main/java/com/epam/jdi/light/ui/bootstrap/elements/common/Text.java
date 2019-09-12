package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.common.TextTypes.TEXT;

public class Text extends UIBaseElement<TextAssert>
        implements HasValue, IsText {

    public String getText() { return text(TEXT); }
    public String getValue() { return getText(); }
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
