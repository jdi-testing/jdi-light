package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.RadioButtons;

public class RadioButtonsPage extends VuetifyPage {

    @UI("#ColorsRadioButton .col-12[1] [role=radio]")
    public static RadioButtons colorLeftRadioButtons;

    @UI("#ColorsRadioButton .col-12[2] [role=radio]")
    public static RadioButtons colorRightRadioButtons;

    @UI("#DirectionRadioButton input[role = 'radio']")
    public static RadioButtons directionRadioButtons;

    @UI("#MandatoryRadioButton [role=radio]")
    public static RadioButtons mandatoryRadioButtons;

    @UI("#LabelRadioButton [role=radio]")
    public static RadioButtons labelRadioButtons;

    @UI("#MandatoryRadioButton > p ")
    public static Label mandatoryText;
}
