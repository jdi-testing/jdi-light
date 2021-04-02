package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Menu;

public class MenuFrame extends Section {
    @UI(".MuiButtonBase-root")
    public Menu menu;

    @UI(".MuiMenu-list")
    public Menu menuList;

    @UI(".MuiMenu-paper")
    public Menu scrollMenuList;

    @UI(".MuiList-padding")
    public Menu paddingMenuList;

    @UI("li.MuiListItem-button:first-child")
    public Menu menuListFirstButton;

    @UI("li.MuiListItem-button:last-child")
    public Menu menuListLastButton;

    @UI(".sb-main-padded")
    public Menu contextMenu;

    @UI(".MuiListItemIcon-root > svg")
    public Menu menuIcon;

    @UI("p.MuiTypography-displayBlock")
    public Menu menuSelectedField;
}
