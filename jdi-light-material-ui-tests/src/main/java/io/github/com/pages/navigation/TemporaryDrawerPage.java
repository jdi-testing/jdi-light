package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;

public class TemporaryDrawerPage extends WebPage {

    @UI("[type=button]")
    public static List<Button> temporaryDrawerButtons;

    @UI("div .MuiDrawer-paper")
    public static Drawer temporaryDrawer;
}
