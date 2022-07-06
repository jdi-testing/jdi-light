package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.BadgeAssert;

/**
 * To see an example of Badge web element please visit https://vuetifyjs.com/en/components/badges/
 */

public class Badge extends UIBaseElement<BadgeAssert> implements IsText {

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }

    @JDIAction("The digits from the '{name}' is '{0}'")
    public Integer getDigits() {
        String text = this.core().getText().replaceAll("[^0-9]", "");
        if(!text.isEmpty()) {
            return Integer.valueOf(text);
        } else {
            return -1;
        }
    }
}
