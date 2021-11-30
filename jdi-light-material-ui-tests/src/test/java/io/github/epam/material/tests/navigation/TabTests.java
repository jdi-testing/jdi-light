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
        simpleTabs.select(2);
        simpleTabs.has().elementSelected(2);
        simpleTabs.has().elementNotSelected(3);
        simpleTabs.has().elementDisabled(4);

        jdiAssert(simpleTabs.size(), Matchers.is(5));
    }

    @Test
    public void scrollableTabTest() {
        scrollableTabs.select(1);
        scrollableTabs.has().elementSelected(1);
        scrollableTabs.has().elementEnabled(1);

        scrollableTabs.select(7);
        scrollableTabs.has().elementSelected(7);
        scrollableTabs.has().elementEnabled(7);

        scrollableTabs.select(11);
        scrollableTabs.has().elementSelected(11);
        scrollableTabs.has().elementEnabled(11);

        scrollableTabs.select(1);
        scrollableTabs.has().elementSelected(1);
        scrollableTabs.has().elementEnabled(1);

        jdiAssert(scrollableTabs.size(), Matchers.is(11));
    }

    @Test
    public void preventScrollTest() {
        preventScrollTabs.select(1);
        preventScrollTabs.has().elementSelected(1);
        preventScrollTabs.has().elementEnabled(1);

        preventScrollTabs.select(7);
        preventScrollTabs.has().elementSelected(7);
        preventScrollTabs.has().elementEnabled(7);

        jdiAssert(preventScrollTabs.size(), Matchers.is(7));
    }

    @Test
    public void verticalTabTest() {
        verticalTabs.select(1);
        verticalTabs.has().elementSelected(1);
        verticalTabs.has().elementEnabled(1);

        verticalTabs.select(7);
        verticalTabs.has().elementSelected(7);
        verticalTabs.has().elementEnabled(7);

        jdiAssert(verticalTabs.size(), Matchers.is(7));
    }
}
