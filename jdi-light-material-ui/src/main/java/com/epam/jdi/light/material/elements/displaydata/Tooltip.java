package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.asserts.displaydata.TooltipAssert;
import org.openqa.selenium.By;

public class Tooltip extends UIBaseElement<TooltipAssert> {

    public static final By TOOLTIP_PLACEHOLDER_LOCATOR = By.xpath("//div[contains(@class,'MuiTooltip-tooltip')]");

    public Tooltip(ICoreElement element) {
        setCore(Tooltip.class, element.core());
    }

    @JDIAction("Get value of '{name}'")
    public String getValue() {
//        return core().find(By.xpath("/ancestor::body//div[contains(@class,'MuiTooltip-tooltip')]")).getText();
//        return core().find(By.xpath("//div[contains(@class,'MuiTooltip-tooltip')]")).getText();
//        doesn't work and I don't know why
        return core().driver().findElement(TOOLTIP_PLACEHOLDER_LOCATOR).getText();
    }

    @Override
    public TooltipAssert is() {
        return new TooltipAssert().set(this);
    }

    @Override
    public TooltipAssert has() {
        return this.is();
    }

    @Override
    public boolean isVisible() {
        return core().isExist();
    }

    public boolean isInteractive() {
        return core().hasClass("MuiTooltip-popperInteractive");
    }

}
