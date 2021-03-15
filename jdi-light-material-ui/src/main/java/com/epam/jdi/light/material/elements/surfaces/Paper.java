package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.surfaces.PaperAssert;
import org.openqa.selenium.By;

public class Paper extends UIBaseElement<PaperAssert> {

    @JDIAction("Get text for '{name}'")
    public String getText() {
        return core().getText();
    }

    @JDIAction("Get inner element of '{name}'")
    public UIElement getInnerElement() {
        return this.find(By.cssSelector("*"));
    }

    @Override
    public PaperAssert is() {
        return new PaperAssert().set(this);
    }
}
