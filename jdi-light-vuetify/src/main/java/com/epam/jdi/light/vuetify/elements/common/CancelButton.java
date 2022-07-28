package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.asserts.CancelButtonAssert;
import com.epam.jdi.light.vuetify.asserts.OkButtonAssert;

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
