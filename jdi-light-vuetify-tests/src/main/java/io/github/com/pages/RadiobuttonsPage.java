package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Radiobutton;

import java.util.List;

public class RadiobuttonsPage extends VuetifyPage {

    @UI("#ColorsRadioButton div .v-radio")
    public static List<Radiobutton> colorRadiobutton;

    @UI("#DirectionRadioButton div .v-radio")
    public static List<Radiobutton> directionRadiobutton;

    @UI("#MandatoryRadioButton div .v-radio")
    public static List<Radiobutton> mandatoryRadiobutton;

    @UI("#LabelRadioButton div .v-radio")
    public static List<Radiobutton> labelRadiobutton;

    @UI("#MandatoryRadioButton > p ")
    public static Label mandatoryText;

}
