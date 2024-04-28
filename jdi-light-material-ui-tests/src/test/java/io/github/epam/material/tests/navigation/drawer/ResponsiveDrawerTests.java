package io.github.epam.material.tests.navigation.drawer;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.elements.displaydata.list.SimpleList;
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
        SimpleList topList = responsiveDrawer.list(1);
        topList.has().size(4);
        topList.items().get(3).has().text("Drafts");
        topList.items().get(2).with(CustomSiteListItem.class).icon().is().displayed();
    }
}
