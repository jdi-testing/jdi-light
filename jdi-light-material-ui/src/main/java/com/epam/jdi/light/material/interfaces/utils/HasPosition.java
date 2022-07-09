package com.epam.jdi.light.material.interfaces.utils;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.apache.commons.lang3.StringUtils;

public interface HasPosition extends ICoreElement {

    Position position();

    /**
     * Gets {@link Position} named constant from the given class name.
     *
     * @param className String class name to find position
     * @return position as {@link Position}
     */
    default Position getPositionFromClass(String className) {
        return Position.fromFullString(core().classes().stream()
                .filter(c -> StringUtils.containsAnyIgnoreCase(c, className))
                .findFirst().orElse(""));
    }

    /**
     * Gets {@link Position} named constant from the given attribute value.
     *
     * @param attributeValue String attribute value to find position
     * @return position as {@link Position}
     */
    default Position getPositionFromAttribute(String attributeValue) {
        return Position.fromFullString(core().attr(attributeValue));
    }
}
