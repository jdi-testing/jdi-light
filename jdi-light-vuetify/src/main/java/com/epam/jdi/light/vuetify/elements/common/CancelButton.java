package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.ui.html.elements.common.Button;

public class CancelButton extends Button {
    public void clickCancel() {
        core().click();
    }
}
