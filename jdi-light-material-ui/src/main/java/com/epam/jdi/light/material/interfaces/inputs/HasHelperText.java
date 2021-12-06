package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;

public interface HasHelperText extends ICoreElement, IsText {

    @JDIAction("Get helper text element")
    default Text helperText() {
        return new Text().setCore(Text.class, find("p.MuiFormHelperText-root"));
    }

    @JDIAction("Get helper text")
    default String getHelperText() {
        if(helperText().isDisplayed()) {
            return helperText().getText();
        } else {
            return null;
        }
    }
}
