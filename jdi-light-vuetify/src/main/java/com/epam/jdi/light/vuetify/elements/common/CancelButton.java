package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.CancelButtonAssert;

public class CancelButton extends UIBaseElement<CancelButtonAssert> {
    public void clickCancel() {
        core().click();
    }
    public CancelButtonAssert is() {
        return new CancelButtonAssert().set(this);
    }

    public CancelButtonAssert has() {
        return this.is();
    }
}
