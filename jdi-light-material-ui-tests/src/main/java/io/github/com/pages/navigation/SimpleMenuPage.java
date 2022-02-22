package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SimpleMenuPage extends WebPage {
    @UI(".MuiButton-text")
    public static Button menuButton;

    @UI("[role='menu']")
    public static Menu items;

    @UI(".MuiMenu-list")
    public static List menuItems;

    @UI("[class$='multiline']")
    public static Button selectedMenuButton;

    @UI("[aria-controls='long-menu']")
    public static Button scrollMenuButton;

    @UI("[class$=MuiIconButton-root]")
    public static Button iconMenuButton;

    @UI("[id='selectedItem']")
    public static Text selectedSimpleMenuItem;

    @UI("[id='selectedIconMenu']")
    public static Text selectedMenuIconItem;

    @UI("[class*=colorTextSecondary]")
    public static Text selectedMenuItem;

    @UI("[id='selectedLongMenu']")
    public static Text selectedScrollMenuItem;
}
