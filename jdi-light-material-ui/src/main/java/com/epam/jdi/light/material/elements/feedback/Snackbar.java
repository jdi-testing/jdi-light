package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;

public class Snackbar extends UIBaseElement<SnackbarAssert> {

    String root;

    @JDIAction("Check if '{name}' is visible")
    public boolean isVisible() {
        return "visible".equalsIgnoreCase(core().find(root).getCssValue("visibility"));
    }

    @JDIAction("Check if '{name}' is exist")
    public boolean isExist() {
        return core().find(root).isExist();
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }

    @Override
    public SnackbarAssert has() {
        return this.is();
    }
}
