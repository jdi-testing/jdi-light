package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VuetifyButton;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;

public class NavigationDrawersPage extends VuetifyPage {

    @UI("#BottomDrawerNavigationDrawer .v-toolbar")
    public static ToolBar bottomNavigationDrawerToolBar;

    @UI("#BottomDrawerNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer bottomNavigationDrawer;

    @UI("#ExpandOnHoverNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer expandOnHoverNavigationDrawer;

    @UI("#ImagesNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer imagesNavigationDrawer;

    @UI("#MiniVariantNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer miniVariantNavigationDrawer;

    @UI("#PermanentAndFloatingNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer permanentAndFloatingNavigationDrawer;

    @UI("#RightNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer rightNavigationDrawer;

    @UI("#TemporaryNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer temporaryNavigationDrawer;

    @UI("#TemporaryNavigationDrawer button")
    public static VuetifyButton temporaryNavigationDrawerButton;

    @UI("#ColoredDrawerNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer coloredNavigationDrawer;

    @UI("#ClippedNavigationDrawer .v-navigation-drawer")
    public static NavigationDrawer clippedNavigationDrawer;

}
