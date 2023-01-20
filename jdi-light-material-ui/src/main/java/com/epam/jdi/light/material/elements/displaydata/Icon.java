package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.material.asserts.displaydata.IconAssert;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;

/**
 * Represents icon MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/icons/">Icon MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Icon extends UIBaseElement<IconAssert> implements HasClick, CanBeDisabled {

    @Override
    public IconAssert is() {
        return new IconAssert().set(this);
    }
}
