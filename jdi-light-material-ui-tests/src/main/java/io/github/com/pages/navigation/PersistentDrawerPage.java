package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.epam.jdi.light.material.elements.surfaces.AppBar;
import io.github.com.custom.elements.ClosableDrawer;

public class PersistentDrawerPage extends WebPage {

    @UI("header.MuiAppBar-root")
    public static AppBar appBar;

    @UI(".MuiDrawer-root")
    public static ClosableDrawer persistentDrawer;
}
