package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;

/**
 * To see an example of Alert web element please visit https://vuetifyjs.com/en/components/alerts/
 */
public class Alert extends UIBaseElement<TextAssert> implements IsText, HasValue {

    @Override
    public String getValue() {
        return getText();
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
