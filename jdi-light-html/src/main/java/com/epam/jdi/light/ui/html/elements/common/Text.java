package com.epam.jdi.mobile.ui.html.elements.common;

import com.epam.jdi.mobile.asserts.generic.TextAssert;
import com.epam.jdi.mobile.elements.base.UIBaseElement;
import com.epam.jdi.mobile.elements.interfaces.base.HasValue;
import com.epam.jdi.mobile.elements.interfaces.common.IsText;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Text extends UIBaseElement<TextAssert>
        implements HasValue, IsText {

    public String getValue() { return getText(); }
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
