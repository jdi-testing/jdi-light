package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.layout.GridAssert;

public class Grid extends UIBaseElement<GridAssert> {

    public boolean hasAttr(String attr, String value){
        return core().getAttribute(attr).equals(value);
    }

    @Override
    public GridAssert is() {
        return new GridAssert().set(this);
    }

    @JDIAction("Is {name} displayed")
    @Override
    public boolean isDisplayed(){
        return core().isDisplayed();
    }
}
