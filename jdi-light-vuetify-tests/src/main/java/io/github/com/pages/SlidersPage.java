package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.complex.TextField;

import java.util.List;

public class SlidersPage extends VuetifyPage {

    @UI("#ColorsSlider .v-slider")
    public static List<Slider> colorsSlider;

    @UI("#ColorsSlider .v-input__control")
    public static List<Slider> colorsSliderControl;

    @UI("#DisabledSlider .v-slider")
    public static Slider disabledSlider;

    @UI("#DisabledSlider .v-input__control")
    public static Slider disabledSliderControl;

    @UI("#DiscreteSlider .v-slider")
    public static Slider discreteSlider;

    @UI("#DiscreteSlider .v-input__control")
    public static Slider discreteSliderControl;

    @UI("#IconsSlider .v-slider")
    public static List<Slider> iconsSlider;

    @UI("#IconsSlider .v-input__control")
    public static List<Slider> iconsSliderControl;

    @UI("#IconsSlider .v-input__icon")
    public static List<Icon> iconsSliderInputIcon;

    @UI("#InverseLabelSlider")
    public static UIElement inverseLabel;

    @UI("#InverseLabelSlider .v-input__control")
    public static Slider inverseSliderControl;

    @UI("#MinAndMaxSlider .v-slider")
    public static Slider minAndMaxSlider;

    @UI("#MinAndMaxSlider .v-input__control")
    public static Slider minAndMaxSliderControl;

    @UI("#MinAndMaxSlider")
    public static TextField minAndMaxInput;

    @UI("#ReadonlySlider .v-slider")
    public static Slider readonlySlider;

    @UI("#ReadonlySlider .v-input__control")
    public static Slider readonlySliderControl;

    @UI("#StepSlider .v-slider")
    public static Slider stepSlider;

    @UI("#StepSlider .v-input__control")
    public static Slider stepSliderControl;

    @UI("#ThumbSlider .v-slider")
    public static List<Slider> thumbSlider;

    @UI("#ThumbSlider .v-input__control")
    public static List<Slider> thumbSliderControl;

    @UI("#TicksSlider .v-slider")
    public static List<Slider> ticksSlider;

    @UI("#TicksSlider .v-input__control")
    public static List<Slider> ticksSliderControl;

    @UI("#ValidationSlider .v-slider")
    public static List<Slider> validationSlider;

    @UI("#ValidationSlider .v-input__control")
    public static List<Slider> validationSliderControl;

    @UI("#VerticalSlidersSlider .v-slider")
    public static Slider verticalSlidersSlider;

    @UI("#VerticalSlidersSlider .v-input__control")
    public static Slider verticalSlidersSliderControl;

    @UI("#AppendAndPrependSlider .v-slider")
    public static Slider appendAndPrependSlider;

    @UI("#AppendAndPrependSlider .v-input__control")
    public static Slider appendAndPrependSliderControl;

    @UI("#AppendAndPrependSlider .text-h2")
    public static UIElement appendAndPrependText;

    @UI("#AppendAndPrependSlider .v-avatar--metronome")
    public static UIElement appendAndPrependFlashPoint;

    @UI("#AppendAndPrependSlider .v-btn--fab")
    public static VuetifyButton appendAndPrependPlayButton;

    @UI("#AppendAndPrependSlider .v-input .v-icon")
    public static List<UIElement> appendAndPrependInputIcon;

    @UI("#AppendTextFieldSlider .v-slider")
    public static List<Slider> appendTextFieldSlider;

    @UI("#AppendTextFieldSlider .v-text-field__slot input")
    public static List<UIElement> appendTextFieldInput;

}
