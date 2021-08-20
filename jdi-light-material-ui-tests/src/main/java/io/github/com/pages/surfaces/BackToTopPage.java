package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JAppBar;
import com.epam.jdi.light.material.elements.surfaces.AppBar;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class BackToTopPage extends WebPage {

    @JAppBar(
            root = "(//div[contains(@class, 'MuiBox-root')])[1]",
            title = ".MuiTypography-h6"
    )
    public static AppBar backToTopAppBar;

    @UI("div[role=presentation]")
    public static Button backToTopButton;
}
