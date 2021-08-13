package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.routerBreadcrumbsPage;
import static io.github.com.pages.navigation.RouterBreadcrumbsPage.*;

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
        routerBreadcrumbsPage.open();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Inbox");
        trashDisplayBlock.click();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Trash");
    }

    @Test
    public void routerIntegrationBreadcrumbsIconClickTest() {
        routerBreadcrumbsPage.open();
        importantDisplayBlock.click();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Inbox");
        breadcrumbs.get(3).is().text("Important");
        inboxDisplayBlock.click();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Inbox");
        importantDisplayBlock.is().hidden();
    }
}
