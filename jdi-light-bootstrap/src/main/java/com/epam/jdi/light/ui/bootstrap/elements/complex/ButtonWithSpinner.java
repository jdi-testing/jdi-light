package com.epam.jdi.light.ui.bootstrap.elements.complex;

import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Spinner;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class ButtonWithSpinner extends Button implements PageObject {
    public @UI("[class*='spinner']") Spinner spinner;
    public @UI("[class*='spinner'] + span")  TextField span;
}
