package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Checkbox;
import com.epam.jdi.light.angular.elements.common.Slider;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;


public class SliderSection extends Section {
    @UI("#mat-slider-configurable")
    public static Slider matSliderConfigurable;
    @UI("#mat-slider-basic")
    public static Slider matSliderBasic;
    @UI("#mat-slider-formatting")
    public static Slider matSliderFormatting;
    @UI("#slider-configurable-value")
    public static TextField sliderConfigurableValue;
    @UI("#slider-configurable-min")
    public static TextField sliderConfigurableMin;
    @UI("#slider-configurable-max")
    public static TextField sliderConfigurableMax;
    @UI("#slider-configurable-step")
    public static TextField sliderConfigurableStep;
    @UI("#slider-configurable-thumb-label")
    public static Checkbox sliderConfigurableThumbLabel;
    @UI("#slider-configurable-vertical")
    public static Checkbox sliderConfigurableVertical;
    @UI("#slider-configurable-invert")
    public static Checkbox sliderConfigurableInvert;
    @UI("#slider-configurable-disabled")
    public static Checkbox sliderConfigurableDisabled;
}