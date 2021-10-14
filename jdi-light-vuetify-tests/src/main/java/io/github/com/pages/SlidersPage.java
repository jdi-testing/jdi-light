package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Slider;

import java.util.List;

public class SlidersPage extends VuetifyPage {

    @UI("#ColorsSlider .v-slider")
    public static List<Slider> colorsSlider;

    @UI("#DisabledSlider .v-slider")
    public static Slider disabledSlider;

    @UI("#DiscreteSlider .v-slider")
    public static Slider discreteSlider;

    @UI("#IconsSlider .v-slider")
    public static List<Slider> iconsSlider;

    @UI("#IconsSlider .v-input__icon")
    public static List<UIElement> iconsSliderInputIcon;

    @UI("#InverseLabelSlider")
    public static UIElement inverseLabel;

    @UI("#MinAndMaxSlider .v-slider")
    public static Slider minAndMaxSlider;

    @UI("#ReadonlySlider .v-slider")
    public static Slider readonlySlider;

    @UI("#StepSlider .v-slider")
    public static Slider stepSlider;

    @UI("#ThumbSlider .v-slider")
    public static List<Slider> thumbSlider;

    @UI("#TicksSlider .v-slider")
    public static List<Slider> ticksSlider;

    @UI("#ValidationSlider .v-slider")
    public static List<Slider> validationSlider;

    @UI("#VerticalSlidersSlider .v-slider")
    public static Slider verticalSlidersSlider;

    @UI("#AppendAndPrependSlider .v-slider")
    public static Slider appendAndPrependSlider;

    @UI("#AppendAndPrependSlider .text-h2")
    public static UIElement appendAndPrependText;

    @UI("#AppendAndPrependSlider .v-input .v-icon")
    public static List<UIElement> appendAndPrependInputIcon;

    @UI("#AppendTextFieldSlider .v-slider")
    public static List<Slider> appendTextFieldSlider;

    @UI("#AppendTextFieldSlider .v-text-field__slot input")
    public static List<UIElement> appendTextFieldInput;

}
