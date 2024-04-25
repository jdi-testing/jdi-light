package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.com.custom.elements.CustomSiteListItem;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static io.github.com.StaticSite.responsiveDrawerPage;
import static io.github.com.pages.navigation.ResponsiveDrawerPage.responsiveDrawer;
import static com.epam.jdi.light.material.elements.utils.enums.Position.LEFT;

public class ResponsiveDrawerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        responsiveDrawerPage.open();
        responsiveDrawerPage.shouldBeOpened();
    }

    @Test
    public void responsiveDrawerTest() {
        responsiveDrawer.is().displayed()
                .and().has().position(LEFT.toString())
                .and().has().totalSize(7);
        responsiveDrawer.topList().has().size(4);
        responsiveDrawer.topList().items().get(3).has().text("Drafts");
        responsiveDrawer.topList().items().get(2).with(CustomSiteListItem.class).icon().is().displayed();
        responsiveDrawer.bottomList().has().size(3);
        List<UIElement> items = responsiveDrawer.bottomList().items();
        items.get(1).has().text("Trash");
        items.get(0).with(CustomSiteListItem.class).icon().is().displayed();
    }
}
