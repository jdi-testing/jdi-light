package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.ButtonToggle;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ButtonTogglePage extends NewAngularPage {
    @UI("(//*[@id='mat-button-toggle-group-font'])[1]")
    public static ButtonToggle basicButtonToggle;

    @UI("[multiple]")
    public static ButtonToggle basicButtonToggleMultipleSelect;

    @UI("#mat-button-toggle-group-align")
    public static ButtonToggle basicButtonToggleAlign;

    @UI("div.example-selected-value")
    public static Text selectedValue;

    @UI("#mat-button-toggle-group-appearance")
    public static ButtonToggle buttonToggleAppearance;

    @UI("#mat-button-toggle-group-disabled")
    public static ButtonToggle buttonToggleDisabled;

    @UI("#mat-button-toggle-group-vertical")
    public static ButtonToggle buttonToggleVertical;

    @UI("#mat-button-toggle-group")
    public static ButtonToggle buttonToggleRippleDisabled;
}
