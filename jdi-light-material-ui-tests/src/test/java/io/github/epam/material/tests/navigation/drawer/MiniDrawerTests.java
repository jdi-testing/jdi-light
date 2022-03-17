package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.material.elements.utils.enums.Position;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.miniDrawerPage;
import static io.github.com.pages.navigation.MiniDrawerPage.appBar;
import static io.github.com.pages.navigation.MiniDrawerPage.miniDrawer;

public class MiniDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        miniDrawerPage.open();
        miniDrawerPage.shouldBeOpened();
    }

    @Test
    public void miniDrawerTest() {
        miniDrawer.is().displayed();
        miniDrawer.has().position(Position.LEFT);
        miniDrawer.has().numberOfListItems(7);
        miniDrawer.topList().has().size(4);
        miniDrawer.topList().items().get(0).has().text("Inbox");
        miniDrawer.topList().items().get(1).icon().is().displayed();
        miniDrawer.bottomList().has().size(3);
        miniDrawer.bottomList().items().get(0).has().text("All mail");
        miniDrawer.bottomList().items().get(2).icon().is().displayed();
        miniDrawer.has().css("width", "73px");
        appBar.getOverflowMenuButton().click();
    }
}
