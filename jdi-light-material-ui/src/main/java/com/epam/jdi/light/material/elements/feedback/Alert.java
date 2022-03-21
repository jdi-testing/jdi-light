package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * To see an example of Dialog web element please visit
 * https://jdi-testing.github.io/jdi-light/material/alert
 */

public class Alert extends UIBaseElement<TextAssert> implements IsText {

    @UI(".MuiSvgIcon-root")
    public Icon icon;

    @UI(".MuiAlertTitle-root")
    public Text title;

    @Override
    public TextAssert is() {
        return new TextAssert().set(this);
    }
}
