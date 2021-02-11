package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.asserts.displaydata.TooltipAssert;

public class Tooltip extends UIBaseElement<TooltipAssert> {


    public static final String TOOLTIP_PLACEHOLDER_LOCATOR = "//div[contains(@class, 'MuiTooltip-tooltip')]";

    public Tooltip(ICoreElement element) {
        setCore(Tooltip.class, element.core());
    }

    public String getValue() {
        return core().find(TOOLTIP_PLACEHOLDER_LOCATOR).getText();
    }

    @Override
    public TooltipAssert is() {
        return new TooltipAssert().set(this);
    }

    @Override
    public TooltipAssert has() {
        return new TooltipAssert().set(this);
    }

    @Override
    public boolean isVisible() {
        return core().isExist();
    }

    public boolean isInteractive() {
        return core().hasClass("MuiTooltip-popperInteractive");
    }

}
