package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Switch;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class SimpleAppBarPage extends WebPage {

    @UI(".MuiAppBar-root[1]")
    public static AppBar simpleAppBar;

    @UI(".MuiSwitch-root")
    public static Switch userIconSwitch;

    @UI(".MuiAppBar-root[2]")
    public static AppBar appBarWithMenu;

    @UI(".MuiMenuItem-root")
    public static Menu appBarMenuItems;

    @UI(".MuiAppBar-root[3]")
    public static AppBar prominentAppBar;
}
