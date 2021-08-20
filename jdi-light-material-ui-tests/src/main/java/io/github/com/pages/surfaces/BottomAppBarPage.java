package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.material.annotations.JAppBar;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class BottomAppBarPage extends WebPage {

    @JAppBar(
            root = ".MuiAppBar-root",
            navigationButton = ".MuiIconButton-edgeStart",
            actionItems = {"//button[@aria-label='add']", "(//div[contains(@class, 'MuiToolbar-root')])/button[3]"},
            overflowMenuButton = ".MuiIconButton-edgeEnd"
    )
    public static AppBar bottomAppBar;
}
