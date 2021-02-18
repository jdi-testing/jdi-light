package com.epam.jdi.light.material.elements.popover;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.popover.HoverOverPopAssert;
import org.openqa.selenium.By;

public class HoverOverPop extends UIBaseElement<HoverOverPopAssert> {

    @JDIAction("Hover over on '{name}'")
    public void hoverOver() {
        core().hover();
    }

    @JDIAction("Is {name} opened")
    public boolean isPopUpWindowOpened() {
        return core().find(By.xpath("//*[@class='sb-show-main sb-main-padded']//*[contains(), style=overflow: hidden;]")).isDisplayed();
    }

    @Override
    public HoverOverPopAssert is() {
        return new HoverOverPopAssert().set(this);
    }


}
