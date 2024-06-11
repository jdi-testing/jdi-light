package com.epam.jdi.light.angular.elements.interfaces;

import com.epam.jdi.light.angular.elements.enums.Position;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import org.apache.commons.lang3.StringUtils;

public interface HasPosition extends ICoreElement {

    Position position();

    /**
     * Gets {@link Position} named constant from the given class name.
     *
     * @param className String class name to find position
     * @param element UIElement to check
     * @return position as {@link Position}
     */
    default Position getPositionFromClass(UIElement element, String className) {
        return Position.fromFullString(element.classes().stream()
                .filter(c -> StringUtils.startsWith(c, className))
                .map(c -> c.replace(className, ""))
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
