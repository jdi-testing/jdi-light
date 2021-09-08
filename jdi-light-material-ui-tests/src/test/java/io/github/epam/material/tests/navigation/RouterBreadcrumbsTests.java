package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.routerBreadcrumbsPage;
import static io.github.com.pages.navigation.RouterBreadcrumbsPage.importantDisplayBlock;
import static io.github.com.pages.navigation.RouterBreadcrumbsPage.inboxDisplayBlock;
import static io.github.com.pages.navigation.RouterBreadcrumbsPage.routerBreadcrumbs;
import static io.github.com.pages.navigation.RouterBreadcrumbsPage.trashDisplayBlock;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://material-ui.com/components/breadcrumbs/
 */

public class RouterBreadcrumbsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        routerBreadcrumbsPage.open();
        routerBreadcrumbsPage.isOpened();
    }

    @Test
    public void routerIntegrationBreadcrumbsTest() {
        routerBreadcrumbs.list().get(1).is().text("Home");
        routerBreadcrumbs.list().get(2).is().text("Inbox");
        trashDisplayBlock.core().click();
        routerBreadcrumbs.list().get(1).is().text("Home");
        routerBreadcrumbs.list().get(2).is().text("Trash");
    }

    @Test
    public void routerIntegrationBreadcrumbsIconClickTest() {
        routerBreadcrumbsPage.open();
        importantDisplayBlock.core().click();
        routerBreadcrumbs.get(1).is().text("Home");
        routerBreadcrumbs.get(2).is().text("Inbox");
        routerBreadcrumbs.get(3).is().text("Important");
        inboxDisplayBlock.core().click();
        routerBreadcrumbs.get(1).is().text("Home");
        routerBreadcrumbs.get(2).is().text("Inbox");
        importantDisplayBlock.is().hidden();
    }
}
