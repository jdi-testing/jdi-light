package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.DividerAssert;

public class Divider extends UIBaseElement<DividerAssert>  {

    @Override
    public DividerAssert is() {
        return new DividerAssert().set(this);
    }

    public boolean isInset(){
        return core().hasClass("MuiDivider-inset");
    }

    public boolean isVertical(){
        return core().hasClass("MuiDivider-vertical");
    }

}
