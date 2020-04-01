package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;

public class AngularPage extends WebPage {

    @UI("#mat-radio-2")
    public static RadioButtons firstBasicRadioButton;


}
