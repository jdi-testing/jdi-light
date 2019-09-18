package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.common.TextTypes.TEXT;

public class Alert extends UIBaseElement<TextAssert> implements HasClick, IsText {

    public String getText() { return text(TEXT); }

    @Override
    public TextAssert is() { return new TextAssert().set(this); }

}