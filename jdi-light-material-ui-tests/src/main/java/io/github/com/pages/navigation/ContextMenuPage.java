package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.navigation.Menu;

public class ContextMenuPage extends WebPage {

    @UI("p.MuiTypography-root")
    public static Menu contextMenu;

    @UI(".MuiMenu-list")
    public static List contextMenuList;
}
