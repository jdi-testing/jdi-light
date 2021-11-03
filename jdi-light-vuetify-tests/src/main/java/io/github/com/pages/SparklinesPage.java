package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.Sparkline;

public class SparklinesPage extends VuetifyPage {

    @UI("#FillSparkline")
    public static Sparkline fillSparkline;

    @UI("#CustomLabelsSparkline")
    public static Sparkline customLabelsSparkline;

    @UI("#DashboardCardSparkline")
    public static Sparkline dashboardCardSparkline;

    @UI("#HeartRateSparkline")
    public static Sparkline heartRateSparkline;
}
