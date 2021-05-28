package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.asserts.displaydata.TooltipAssert;
import org.openqa.selenium.By;

public class Tooltip extends UIBaseElement<TooltipAssert> {


    public Tooltip(ICoreElement element) {
        setCore(Tooltip.class, element.core());
    }

    @JDIAction("Get value of '{name}'")
    public String getValue() {
//        return core().find(By.xpath("//div[contains(@class,'MuiTooltip-tooltip')]")).getText();
        return core().driver().findElement(By.xpath("//div[contains(@class,'MuiTooltip-tooltip')]")).getText();
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
