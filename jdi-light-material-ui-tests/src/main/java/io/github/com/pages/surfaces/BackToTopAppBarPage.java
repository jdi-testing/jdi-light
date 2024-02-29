package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.AppBar;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class BackToTopAppBarPage extends WebPage {

    // @todo #5297 Check the locator, looks like it is not for AppBar (or use correct classname)
    @UI(".MuiBox-root[1]")
    public static AppBar backToTopAppBar;

    @UI("div[role=presentation]")
    public static Button backToTopButton;
}
