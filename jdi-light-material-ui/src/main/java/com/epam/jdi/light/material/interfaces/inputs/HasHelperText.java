package com.epam.jdi.light.material.interfaces.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Represents an element with a helper text.
 * Helper text gives context about an input, such as hint or error message.
 *
 * @see <a href="https://mui.com/api/form-helper-text/"> FormHelperText API MUI Documentation </a>
 */
public interface HasHelperText extends ICoreElement, IsText {

    /**
     * Gets the helper text of the element.
     *
     * @return helper text as {@link Text}
     */
    @JDIAction("Get helper text")
    default Text helperText() {
        return new Text().setCore(Text.class, find("p.MuiFormHelperText-root"));
    }
}
