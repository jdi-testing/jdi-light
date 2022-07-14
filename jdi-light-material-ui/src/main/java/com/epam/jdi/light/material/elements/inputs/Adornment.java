package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.material.asserts.inputs.AdornmentAssert;
import com.epam.jdi.light.material.elements.utils.enums.Position;

import com.epam.jdi.light.material.interfaces.HasPosition;

/**
 * Represents an adornment.
 * Adornment can be used to add a prefix, a suffix, or an action to an input.
 * For example, it can be an icon button that hides or reveals the password.
 *
 * @see <a href="https://mui.com/api/input-adornment/">InputAdornment API MUI documentation</a>
 */
public class Adornment extends UIBaseElement<AdornmentAssert> implements IsButton, HasPosition {

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return core().find("p").getText();
    }

    /**
     * Gets one of two possible positions of the adornment: 'start' or 'end'.
     *
     * @return adornment position as {@link Position}
     */
    @Override
    @JDIAction("Get '{name}' position")
    public Position position() {
        return getPositionFromClass("position");
    }

    @Override
    public AdornmentAssert is() {
        return new AdornmentAssert().set(this);
    }
}
