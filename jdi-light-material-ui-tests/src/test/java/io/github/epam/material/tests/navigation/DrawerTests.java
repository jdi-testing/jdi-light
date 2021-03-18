package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.drawerFrame;
import static io.github.com.StaticSite.navigationDrawerMiniPage;
import static io.github.com.StaticSite.navigationDrawerPermanentLeftPage;
import static io.github.com.StaticSite.navigationDrawerPersistentLeftPage;
import static io.github.com.StaticSite.navigationDrawerPersistentRightPage;
import static io.github.com.StaticSite.navigationDrawerResponsivePage;
import static io.github.com.StaticSite.navigationDrawerTemporaryPage;

public class DrawerTests extends TestsInit {

    @Test
    public void temporaryLeftDrawerTest() {
        navigationDrawerTemporaryPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.clickLeftButton();
        drawerFrame.drawer.is().leftListDisplayed();
    }

    @Test
    public void temporaryRightDrawerTest() {
        navigationDrawerTemporaryPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.clickRightButton();
        drawerFrame.drawer.is().rightListDisplayed();
    }

    @Test
    public void temporaryTopDrawerTest() {
        navigationDrawerTemporaryPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.clickTopButton();
        drawerFrame.drawer.is().topListDisplayed();
    }

    @Test
    public void temporaryBottomDrawerTest() {
        navigationDrawerTemporaryPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.clickBottomButton();
        drawerFrame.drawer.is().bottomListDisplayed();
    }

    @Test
    public void responsiveDrawerTest() {
        navigationDrawerResponsivePage.open();
        drawerFrame.drawer.is().drawerDisplayed();
    }

    @Test
    public void persistentLeftDrawerTest() {
        navigationDrawerPersistentLeftPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.is().baseButtonDisplayed();
        drawerFrame.drawer.clickBaseButton();
        drawerFrame.drawer.is().leftListDisplayed();
    }

    @Test
    public void persistentRightDrawerTest() {
        navigationDrawerPersistentRightPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.is().baseButtonDisplayed();
        drawerFrame.drawer.clickBaseButton();
        drawerFrame.drawer.is().rightListDisplayed();
    }

    @Test
    public void miniDrawerTest() {
        navigationDrawerMiniPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.is().leftDockedDisplayed();
        drawerFrame.drawer.clickBaseButton();
        drawerFrame.drawer.is().leftListDisplayed();
    }

    @Test
    public void permanentLeftDrawerTest() {
        navigationDrawerPermanentLeftPage.open();
        drawerFrame.drawer.is().drawerDisplayed();
        drawerFrame.drawer.is().leftListDisplayed();
    }
}
