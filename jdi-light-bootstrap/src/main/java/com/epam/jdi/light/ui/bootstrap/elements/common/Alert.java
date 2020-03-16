package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;

import static com.epam.jdi.light.elements.init.PageFactory.*;

/**
 * To see an example of Alert web element please visit https://getbootstrap.com/docs/4.3/components/alerts/
 */

public class Alert extends UIBaseElement<TextAssert> implements PageObject, IsText, HasValue, HasAssert<TextAssert> {
    public Alert() { initElements(this); }
    public String getValue() { return getText(); }
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
