package io.github.epam.material.tests.navigation.drawer;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.temporaryDrawerPage;
import static io.github.com.pages.navigation.TemporaryDrawerPage.*;

public class TemporaryDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        temporaryDrawerPage.open();
        temporaryDrawerPage.shouldBeOpened();
    }

    @Test
    public void leftTemporaryDrawerTest() {
        leftDrawerButton.click();
        leftDrawerButton.drawer().is().displayed();
        leftDrawerButton.drawer().has().position("left");
        leftDrawerButton.drawer().close();
        leftDrawerButton.drawer().is().notExist();
    }

    @Test
    public void rightTemporaryDrawerTest() {
        rightDrawerButton.click();
        rightDrawerButton.drawer().is().displayed();
        rightDrawerButton.drawer().has().position("right");
        rightDrawerButton.drawer().close();
        rightDrawerButton.drawer().is().notExist();
    }

    @Test
    public void topTemporaryDrawerTest() {
        topDrawerButton.click();
        topDrawerButton.drawer().is().displayed();
        topDrawerButton.drawer().has().position("top");
        topDrawerButton.drawer().close();
        topDrawerButton.drawer().is().notExist();
    }

    @Test
    public void bottomTemporaryDrawerTest() {
        bottomDrawerButton.click();
        bottomDrawerButton.drawer().is().displayed();
        bottomDrawerButton.drawer().has().position("bottom");
        bottomDrawerButton.drawer().close();
        bottomDrawerButton.drawer().is().notExist();
    }
}
