package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.displaydata.IconAssert;
import com.epam.jdi.light.material.interfaces.base.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.base.HasColor;

/**
 * Represents icon MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/icons/">Icon MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Icon extends UIBaseElement<IconAssert> implements HasClick, CanBeDisabled, HasColor {

    /**
     * Check that this icon is colored.
     *
     * @return {@code true} if this icon is colored, otherwise {@code false}
     */
    @JDIAction("Check if {name} is colored")
    public boolean colored() {
        return String.join("", classes()).contains("color") || attr("style").contains("color");
    }

    @Override
    @JDIAction("Is '{name}' disabled")
    public boolean isDisabled() {
        return attr("class").contains("colorDisabled");
    }

    @Override
    @JDIAction("Is '{name}' enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public IconAssert is() {
        return new IconAssert().set(this);
    }
}
