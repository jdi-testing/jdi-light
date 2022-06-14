package io.github.epam.material.tests.navigation.drawer;

import io.github.com.custom.elements.MUIContainerListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.clippedDrawerPage;
import static io.github.com.pages.navigation.ClippedDrawerPage.clippedDrawer;
import static com.epam.jdi.light.material.elements.utils.enums.Position.LEFT;


public class ClippedDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        clippedDrawerPage.open();
        clippedDrawerPage.shouldBeOpened();
    }

    @Test
    public void clippedDrawerTest() {
        clippedDrawer.is().displayed()
                .and().has().position(LEFT.toString())
                .and().has().numberOfListItems(7);
        clippedDrawer.topList().has().size(4);
        clippedDrawer.topList().items().get(1).has().text("Starred");
        clippedDrawer.topList().items().get(0).with(MUIContainerListItem.class).icon().is().displayed();
        clippedDrawer.bottomList().has().size(3);
        clippedDrawer.bottomList().items().get(2).has().text("Spam");
        clippedDrawer.bottomList().items().get(1).with(MUIContainerListItem.class).icon().is().displayed();
    }
}
