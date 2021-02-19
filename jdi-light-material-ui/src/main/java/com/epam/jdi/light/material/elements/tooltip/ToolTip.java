package com.epam.jdi.light.material.elements.tooltip;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.tooltip.ToolTipAssert;

public class ToolTip extends UIBaseElement<ToolTipAssert> {

    @JDIAction("Hover on '{name}'")
    public void hoverOn() {
        core().hover();
    }

    @JDIAction("Click on '{name}'")
    public void clickOn() {
        core().click();
    }

    @JDIAction("Is '{name}' displayed")
    public boolean addDefaultIsDisplayed() {
       return core().hasAttribute("mui-37825");
    }

    @JDIAction("Is '{name}' displayed")
    public boolean deleteDefaultIsDisplayed() {
        return core().hasAttribute("mui-67165");
    }

    @JDIAction("Is '{name}' dispalyed")
    public boolean triggerIsDisplayed() {
        return core().hasClass("MuiTooltip-popper");
    }

    @JDIAction("Is '{name}' displayed")
    public boolean interactiveIsDisplayed() {
        return core().hasClass("MuiToolTip-popperInteractive");
    }

    @JDIAction("Is '{name}' displayed")
    public boolean customizedTollTipIsDisplayed() {
        return core().hasAttribute("mui-36070");
    }

    @JDIAction("Is '{name}' displayed")
    public boolean fadeToolTipIsDisplayed() {
        return core().hasAttribute("mui-51982");
    }

    @JDIAction("Is '{name}' displayed")
    public boolean plusToolTipIsDisplayed() {
        return core().hasAttribute("mui-28411");
    }
}
