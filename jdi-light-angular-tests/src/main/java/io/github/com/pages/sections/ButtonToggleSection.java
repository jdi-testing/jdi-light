package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ButtonToggleSection {

    @UI("#mat-button-toggle-group-font")
    public static ButtonToggle basicButtonToggle;

    @UI("#mat-button-toggle-group-align")
    public static ButtonToggle basicButtonToggleAlign;
    @UI("div.example-selected-value")
    public static Text selectedValue;
}


