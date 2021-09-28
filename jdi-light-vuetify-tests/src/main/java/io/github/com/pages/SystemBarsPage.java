package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;

public class SystemBarsPage extends VuetifyPage {

    @UI("#collapsibleBar")
    public static SystemBar collapsibleBar;

    @UI("#denseBar")
    public static SystemBar denseBar;

    @UI("#elevateScrollBar")
    public static SystemBar elevateScrollBar;

    @UI("#imageBar")
    public static SystemBar imageBar;

    @UI("#hidingScrollBar")
    public static SystemBar hidingScrollBar;

    @UI("#fadeImageBar")
    public static SystemBar fadeImageBar;

    @UI("#scrollThresholdBar")
    public static SystemBar scrollThresholdBar;

    @UI("#toggleNavigationDrawersBar")
    public static SystemBar toggleNavigationDrawersBar;

}