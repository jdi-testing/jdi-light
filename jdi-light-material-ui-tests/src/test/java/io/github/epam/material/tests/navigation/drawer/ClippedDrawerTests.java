package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.clippedDrawerPage;
import static io.github.com.pages.navigation.ClippedDrawerPage.clippedDrawer;

public class ClippedDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        clippedDrawerPage.open();
        clippedDrawerPage.shouldBeOpened();
    }

    @Test
    public void clippedDrawerTest() {
        clippedDrawer.is().displayed()
                .and().has().position(Position.LEFT)
                .and().has().numberOfListItems(7);
        clippedDrawer.topList().has().size(4);
        clippedDrawer.topList().items().get(1).has().text("Starred");
        clippedDrawer.topList().items().get(0).icon().is().displayed();
        clippedDrawer.bottomList().has().size(3);
        clippedDrawer.bottomList().items().get(2).has().text("Spam");
        clippedDrawer.bottomList().items().get(1).icon().is().displayed();
    }
}
