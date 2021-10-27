package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.vuetify.asserts.TooltipAssert;

/**
 * To see an example of Tooltip web element please visit https://vuetifyjs.com/en/components/tooltips/
 */

public class Tooltip extends UIBaseElement<TooltipAssert> implements IsText {

    public TooltipAssert is() {
        return new TooltipAssert().set(this);
    }

    public TooltipAssert has() {
        return this.is();
    }

}
