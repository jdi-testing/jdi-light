package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.vuetify.asserts.ProgressBarAssert;

public class ProgressBar extends UIBaseElement<ProgressBarAssert> {

    @JDIAction("{name} has expected color")
    public boolean hasColor(String color) {
        return this.core().getCssValue("color").equals(color);
    }

    public ProgressBarAssert is() {
        return new ProgressBarAssert().set(this);
    }

    public ProgressBarAssert has() {
        return this.is();
    }
}
