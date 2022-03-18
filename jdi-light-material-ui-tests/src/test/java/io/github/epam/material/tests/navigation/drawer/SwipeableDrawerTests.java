package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.swipeableDrawerPage;
import static io.github.com.pages.navigation.SwipeableDrawerPage.bottomDrawerButton;
import static io.github.com.pages.navigation.SwipeableDrawerPage.leftDrawerButton;
import static io.github.com.pages.navigation.SwipeableDrawerPage.rightDrawerButton;
import static io.github.com.pages.navigation.SwipeableDrawerPage.topDrawerButton;

public class SwipeableDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        swipeableDrawerPage.open();
        swipeableDrawerPage.shouldBeOpened();
    }

    @Test
    public void leftSwipeableDrawerTest() {
        leftDrawerButton.click();
        leftDrawerButton.drawer().is().displayed().and().has().position(Position.LEFT);
        leftDrawerButton.drawer().close();
        leftDrawerButton.drawer().is().notExist();
    }

    @Test
    public void rightSwipeableDrawerTest() {
        rightDrawerButton.click();
        rightDrawerButton.drawer().is().displayed().and().has().position(Position.RIGHT);
        rightDrawerButton.drawer().close();
        rightDrawerButton.drawer().is().notExist();
    }

    @Test
    public void topSwipeableDrawerTest() {
        topDrawerButton.click();
        topDrawerButton.drawer().is().displayed().and().has().position(Position.TOP);
        topDrawerButton.drawer().close();
        topDrawerButton.drawer().is().notExist();
    }

    @Test
    public void bottomSwipeableDrawerTest() {
        bottomDrawerButton.click();
        bottomDrawerButton.drawer().is().displayed().and().has().position(Position.BOTTOM);
        bottomDrawerButton.drawer().close();
        bottomDrawerButton.drawer().is().notExist();
    }
}
