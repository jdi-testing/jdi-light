package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;
import com.epam.jdi.light.ui.html.elements.common.Button;

/**
 * To see an example of Button With Spinner web element please visit https://getbootstrap.com/docs/4.3/components/spinners/#buttons
 */

public class ButtonWithSpinner extends Button {

    @UI("[class*='spinner']")
    public Spinner spinner;
}
