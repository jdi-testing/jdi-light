package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.OkButtonAssert;

public class OkButton extends UIBaseElement<OkButtonAssert> {
    public void clickOk() {
        core().click();
    }

    public OkButtonAssert is() {
        return new OkButtonAssert().set(this);
    }

    public OkButtonAssert has() {
        return this.is();
    }
}
