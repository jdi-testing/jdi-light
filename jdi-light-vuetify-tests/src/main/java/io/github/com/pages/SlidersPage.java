package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import java.util.List;

public class SlidersPage extends VuetifyPage {

    @UI("#ColorsSlider .v-input__slider")
    public static List<Slider> colorsSlider;

    @UI("#DisabledSlider .v-input__slider")
    public static Slider disabledSlider;

    @UI("#DisabledSlider .v-input__slider")
    public static Slider disabledSliderControl;

    @UI("#DiscreteSlider .v-input__slider")
    public static Slider discreteSlider;

    @UI("#IconsSlider .v-input__slider")
    public static List<Slider> iconsSlider;
    @UI("#InverseLabelSlider .v-input__slider")
    public static Slider inverseLabelSlider;

    @UI("#ReadonlySlider .v-input__slider")
    public static Slider readonlySlider;

    @UI("#StepSlider .v-input__slider")
    public static Slider stepSlider;

    @UI("#ThumbSlider .v-input__slider")
    public static List<Slider> thumbSlider;

    @UI("#TicksSlider .v-input__slider")
    public static List<Slider> ticksSlider;

    @UI("#ValidationSlider .v-input__slider")
    public static List<Slider> validationSlider;

    @UI("#VerticalSlidersSlider .v-input__slider")
    public static Slider verticalSlidersSlider;

    @UI("#AppendTextFieldSlider .v-input__slider")
    public static List<Slider> appendTextFieldSlider;

    @UI("#AppendTextFieldSlider .v-text-field__slot")
    public static List<TextField> appendTextField;

    @UI("#AdjustableSlider .v-input__slider")
    public static Slider adjustableSlider;

    @UI("#AdjustableSlider .v-input--switch [1]")
    public static Switch themeSwitch;

    @UI("#AdjustableSlider .v-input--switch [2]")
    public static Switch denseSwitch;

    @UI("#AdjustableSlider .v-text-field [2]")
    public static TextField errorCountTextField;

    @UI("#AdjustableSlider .v-text-field [3]")
    public static TextField heightTextField;

    @UI("#AdjustableSlider .v-input--switch [3]")
    public static Switch hideDetailsSwitch;

    @UI("#AdjustableSlider .v-text-field [4]")
    public static TextField loaderHeightTextField;

    @UI("#AdjustableSlider .v-input--switch [5]")
    public static Switch loadingSwitch;

    @UI("#AdjustableSlider .v-text-field [5]")
    public static TextField successMessageTextField;

    @UI("#AdjustableSlider .v-input--switch [7]")
    public static Switch validateOnBlurSwitch;
}
