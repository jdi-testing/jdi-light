package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Button extends UIBaseElement<TextAssert>
        implements IsButton {
    public String getValue() { return getText(); }
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
