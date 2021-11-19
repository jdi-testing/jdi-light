package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public interface HasErrorNotification extends HasLabel {

    @JDIAction("Does '{name}' have error notification")
    default boolean hasErrorNotification() {
        return label().attr("class").contains("Mui-error");
    }

}
