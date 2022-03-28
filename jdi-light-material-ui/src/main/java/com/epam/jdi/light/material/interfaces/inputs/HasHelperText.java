package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;

public interface HasHelperText extends ICoreElement, IsText {

    /**
     * Gets the helper text of the element as an element.
     *
     * @return helper text as {@link Text}
     * @see Text
     */
    @JDIAction("Get helper text element")
    default Text helperText() {
        return new Text().setCore(Text.class, find("p.MuiFormHelperText-root"));
    }

    /**
     * Gets the helper text of the element as a string.
     *
     * @return helper text as {@link String}
     */
    @JDIAction("Get helper text")
    default String getHelperText() {
        if (helperText().isDisplayed()) {
            return helperText().getText();
        } else {
            return null;
        }
    }
}
