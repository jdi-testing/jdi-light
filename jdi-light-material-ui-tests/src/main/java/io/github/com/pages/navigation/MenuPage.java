package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Menu;

public class MenuPage extends WebPage {
    @UI("span.MuiButton-label")
    public static Menu menu;

    @UI("//div[contains(@class,'MuiListItemText-multiline')]")
    public static Menu selelectedMenu;

    @UI("button[class$=MuiIconButton-root][aria-controls='long-menu']")
    public static Menu scrollMenu;

    @UI("div[class^=MuiBox-root]>div div:nth-of-type(1) svg")
    public static Menu iconMenu;

    @UI(".MuiMenu-list")
    public static Menu menuList;

    @UI(".MuiMenu-paper")
    public static Menu scrollMenuList;

    @UI("div[class*=MuiPaper-root][style*='opacity: 1']")
    public static Menu paddingMenuList;

    @UI("li.MuiListItem-button:first-child")
    public static Menu menuListFirstButton;

    @UI("li.MuiListItem-button:last-child")
    public static Menu menuListLastButton;

    @UI("//*/p[starts-with(@class, 'MuiTypography')]")
    public static Menu contextMenu;

    @UI("p.MuiTypography-displayBlock")
    public static Menu menuSelectedField;
}
