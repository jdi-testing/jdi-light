package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.interfaces.HasIcon;

/**
 * To see an example of Alert web element please visit https://vuetifyjs.com/en/components/alerts/
 */
public class Alert extends UIBaseElement<TextAssert> implements IsText, HasIcon {

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
