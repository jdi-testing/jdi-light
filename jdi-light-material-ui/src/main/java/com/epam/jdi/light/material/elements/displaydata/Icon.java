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
     * Checks if the icon is colored or not.
     *
     * @return {@code true} if this icon is colored, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is colored")
    public boolean colored() {
        return String.join("", core().classes()).contains("color") || core().attr("style").contains("color");
    }

    @Override
    @JDIAction("Check that '{name}' is enabled")
    public boolean isEnabled() {
        return !(core().attr("class").contains("colorDisabled"));
    }

    @Override
    public IconAssert is() {
        return new IconAssert().set(this);
    }
}
