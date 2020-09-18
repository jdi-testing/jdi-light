package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

/**
 * To see an example of Badge web element please visit https://material.angular.io/components/badge/overview.
 */

public interface WithBadge extends ICoreElement {
    default Badge badge() {
        return new Badge(core());
    }
}
