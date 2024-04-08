package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.material.elements.inputs.MUIButton;
import io.github.com.custom.elements.CustomSiteListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.persistentDrawerPage;
import static io.github.com.pages.navigation.PersistentDrawerPage.appBar;
import static io.github.com.pages.navigation.PersistentDrawerPage.persistentDrawer;
import static com.epam.jdi.light.material.elements.utils.enums.Position.LEFT;

public class PersistentDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        persistentDrawerPage.open();
        persistentDrawerPage.shouldBeOpened();
    }

    // @todo #5341 Enable test after AppBar fix, IndexOutOfBoundary now on 2nd line
    @Test(enabled = false)
    public void persistentDrawerTest() {
        persistentDrawer.is().hidden();
        ((MUIButton)appBar.buttonGroup().item(0)).click();
        persistentDrawer.is().displayed()
                .and().has().position(LEFT.toString())
                .and().has().totalSize(7);
        persistentDrawer.topList().has().size(4);
        persistentDrawer.topList().items().get(3).has().text("Drafts");
        persistentDrawer.topList().items().get(2).with(CustomSiteListItem.class).icon().is().displayed();
        persistentDrawer.bottomList().has().size(3);
        persistentDrawer.close();
        persistentDrawer.is().hidden();
    }
}
