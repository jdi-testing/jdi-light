package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;


public class MenuTests extends TestsInit {

    @Test
    public void simpleMenuTest() {
        simpleMenuPage.open();

        menuFrame.menu.click();
        menuFrame.menuList.is().displayed();
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void scrollMenuTest() {
        scrollMenuPage.open();

        menuFrame.menu.click();
        menuFrame.scrollMenuList.is().displayed();
        menuFrame.menuListLastButton.scrollToElement();
        menuFrame.menuListLastButton.is().displayed();
        menuFrame.menuListLastButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void selectedVerticalPositioningTest() {
        selectedVerticalPositioningPage.open();

        menuFrame.menu.click();
        menuFrame.scrollMenuList.is().displayed();
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void selectedNoVerticalPositioningTest() {
        selectedNoVerticalPositioningPage.open();

        menuFrame.menu.click();
        menuFrame.scrollMenuList.is().displayed();
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void positioningMenuTest() {
        positioningMenuPage.open();

        menuFrame.menu.click();
        menuFrame.paddingMenuList.is().displayed();
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }

    @Test
    public void contextMenuTest() {
        contextMenuPage.open();

        menuFrame.contextMenu.is().displayed();
    }

    @Test
    public void menuWithIconsTest() {
        menuWithIconsPage.open();

        menuFrame.menu.click();
        menuFrame.paddingMenuList.is().displayed();
        menuFrame.menuIcon.is().displayedSvg();
        menuFrame.menuListFirstButton.click();
        menuFrame.menu.is().displayed();
    }
}
