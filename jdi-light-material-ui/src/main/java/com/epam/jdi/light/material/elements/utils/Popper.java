package com.epam.jdi.light.material.elements.utils;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.utils.PopperAssert;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.utils.HasPosition;

/**
 * Represent popper MUI component on GUI. A popper can be used to display some content on top of another. .
 *
 * @see <a href="https://mui.com/components/popper/">popper MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Popper extends UIBaseElement<PopperAssert> implements IsText, HasPosition {

    /**
     * Gets the position of this popper.
     *
     * @return position as {@link Position}
     */
    @Override
    @JDIAction("Get '{name}' position")
    public Position position() {
        return getPositionFromAttribute("x-placement");
    }

    @Override
    public PopperAssert is() {
        return new PopperAssert().set(this);
    }
}
