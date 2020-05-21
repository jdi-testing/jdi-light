package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import elements.common.Icon;
import elements.common.Spinner;

public class AngularPage extends WebPage {
    @Css("radio-overview-example .mat-radio-group")
    public static RadioButtons basicRadioButtons;

    @UI("#mat-radio-2")
    public static Button firstBasicRadioButton;

    @UI("#mat-radio-3")
    public static Button secondBasicRadioButton;

    @Css(".mat-spinner")
    public static Spinner basicProgressSpinner;

    @XPath("//mat-icon[contains(@aria-label,'home icon')]")
    public static Icon basicIcon;

    @XPath("//mat-icon[contains(@aria-label,'SVG icon')]")
    public static Icon svgIcon;
}
