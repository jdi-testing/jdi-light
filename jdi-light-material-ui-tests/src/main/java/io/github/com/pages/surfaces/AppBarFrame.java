package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class AppBarFrame extends Section {
    @UI(".MuiIconButton-label")
    public AppBar menu;

    @UI(".MuiTypography-root")
    public AppBar news;

    @UI(".MuiButton-label")
    public AppBar login;
}
