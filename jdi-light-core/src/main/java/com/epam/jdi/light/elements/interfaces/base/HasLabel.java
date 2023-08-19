package com.epam.jdi.light.elements.interfaces.base;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.Label;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface HasLabel extends ICoreElement {
    default Label label() {
        return core().label();
    }
    /**
     * Gets label text
     * @return String text
     */
    @JDIAction("Get '{name}' label text")
    default String labelText() {
        return core().labelText();
    }

    /**
     * Checks if there is a label in DOM and if the label is displayed
     *
     * @return boolean if there is displayed and existed label or not
     */
    default Boolean hasLabel() {
        return label().isExist() & label().isDisplayed();
    }
}
