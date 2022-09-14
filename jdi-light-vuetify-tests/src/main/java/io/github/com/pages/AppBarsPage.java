package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;
import io.github.com.custom.bars.AppBarWithTabs;

public class AppBarsPage extends VuetifyPage {

    @UI("#collapsibleBar .v-toolbar--collapse")
    public static AppBar collapsibleBar;

    @UI("#scrolling-techniques-6")
    public static UIElement collapsibleBarOverflow;

    @UI("#hidingScrollBar .v-toolbar")
    public static AppBar hidingScrollBar;

    @UI("#scrolling-techniques-4")
    public static UIElement hidingScrollBarOverflow;

    @UI("#fadeImageBar .v-toolbar")
    public static AppBarWithTabs fadeImageOnScrollBar;

    @UI("#scrolling-techniques-3")
    public static UIElement fadeImageOnScrollOverflow;

    @UI("#toggleNavigationDrawersBar .v-toolbar")
    public static AppBar toggleNavigationDrawersBar;

    @UI("#toggleNavigationDrawersBar .v-navigation-drawer ")
    public static NavigationDrawer navigationDrawer;
}
