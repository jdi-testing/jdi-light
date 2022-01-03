package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Drawer;

public class PermanentDrawerPage extends WebPage {

    @UI(".MuiDrawer-paper")
    public static Drawer permanentDrawer;
}
