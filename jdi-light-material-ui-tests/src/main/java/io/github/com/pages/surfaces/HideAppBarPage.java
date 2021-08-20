package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.annotations.JAppBar;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class HideAppBarPage extends WebPage {

    @JAppBar(
            root = ".MuiAppBar-root",
            title = ".MuiTypography-root"
    )
    public static AppBar hideAppBar;
}
