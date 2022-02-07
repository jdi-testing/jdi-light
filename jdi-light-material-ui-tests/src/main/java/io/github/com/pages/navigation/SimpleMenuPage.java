package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.List;
import com.epam.jdi.light.material.elements.navigation.Menu;

public class SimpleMenuPage extends WebPage {
    // TODO: it is a button, not a menu. Recheck all elements on the page
    @UI("span.MuiButton-label")
    public static Menu menu;

    @UI("//div[contains(@class,'MuiListItemText-multiline')]")
    public static Menu selectedMenu;

    @UI("button[class$=MuiIconButton-root][aria-controls='long-menu']")
    public static Menu scrollMenu;

    @UI("div[class^=MuiBox-root]>div div:nth-of-type(1) svg")
    public static Menu iconMenu;

    @UI("ul.MuiList-root.MuiMenu-list.MuiList-padding")
    public static List simpleMenuList;
}
