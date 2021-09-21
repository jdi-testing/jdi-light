package io.github.com.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.AppBar;

public class AppBarsPage extends VuetifyPage {

    @UI("#collapsibleBar")
    public static AppBar collapsibleBar;

    @UI("#denseBar")
    public static AppBar denseBar;

    @UI("#elevateScrollBar")
    public static AppBar elevateScrollBar;

    @UI("#imageBar")
    public static AppBar imageBar;

    @UI("#hidingScrollBar")
    public static AppBar hidingScrollBar;

    @UI("#fadeImageBar")
    public static AppBar fadeImageBar;

    @UI("#scrollThresholdBar")
    public static AppBar scrollThresholdBar;

    @UI("#TwoLineBanner")
    public static AppBar toggleNavigationDrawersBar;

    @UI("//div[@role = 'menu']")
    public static Menu optionsMenu;

}
