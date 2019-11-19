package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasBadge;
import com.epam.jdi.light.elements.interfaces.common.IsButton;

import static com.epam.jdi.light.common.TextTypes.TEXT;

/**
 * To see an example of Button web element please visit https://getbootstrap.com/docs/4.3/components/buttons/
 */

public class Button extends UIBaseElement<TextAssert> implements IsButton, HasBadge {
    public String getText() { return text(TEXT); }

    @Override
    public TextAssert is() { return new TextAssert().set(this); }

}