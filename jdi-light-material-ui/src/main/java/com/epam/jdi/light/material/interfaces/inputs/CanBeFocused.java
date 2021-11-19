package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;

public interface CanBeFocused extends ICoreElement {

    @JDIAction("Is '{name}' focused")
    default boolean isFocused() {
        return find(".Mui-focused").isDisplayed();
    }

}
