package io.github.epam.material.tests.navigation.drawer;

import io.github.com.custom.elements.CustomSiteListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.material.elements.utils.enums.Position.LEFT;
import static io.github.com.StaticSite.permanentDrawerPage;
import static io.github.com.pages.navigation.PermanentDrawerPage.permanentDrawer;

public class PermanentDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        permanentDrawerPage.open();
        permanentDrawerPage.shouldBeOpened();
    }

    @Test
    public void permanentDrawerTest() {
        permanentDrawer.is().displayed()
                .and().has().position(LEFT.toString())
                .and().has().totalSize(7);
        permanentDrawer.topList().has().size(4);
        permanentDrawer.topList().items().get(2).has().text("Send email");
        permanentDrawer.topList().items().get(3).with(CustomSiteListItem.class).icon().is().displayed();
        permanentDrawer.bottomList().has().size(3);
        permanentDrawer.bottomList().items().get(1).has().text("Trash");
    }
}
