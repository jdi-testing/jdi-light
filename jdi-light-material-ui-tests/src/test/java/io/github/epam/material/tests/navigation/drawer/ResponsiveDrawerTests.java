package io.github.epam.material.tests.navigation.drawer;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.responsiveDrawerPage;
import static io.github.com.pages.navigation.ResponsiveDrawerPage.responsiveDrawer;

public class ResponsiveDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        responsiveDrawerPage.open();
        responsiveDrawerPage.shouldBeOpened();
    }

    @Test
    public void responsiveDrawerTest() {
        responsiveDrawer.is().displayed();
        responsiveDrawer.has().position("left");
        responsiveDrawer.has().numberOfListItems(7);
        responsiveDrawer.topList().has().size(4);
        responsiveDrawer.topList().items().get(3).has().text("Drafts");
        responsiveDrawer.topList().items().get(2).icon().is().displayed();
        responsiveDrawer.bottomList().has().size(3);
        responsiveDrawer.bottomList().items().get(1).has().text("Trash");
        responsiveDrawer.bottomList().items().get(0).icon().is().displayed();
        responsiveDrawer.has().width(240);
    }
}
