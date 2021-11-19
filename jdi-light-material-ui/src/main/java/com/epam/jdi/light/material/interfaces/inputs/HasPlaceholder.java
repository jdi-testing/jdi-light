package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public interface HasPlaceholder extends HasLabel {

    default boolean hasPlaceholder() {
        return label().attr("data-shrink").equals("false");
    }
}
