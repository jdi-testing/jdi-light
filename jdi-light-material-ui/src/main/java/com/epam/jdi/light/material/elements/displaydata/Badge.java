package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.asserts.displaydata.BadgeAssert;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.base.HasColor;

import java.util.Arrays;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * Represents badge MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/badges/">Badge MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class Badge extends UIBaseElement<BadgeAssert> implements HasColor, IsText {

    /**
     * Checks if the badge is a dot type or not.
     *
     * @return {@code true} if this badge is a dot, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' is a dot")
    public boolean isDot() {
        return core().hasClass("MuiBadge-dot");
    }

    @Override
    @JDIAction("Check that '{name}' is visible")
    public boolean isVisible() {
        return !isNotVisible();
    }

    @Override
    @JDIAction("Check that '{name}' is invisible")
    public boolean isNotVisible() {
        return core().hasClass("MuiBadge-invisible");
    }

    /**
     * Returns the position of the badge on the main element.
     *
     * @return position of this badge as {@link String}
     * @throws RuntimeException if no items found
     */
    @JDIAction("Get '{name}' position")
    public Position position() {
        String position = Arrays.stream(attr("class")
                        .split("[^a-zA-Z0-9]"))
                .map(String::toLowerCase)
                .filter(s -> s.contains("anchor"))
                .findAny().orElse("Unknown position")
                .replace("anchororigin", "")
                .replace("rectangle", "")
                .replace("circle", "");
        if (!position.isEmpty()) {
            return Position.fromString(position);
        } else {
            throw runtimeException("Unknown position");
        }
    }

    @Override
    public BadgeAssert is() {
        return new BadgeAssert().set(this);
    }
}
