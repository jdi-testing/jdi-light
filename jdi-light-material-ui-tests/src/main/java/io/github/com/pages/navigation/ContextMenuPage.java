package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Menu;

public class ContextMenuPage extends WebPage {

    @UI("li.MuiListItem-button:first-child")
    public static Menu menuContextListFirstButton;

    @UI("li.MuiListItem-button:last-child")
    public static Menu menuContextListLastButton;

    @UI("//*/p[starts-with(@class, 'MuiTypography')]")
    public static Menu contextMenu;
}
