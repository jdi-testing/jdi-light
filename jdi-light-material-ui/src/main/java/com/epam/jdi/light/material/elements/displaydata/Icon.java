package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.displaydata.IconAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;


/**
 * To see examples of Icon web element please visit https://mui.com/components/icons/
 */

public class Icon extends UIBaseElement<IconAssert> implements HasClick, CanBeDisabled {

    @JDIAction("Check if {name} is colored")
    public boolean colored() {
        return String.join("", classes()).contains("color") ||
                attr("style").contains("color");
    }

    @JDIAction("Get color of {name}")
    public String getColor() {
        return css("color");
    }

    @Override
    @JDIAction("Is '{name}' disabled")
    public boolean isDisabled() {
        return attr("class").contains("colorDisabled");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public IconAssert is() {
        return new IconAssert().set(this);
    }
}
