package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JAppBar;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.material.elements.surfaces.AppBar;

public class AppBarPage extends WebPage {

    @JAppBar(
            root = "(//header[contains(@class, 'MuiAppBar-root')])[1]",
            navigationButton = ".MuiIconButton-edgeStart",
            title = ".MuiTypography-root",
            actionItems = {"//*[text()='News']/following-sibling::button"}
    )
    public static AppBar simpleAppBar;

    @UI(".MuiSwitch-root")
    public static Checkbox userIconSwitch;

    @JAppBar(
            root = "(//header[contains(@class, 'MuiAppBar-root')])[2]",
            navigationButton = ".MuiIconButton-edgeStart",
            title = ".MuiTypography-root",
            overflowMenuButton = "//h6[contains(text(), 'Photos')]/following-sibling::div/button"
    )
    public static AppBar appBarMenu;

    @UI("//li[contains(@class, 'MuiMenuItem-root')]")
    public static Menu appBarMenuItems;

    @JAppBar(
            root = "(//header[contains(@class, 'MuiAppBar-root')])[3]",
            navigationButton = ".MuiIconButton-edgeStart",
            title = ".MuiTypography-h5",
            actionItems = {"//h5/following-sibling::button[1]"},
            overflowMenuButton = ".MuiIconButton-edgeEnd"
    )
    public static AppBar prominentMenu;

}
