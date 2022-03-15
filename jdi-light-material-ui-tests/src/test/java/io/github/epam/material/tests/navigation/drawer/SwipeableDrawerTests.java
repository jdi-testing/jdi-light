package io.github.epam.material.tests.navigation.drawer;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.swipeableDrawerPage;
import static io.github.com.pages.navigation.SwipeableDrawerPage.*;

public class SwipeableDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        swipeableDrawerPage.open();
        swipeableDrawerPage.shouldBeOpened();
    }

    @Test
    public void leftSwipeableDrawerTest() {
        leftDrawerButton.click();
        leftDrawerButton.drawer().is().displayed();
        leftDrawerButton.drawer().has().position("left");
        leftDrawerButton.drawer().close();
        leftDrawerButton.drawer().is().notExist();
    }

    @Test
    public void rightSwipeableDrawerTest() {
        rightDrawerButton.click();
        rightDrawerButton.drawer().is().displayed();
        rightDrawerButton.drawer().has().position("right");
        rightDrawerButton.drawer().close();
        rightDrawerButton.drawer().is().notExist();
    }

    @Test
    public void topSwipeableDrawerTest() {
        topDrawerButton.click();
        topDrawerButton.drawer().is().displayed();
        topDrawerButton.drawer().has().position("top");
        topDrawerButton.drawer().close();
        topDrawerButton.drawer().is().notExist();
    }

    @Test
    public void bottomSwipeableDrawerTest() {
        bottomDrawerButton.click();
        bottomDrawerButton.drawer().is().displayed();
        bottomDrawerButton.drawer().has().position("bottom");
        bottomDrawerButton.drawer().close();
        bottomDrawerButton.drawer().is().notExist();
    }
}
