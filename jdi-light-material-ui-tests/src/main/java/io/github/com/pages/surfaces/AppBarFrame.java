package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class AppBarFrame extends Section {

    @UI(".MuiToolbar-root")
    public AppBar appBar;
}
