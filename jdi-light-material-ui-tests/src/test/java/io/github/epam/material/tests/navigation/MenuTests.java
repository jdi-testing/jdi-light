package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.contextMenuPage;
import static io.github.com.StaticSite.simpleMenuPage;
import static io.github.com.pages.navigation.ContextMenuPage.contextMenu;
import static io.github.com.pages.navigation.ContextMenuPage.menuContextListLastButton;
import static io.github.com.pages.navigation.SimpleMenuPage.iconMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.menu;
import static io.github.com.pages.navigation.SimpleMenuPage.menuList;
import static io.github.com.pages.navigation.SimpleMenuPage.menuListFirstButton;
import static io.github.com.pages.navigation.SimpleMenuPage.menuListLastButton;
import static io.github.com.pages.navigation.SimpleMenuPage.menuSelectedField;
import static io.github.com.pages.navigation.SimpleMenuPage.paddingMenuList;
import static io.github.com.pages.navigation.SimpleMenuPage.scrollMenu;
import static io.github.com.pages.navigation.SimpleMenuPage.scrollMenuList;
import static io.github.com.pages.navigation.SimpleMenuPage.selelectedMenu;

public class MenuTests extends TestsInit {

    @BeforeMethod
    public void before() {
        simpleMenuPage.open();
        simpleMenuPage.isOpened();
    }

    @Test
    public void simpleMenuTest() {
        menu.has().text("OPEN MENU");
        menu.click();
        menuList.is().displayed();
        menuListFirstButton.has().text("Profile");
        menuListFirstButton.click();
        menu.is().displayed();
    }

    @Test
    public void scrollMenuTest() {
        scrollMenu.click();
        scrollMenuList.is().displayed();
        menuListFirstButton.has().text("None");
        menuListLastButton.scrollToElement();
        menuListLastButton.is().displayed();
        menuListLastButton.click();
        scrollMenu.is().displayed();
    }

    @Test
    public void selectedVerticalPositioningTest() {
        selelectedMenu.has().text("Selected Menu\nMy account");
        selelectedMenu.click();
        scrollMenuList.is().displayed();
        menuListFirstButton.has().text("Profile");
        menuListFirstButton.click();
        menuSelectedField.has().text("Profile");
        selelectedMenu.is().displayed();
    }

    @Test
    public void contextMenuTest() {
        contextMenuPage.open();
        contextMenu.rightClick();
        menuContextListLastButton.has().text("Email");
        menuContextListLastButton.click();
        contextMenu.isDisplayed();
    }

    @Test
    public void menuWithIconsTest() {
        iconMenu.is().displayedSvg();
        iconMenu.click();
        paddingMenuList.is().displayed();
        menuListFirstButton.is().displayedSvg();
        menuListFirstButton.has().text("Text with send icon");
        menuListFirstButton.click();
        iconMenu.is().displayed();
    }
}
