package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class ElevateAppBarPage extends WebPage {

    @UI(".MuiAppBar-root")
    public static AppBar elevateAppBar;
}
