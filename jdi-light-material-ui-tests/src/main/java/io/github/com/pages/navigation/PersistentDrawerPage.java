package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class PersistentDrawerPage extends WebPage {

    @UI("header.MuiAppBar-root")
    public static AppBar appBar;

    @UI(".MuiDrawer-paper")
    public static Drawer persistentDrawer;
}
