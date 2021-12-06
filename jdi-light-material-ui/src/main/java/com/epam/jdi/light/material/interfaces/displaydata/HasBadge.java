package com.epam.jdi.light.material.interfaces.displaydata;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.displaydata.Badge;

public interface HasBadge extends ICoreElement {

    default Badge badge() {
        return new Badge().setCore(Badge.class, find(".MuiBadge-badge"));
    }
}
