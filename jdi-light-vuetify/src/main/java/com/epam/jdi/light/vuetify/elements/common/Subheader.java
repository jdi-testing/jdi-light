package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.SubheaderAssert;
import com.epam.jdi.light.vuetify.interfaces.HasTheme;

/**
 * To see an example of Subheader web element please visit https://vuetifyjs.com/en/components/subheaders/
 */
public class Subheader extends UIBaseElement<SubheaderAssert> implements IsText, HasTheme {

    @Override
    public SubheaderAssert is() {
        return new SubheaderAssert().set(this);
    }

    public boolean isInset() {
        return core().hasClass("v-subheader--inset");
    }

}
