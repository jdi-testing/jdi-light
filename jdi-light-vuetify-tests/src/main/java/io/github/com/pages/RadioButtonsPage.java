package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.RadioButtons;

import java.util.List;

public class RadioButtonsPage extends VuetifyPage {

    @UI("#ColorsRadioButton div .v-radio")
    public static RadioButtons colorRadioButtons;

    @UI("#DirectionRadioButton div .v-radio")
    public static List<RadioButtons> directionRadioButtons;

    @UI("#MandatoryRadioButton div .v-radio")
    public static List<RadioButtons> mandatoryRadioButtons;

    @UI("#LabelRadioButton div .v-radio")
    public static List<RadioButtons> labelRadioButtons;

    @UI("#MandatoryRadioButton > p ")
    public static Label mandatoryText;
}
