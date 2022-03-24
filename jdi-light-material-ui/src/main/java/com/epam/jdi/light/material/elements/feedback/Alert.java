package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * To see an example of Alert web element please visit
 * https://jdi-testing.github.io/jdi-light/material/alert
 */

public class Alert extends UIBaseElement<TextAssert> implements IsText, HasIcon {

    private static String titleLocator = ".MuiAlertTitle-root";

    @JDIAction("Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, core().find(titleLocator));
    }

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
