package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.RadioButton;

import java.util.List;

public class RadioButtonsPage extends VuetifyPage {

    @UI("#ColorsRadioButton div .v-radio")
    public static List<RadioButton> colorRadioButton;

    @UI("#DirectionRadioButton div .v-radio")
    public static List<RadioButton> directionRadioButton;

    @UI("#MandatoryRadioButton div .v-radio")
    public static List<RadioButton> mandatoryRadioButton;

    @UI("#LabelRadioButton div .v-radio")
    public static List<RadioButton> labelRadioButton;

    @UI("#MandatoryRadioButton > p ")
    public static Label mandatoryText;
}
