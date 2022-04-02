package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.temporaryDrawerPage;
import static io.github.com.pages.navigation.TemporaryDrawerPage.bottomDrawerButton;
import static io.github.com.pages.navigation.TemporaryDrawerPage.leftDrawerButton;
import static io.github.com.pages.navigation.TemporaryDrawerPage.rightDrawerButton;
import static io.github.com.pages.navigation.TemporaryDrawerPage.topDrawerButton;

public class TemporaryDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        temporaryDrawerPage.open();
        temporaryDrawerPage.shouldBeOpened();
    }

    @Test
    public void leftTemporaryDrawerTest() {
        leftDrawerButton.click();
        leftDrawerButton.drawer().is().displayed().and().has().position(Position.LEFT);
        leftDrawerButton.drawer().close();
        leftDrawerButton.drawer().is().notExist();
    }

    @Test
    public void rightTemporaryDrawerTest() {
        rightDrawerButton.click();
        rightDrawerButton.drawer().is().displayed().and().has().position(Position.RIGHT);
        rightDrawerButton.drawer().close();
        rightDrawerButton.drawer().is().notExist();
    }

    @Test
    public void topTemporaryDrawerTest() {
        topDrawerButton.click();
        topDrawerButton.drawer().is().displayed().and().has().position(Position.TOP);
        topDrawerButton.drawer().close();
        topDrawerButton.drawer().is().notExist();
    }

    @Test
    public void bottomTemporaryDrawerTest() {
        bottomDrawerButton.click();
        bottomDrawerButton.drawer().is().displayed().and().has().position(Position.BOTTOM);
        bottomDrawerButton.drawer().close();
        bottomDrawerButton.drawer().is().notExist();
    }
}
