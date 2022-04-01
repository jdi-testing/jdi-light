package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;
import com.epam.jdi.light.material.interfaces.base.HasColor;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Represents badge MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/badges/">Badge MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Badge extends UIBaseElement<BadgeAssert> implements HasColor, IsText {

    /**
     * Check that badge is a dot type.
     *
     * @return {@code true} if this badge is a dot, otherwise {@code false}
     */
    @JDIAction("Is '{name}' a dot")
    public boolean isDot() {
        return core().hasClass("MuiBadge-dot");
    }

    @Override
    @JDIAction("Is '{name}' visible")
    public boolean isVisible() {
        return !isNotVisible();
    }

    @Override
    @JDIAction("Is '{name}' invisible")
    public boolean isNotVisible() {
        return core().hasClass("MuiBadge-invisible");
    }

    /**
     * Return the location of the badge on the main element.
     *
     * @return location of this badge as {@link String}
     */
    @JDIAction("Get '{name}'s position")
    public String getPosition() {
        return Arrays.stream(attr("class").split("[^a-zA-Z0-9]"))
                .filter(s -> s.startsWith("anchor")).collect(Collectors.joining());
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }
}
