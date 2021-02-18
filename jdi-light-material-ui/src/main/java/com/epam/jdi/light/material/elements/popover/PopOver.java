package com.epam.jdi.light.material.elements.popover;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.popover.PopOverAssert;

public class PopOver extends UIBaseElement<PopOverAssert> {

    @JDIAction("Click on '{name}'")
    public void clickOn() {
        core().click();
    }

    @JDIAction("Is '{name}' displayed")
    public boolean isPopUpDisplayed() {
        return core().hasClass("MuiPaper-root");
    }

    @JDIAction("Is '{name}' displayed")
    public boolean isPopUpEnabled() {
        return core().hasClass("MuiButton-contained");
    }

    @Override
    public PopOverAssert is() {
        return new PopOverAssert().set(this);
    }
}
