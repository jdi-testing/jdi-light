package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public interface CanBeFocused extends HasLabel {

    @JDIAction("Is '{name}' focused")
    default boolean isFocused() {
        return label().attr("class").contains("Mui-focused");
    }
}
