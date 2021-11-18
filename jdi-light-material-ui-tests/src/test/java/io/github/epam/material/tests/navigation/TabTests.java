package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.tabPage;
import static io.github.com.pages.navigation.TabPage.preventScrollTabs;
import static io.github.com.pages.navigation.TabPage.scrollableTabs;
import static io.github.com.pages.navigation.TabPage.simpleTabs;
import static io.github.com.pages.navigation.TabPage.verticalTabs;


/**
 * To see an example of Tab please visit
 * https://material-ui.com/components/tabs/
 */

public class TabTests extends TestsInit {

    @BeforeClass
    public void before() {
        tabPage.open();
        tabPage.checkOpened();
    }

    @Test
    public void simpleTabTest() {
        simpleTabs.get(1).click();
        simpleTabs.get(1).is().enabled();
        simpleTabs.get(1).is().selected(1);

        simpleTabs.get(2).click();

        simpleTabs.get(4).is().disabled();

        jdiAssert(simpleTabs.size(), Matchers.is(5));
    }

    @Test
    public void scrollableTabTest() {
        scrollableTabs.get(1).click();
        scrollableTabs.get(1).is().enabled();
        scrollableTabs.get(1).is().selected(1);

        scrollableTabs.get(7).click();
        scrollableTabs.get(7).is().enabled();

        scrollableTabs.get(11).click();
        scrollableTabs.get(11).is().enabled();

        scrollableTabs.get(1).click();
        scrollableTabs.get(1).is().enabled();

        jdiAssert(scrollableTabs.size(), Matchers.is(11));
    }

    @Test
    public void preventScrollTest() {
        preventScrollTabs.get(1).click();
        preventScrollTabs.get(1).is().enabled();
        preventScrollTabs.get(1).is().selected(1);

        preventScrollTabs.get(7).click();
        preventScrollTabs.get(7).is().enabled();

        jdiAssert(preventScrollTabs.size(), Matchers.is(7));
    }

    @Test
    public void verticalTabTest() {
        verticalTabs.get(1).click();
        verticalTabs.get(1).is().enabled();
        verticalTabs.get(1).is().selected(1);

        verticalTabs.get(7).click();
        verticalTabs.get(7).is().enabled();

        jdiAssert(verticalTabs.size(), Matchers.is(7));
    }
}
