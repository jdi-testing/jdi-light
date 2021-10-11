package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.GetAny;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.RangeSlider;

public class RangeSlidersPage extends VuetifyPage {

    @UI("#DisabledRangeSlider .v-slider")
    public static RangeSlider disabledRangeSlider;

    @UI("#MinAndMaxRangeSlider .v-slider")
    public static RangeSlider minAndMaxRangeSlider;

    @UI("#StepRangeSlider .v-slider")
    public static RangeSlider stepRangeSlider;

    @UI("#VerticalSlidersRangeSlider .v-slider")
    public static RangeSlider verticalSlidersRangeSlider;

    @GetAny
    @UI("#ThumbLabelRangeSlider .v-slider")
    public static RangeSlider thumbLabelRangeSlider;
}
