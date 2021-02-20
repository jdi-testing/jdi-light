package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layout.ContainerAssert;

public class Container extends UIBaseElement<ContainerAssert> {
    public boolean hasStyle(String color){
        String style = core().getAttribute("style");
        return style.contains(color);
    }

    @JDIAction("Is {name} displayed")
    @Override
    public boolean isDisplayed(){
        return core().isDisplayed();
    }

    @Override
    public ContainerAssert is() {
        return new ContainerAssert().set(this);
    }
}
