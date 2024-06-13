package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.material.elements.inputs.MUIButton;
import io.github.com.custom.elements.CustomSiteListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.miniDrawerPage;
import static io.github.com.pages.navigation.MiniDrawerPage.appBar;
import static io.github.com.pages.navigation.MiniDrawerPage.miniDrawer;
import static com.epam.jdi.light.material.elements.utils.enums.Position.LEFT;

public class MiniDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        miniDrawerPage.open();
        miniDrawerPage.shouldBeOpened();
    }

    // @todo #5341 Enable test after Appbar fix, exception in execution now
    @Test(enabled = false)
    public void miniDrawerTest() {
        miniDrawer.is().displayed()
                .and().has().position(LEFT.toString())
                .and().has().totalSize(7);
        miniDrawer.topList().has().size(4);
        miniDrawer.topList().items().get(0).has().text("Inbox");
        miniDrawer.topList().items().get(1).with(CustomSiteListItem.class).icon().is().displayed();
        miniDrawer.bottomList().has().size(3);
        miniDrawer.bottomList().items().get(0).has().text("All mail");
        miniDrawer.bottomList().items().get(2).with(CustomSiteListItem.class).icon().is().displayed();
        miniDrawer.has().css("width", "73px");
        ((MUIButton)appBar.buttonGroup().item(0)).click();
        waitCondition(() -> miniDrawer.css("width").equals("240px"));
        miniDrawer.has().css("width", "240px");
    }
}
