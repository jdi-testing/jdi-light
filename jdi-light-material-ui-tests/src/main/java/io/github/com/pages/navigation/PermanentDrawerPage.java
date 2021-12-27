package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JAppBar;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class PermanentDrawerPage extends WebPage {

    @UI(".MuiDrawer-root")
    public static Drawer permanentDrawer;
}
