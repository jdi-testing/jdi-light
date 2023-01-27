package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.ColorPicker;
import com.epam.jdi.light.vuetify.elements.complex.RangeSlider;

import java.util.List;

public class RangeSlidersPage extends VuetifyPage {

    @UI("#DisabledRangeSlider .v-slider")
    public static RangeSlider disabledRangeSlider;

    @UI("#MinAndMaxRangeSlider .v-slider")
    public static RangeSlider minAndMaxRangeSlider;

    @UI("#StepRangeSlider .v-slider")
    public static RangeSlider stepRangeSlider;

    @UI("#VerticalSlidersRangeSlider .v-slider")
    public static RangeSlider verticalSlidersRangeSlider;

    @UI("#ThumbLabelRangeSlider .v-slider")
    public static RangeSlider thumbLabelRangeSlider;

    @UI("#AdjustableRangerSlider .v-slider")
    public static RangeSlider adjustableRangeSlider;

    @UI("#ColorRangerSlider .v-slider")
    public static RangeSlider colorRangeSlider;

    @UI("#ColorRangerSlider .v-color-picker")
    public static ColorPicker colorPicker;

    @UI("#AdjustableRangerSlider .v-input--is-label-active .v-input--selection-controls__input")
    public static UIElement thumbLabelControl;
}
