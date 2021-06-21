package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.navigation.SimpleMenuPage.*;
import static io.github.com.pages.navigation.ContextMenuPage.*;


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
        menuContextListFirstButton.has().text("Copy");
        menuContextListFirstButton.click();
        contextMenu.is().displayed();
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
