package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.utils.PopperAssert;

/**
 * To see an example of Popper web element please visit
 * https://mui.com/components/popper/
 */

public class Popper extends UIBaseElement<PopperAssert> {

    @JDIAction("Popper is displayed")
    public boolean isPopperDisplayed(){
       return core().isDisplayed();
    }

    @JDIAction("Popper is on the top")
    public String getPopperPosition(){
       return core().getAttribute("x-placement");
    }

    @JDIAction("Get popper text")
    public String getPopperText(){
       return core().getText();
    }

    @Override
    public PopperAssert is() {
        return new PopperAssert().set(this);
    }

}
