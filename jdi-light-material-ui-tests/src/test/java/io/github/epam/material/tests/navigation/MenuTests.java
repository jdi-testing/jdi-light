package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;


public class MenuTests extends TestsInit {

    @Test
    public void simpleMenuTest() {
        simpleMenuPage.open();

        menuFrame.menu.has().text("OPEN MENU");
        menuFrame.menu.click();
        menuFrame.menuList.is().displayed();
        menuFrame.menuListFirstButton.has().text("Profile");
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void scrollMenuTest() {
        scrollMenuPage.open();

        menuFrame.menu.has().text("OPEN MENU");
        menuFrame.menu.click();
        menuFrame.scrollMenuList.is().displayed();
        menuFrame.menuListFirstButton.has().text("Profile");
        menuFrame.menuListLastButton.scrollToElement();
        menuFrame.menuListLastButton.is().displayed();
        menuFrame.menuListLastButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void selectedVerticalPositioningTest() {
        selectedVerticalPositioningPage.open();

        menuFrame.menu.has().text("Selected Menu\nMy account");
        menuFrame.menu.click();
        menuFrame.scrollMenuList.is().displayed();
        menuFrame.menuListFirstButton.has().text("Profile");
        menuFrame.menuListFirstButton.click();
        menuFrame.menuSelectedField.has().text("Profile");
        menuFrame.menu.is().displayed();
    }

    @Test
    public void selectedNoVerticalPositioningTest() {
        selectedNoVerticalPositioningPage.open();

        menuFrame.menu.has().text("Selected Menu\nMy account");
        menuFrame.menu.click();
        menuFrame.scrollMenuList.is().displayed();
        menuFrame.menuListFirstButton.has().text("Profile");
        menuFrame.menuListFirstButton.click();
        menuFrame.menuSelectedField.has().text("Profile");
        menuFrame.menu.is().displayed();
    }

    @Test
    public void positioningMenuTest() {
        positioningMenuPage.open();

        menuFrame.menu.has().text("TOGGLE MENU GROW");
        menuFrame.menu.click();
        menuFrame.paddingMenuList.is().displayed();
        menuFrame.menuListFirstButton.has().text("Profile");
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void contextMenuTest() {
        contextMenuPage.open();

        menuFrame.contextMenu.is().displayed();
        menuFrame.contextMenu.rightClick();
        menuFrame.menuListFirstButton.has().text("Copy");
        menuFrame.menuListFirstButton.click();
        menuFrame.contextMenu.is().displayed();
    }

    @Test
    public void menuWithIconsTest() {
        menuWithIconsPage.open();

        menuFrame.menu.is().displayedSvg();
        menuFrame.menu.click();
        menuFrame.paddingMenuList.is().displayed();
        menuFrame.menuListFirstButton.is().displayedSvg();
        menuFrame.menuListFirstButton.has().text("Text with send icon");
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }
}
