package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.material.asserts.inputs.AdornmentAssert;
import com.epam.jdi.light.material.elements.utils.enums.Position;

import java.util.Arrays;

/**
 * Represents an adornment.
 * Adornment can be used to add a prefix, a suffix, or an action to an input.
 * For example, it can be an icon button that hides or reveals the password.
 *
 * @see <a href="https://mui.com/api/input-adornment/">InputAdornment API MUI documentation</a>
 */
public class Adornment extends UIBaseElement<AdornmentAssert> implements IsButton {

    @Override
    @JDIAction("Get '{name}' text")
    public String getText() {
        return find("p").getText();
    }

    /**
     * Gets one of two possible positions of the adornment: 'start' or 'end'.
     *
     * @return adornment position as {@link Position}
     */
    @JDIAction("Get '{name}' position")
    public Position position() {
        String position =  Arrays.stream(attr("class")
                        .split("[^a-zA-Z0-9]"))
                .filter(s -> s.startsWith("position"))
                .findAny().orElse("could not find")
                .replace("position", "")
                .toLowerCase();
        return Position.fromString(position);
    }

    @Override
    public AdornmentAssert is() {
        return new AdornmentAssert().set(this);
    }
}
