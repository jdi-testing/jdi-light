package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.radiobuttons.RadioButtons;

public class RadioButtonsPage extends VuetifyPage {

    @UI("#ColorsRadioButton .col-12[1] [role=radio]")
    public static RadioButtons colorLeftRadioButtons;

    @UI("#DirectionRadioButton input[role = 'radio']")
    public static RadioButtons directionRadioButtons;

    @UI("#MandatoryRadioButton [role=radio]")
    public static RadioButtons mandatoryRadioButtons;

    @UI("#MandatoryRadioButton > p")
    public static Label mandatoryText;

    @UI("#LabelRadioButton [role=radio]")
    public static RadioButtons labelRadioButtons;

    @UI("#SuccessReadOnlyRadioButtonWithHint [role=radio]")
    public static RadioButtons successRadioButtons;

    @UI("#ErrorDenseRadioButton [role=radio]")
    public static RadioButtons errorRadioButtons;


    @UI("#DisabledRadioButton [role=radio]")
    public static RadioButtons disabledRadioButtons;
}
