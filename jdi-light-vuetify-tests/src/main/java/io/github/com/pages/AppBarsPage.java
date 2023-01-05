package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import io.github.com.custom.bars.AppBarWithTabs;

public class AppBarsPage extends VuetifyPage {

    @UI("#outlineBar .v-toolbar")
    public static AppBar outlinedBar;

    @UI("#flatBar .v-toolbar")
    public static AppBar flatBar;

    @UI("#roundedBar .v-toolbar")
    public static AppBar roundedBar;

    @UI("#shapedBar .v-toolbar")
    public static AppBar shapedBar;

    @UI("#denseBar .v-toolbar")
    public static AppBar denseBar;

    @UI("#elevatedBar .v-toolbar")
    public static AppBar elevatedBar;

    @UI("#collapsibleBar .v-toolbar")
    public static AppBar collapsibleBar;

    @UI("#elevateScrollBar .v-toolbar")
    public static AppBar elevateOnScrollBar;

    @UI("#imageBar .v-toolbar")
    public static AppBar imageBar;

    @UI("#hidingScrollBar .v-toolbar")
    public static AppBar hidingScrollBar;

    @UI("#fadeImageBar .v-toolbar")
    public static AppBarWithTabs fadeImageOnScrollBar;

    @UI("#scrollThresholdBar .v-toolbar")
    public static AppBar scrollThresholdBar;

    @UI("#toggleNavigationDrawersBar .v-toolbar")
    public static AppBar toggleNavigationDrawersBar;
}
