package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Represents alert MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/alert/">Alert MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */

public class Alert extends UIBaseElement<TextAssert> implements IsText, HasIcon {

    /**
     * Gets the title of this alert.
     *
     * @return title of this alert as {@link Text}
     * @see Text
     */
    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, core().find(".MuiAlertTitle-root"));
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
