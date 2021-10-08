package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;

public class NavigationDrawersPage extends VuetifyPage {

    @UI("#BottomDrawerNavigationDrawer")
    public static NavigationDrawer bottomDrawerNavigationDrawer;

    @UI("#ExpandOnHoverNavigationDrawer")
    public static NavigationDrawer expandOnHoverNavigationDrawer;

    @UI("#ImagesNavigationDrawer")
    public static NavigationDrawer imagesNavigationDrawer;

    @UI("#MiniVariantNavigationDrawer")
    public static NavigationDrawer miniVariantNavigationDrawer;

    @UI("#PermanentAndFloatingNavigationDrawer")
    public static NavigationDrawer permanentAndFloatingNavigationDrawer;

    @UI("#RightNavigationDrawer")
    public static NavigationDrawer rightNavigationDrawer;

    @UI("#TemporaryNavigationDrawer")
    public static NavigationDrawer temporaryNavigationDrawer;

    @UI("#ColoredDrawerNavigationDrawer")
    public static NavigationDrawer coloredDrawerNavigationDrawer;

    @UI("#CombinedDrawerNavigationDrawer")
    public static NavigationDrawer combinedDrawerNavigationDrawer;

}
