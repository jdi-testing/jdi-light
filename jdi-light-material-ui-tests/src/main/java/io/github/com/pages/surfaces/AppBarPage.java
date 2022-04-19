package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class AppBarPage extends WebPage {

    @UI("(//header[contains(@class, 'MuiAppBar-root')])[1]")
    public static AppBar simpleAppBar;

    @UI(".MuiSwitch-root")
    public static Checkbox userIconSwitch;

    @UI("(//header[contains(@class, 'MuiAppBar-root')])[2]")
    public static AppBar appBarMenu;

    @UI("//li[contains(@class, 'MuiMenuItem-root')]")
    public static Menu appBarMenuItems;

    @UI("(//header[contains(@class, 'MuiAppBar-root')])[3]")
    public static AppBar prominentMenu;
}
