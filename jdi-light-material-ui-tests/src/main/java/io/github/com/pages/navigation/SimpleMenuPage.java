package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Menu;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class SimpleMenuPage extends WebPage {

    @UI(".MuiMenuItem-root")
    public static Menu menu;

    @UI(".MuiButton-text")
    public static Button simpleMenuButton;

    @UI("#selectedItem")
    public static Text selectedSimpleMenuItem;

    @UI(".MuiIconButton-root")
    public static Button iconMenuButton;

    @UI("#selectedIconMenu")
    public static Text selectedMenuIconItem;

    @UI(".MuiListItemText-multiline")
    public static Button selectedSelectedMenuButton;

    @UI(".MuiTypography-colorTextSecondary")
    public static Text selectedSelectedMenuItem;

    @UI("[aria-controls=long-menu]")
    public static Button scrollMenuButton;

    @UI("#selectedLongMenu")
    public static Text selectedScrollMenuItem;
}
