package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;
import com.epam.jdi.light.vuetify.elements.complex.bars.AppBar;

public class NavigationDrawersPage extends VuetifyPage {

    @UI("#BottomDrawerNavigationDrawer")
    public static AppBar bottomDrawerNavigationAppBar;

    @UI("#BottomDrawerNavigationDrawer aside")
    public static NavigationDrawer bottomDrawerNavigationDrawer;

    @UI("#ExpandOnHoverNavigationDrawer aside")
    public static NavigationDrawer expandOnHoverNavigationDrawer;

    @UI("#ImagesNavigationDrawer aside")
    public static NavigationDrawer imagesNavigationDrawer;

    @UI("#MiniVariantNavigationDrawer aside")
    public static NavigationDrawer miniVariantNavigationDrawer;

    @UI("#PermanentAndFloatingNavigationDrawer aside")
    public static NavigationDrawer permanentAndFloatingNavigationDrawer;

    @UI("#RightNavigationDrawer aside")
    public static NavigationDrawer rightNavigationDrawer;

    @UI("#TemporaryNavigationDrawer aside")
    public static NavigationDrawer temporaryNavigationDrawer;

    @UI("#TemporaryNavigationDrawer")
    public static UIElement temporaryNavigationDrawerContainer;

    @UI("#ColoredDrawerNavigationDrawer aside")
    public static NavigationDrawer coloredDrawerNavigationDrawer;

    @UI("#CombinedDrawerNavigationDrawer aside")
    public static NavigationDrawer combinedDrawerNavigationDrawer;

}
