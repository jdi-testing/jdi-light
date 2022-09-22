package io.github.com.pages;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.common.Switch;
import com.epam.jdi.light.vuetify.elements.complex.sliders.Slider;
import com.epam.jdi.light.vuetify.elements.common.Sparkline;

public class SparklinesPage extends VuetifyPage {

    @UI("#FillSparkline svg")
    public static Sparkline fillSparkline;

    @UI(".mr-2.v-card")
    public static WebList fillSparklineColorSwitches;

    @UI("#FillSparkline .v-slider[1]")
    public static Slider fillSparklineWidthSlider;

    @UI("#FillSparkline .v-slider[2]")
    public static Slider fillSparklineRadiusSlider;

    @UI("#FillSparkline .v-slider[3]")
    public static Slider fillSparklinePaddingSlider;

    @UI("#FillSparkline .v-input--selection-controls__input")
    public static Switch fillSparklineFilledSwitch;

    @UI("#CustomLabelsSparkline svg")
    public static Sparkline customLabelsSparkline;

    @UI("#DashboardCardSparkline svg")
    public static Sparkline dashboardCardSparkline;

    @UI("#HeartRateSparkline svg")
    public static Sparkline heartRateSparkline;

    @UI(".mdi-heart-pulse")
    public static VuetifyButton heartRateRefreshButton;
}
