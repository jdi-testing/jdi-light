package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.displaydata.DividerAssert;


/**
 * To see an example of Divider web element please visit
 * https://mui.com/components/dividers/
 */

public class Divider extends UIBaseElement<DividerAssert>  {

    @Override
    public DividerAssert is() {
        return new DividerAssert().set(this);
    }

    @JDIAction("Check if '{name}' is inset")
    public boolean isInset(){
        return core().hasClass("MuiDivider-inset");
    }

    @JDIAction("Check if '{name}' is vertical")
    public boolean isVertical(){
        return core().hasClass("MuiDivider-vertical");
    }
}
