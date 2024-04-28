package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.material.elements.displaydata.list.SimpleList;
import io.github.com.custom.elements.CustomSiteListItem;
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
                .and().has().totalSize(7);
        SimpleList testList = clippedDrawer.list(1);
        testList.has().size(4);
        testList.items().get(1).has().text("Starred");
        testList.items().get(0).with(CustomSiteListItem.class).icon().is().displayed();

        testList.has().itemsWithTexts("Inbox", "Starred", "Send email", "Drafts");
    }
}
