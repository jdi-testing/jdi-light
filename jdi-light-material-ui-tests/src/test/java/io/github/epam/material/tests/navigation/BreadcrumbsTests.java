package io.github.epam.material.tests.navigation;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.Test;
import static io.github.com.StaticSite.simpleBreadcrumbsPage;
import static io.github.com.StaticSite.routerIntegrationBreadcrumbsPage;
import static org.testng.Assert.assertTrue;
import static io.github.com.pages.navigation.BreadcrumbsPage.*;


public class BreadcrumbsTests extends TestsInit {

    private static Timer timer = new Timer(3000L);

    @Test
    public void simpleBreadcrumbsTest() {
        simpleBreadcrumbsPage.open();
        breadcrumbs.get(1).is().text("Material-UI");
        breadcrumbs.get(1).click();
        timer.wait(() -> materialElement.is().visible());
        breadcrumbs.get(2).is().text("Core");
        breadcrumbs.get(2).click();
        timer.wait(() -> materialElement.is().notVisible());
        timer.wait(()->coreElement.is().visible());
    }

    @Test
    public void customSeparatorBreadcrumbsTest() {
        simpleBreadcrumbsPage.open();
        separators.get(5).is().text("›");
        separators.get(7).is().text("-");
    }

    @Test
    public void withIconsBreadcrumbsTest() {
        simpleBreadcrumbsPage.open();
        icons.get(1).is().displayed();
        icons.get(2).is().displayed();
        icons.get(3).is().displayed();
    }

    @Test
    public void collapsedBreadcrumbsTest() {
        simpleBreadcrumbsPage.open();
        breadcrumbs.get(16).is().displayed();
        breadcrumbs.get(16).is().text("Home");
        breadcrumbs.get(17).is().text("Belts");
        collapsedButton.is().displayed();
        collapsedButton.click();
        breadcrumbs.get(17).is().text("Catalog");
        collapsedButton.is().notVisible();
    }

    @Test
    public void customizedBreadcrumbsTest() {
        simpleBreadcrumbsPage.open();
        breadcrumbs.get(18).is().text("Home");
        breadcrumbs.get(18).click();
        breadcrumbs.get(19).is().text("Catalog");
        breadcrumbs.get(19).click();
        breadcrumbs.get(20).is().text("Accessories");
        breadcrumbs.get(20).click();
    }

    @Test
    public void routerIntegrationBreadcrumbsTest() {
        routerIntegrationBreadcrumbsPage.open();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Inbox");
        trashDisplayBlock.click();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Trash");
    }

    @Test
    public void routerIntegrationBreadcrumbsIconClickTest() {
        routerIntegrationBreadcrumbsPage.open();
        importantDisplayBlock.click();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Inbox");
        breadcrumbs.get(3).is().text("Important");
        inboxDisplayBlock.click();
        breadcrumbs.get(1).is().text("Home");
        breadcrumbs.get(2).is().text("Inbox");
        assertTrue(importantDisplayBlock.isHidden());
    }
}
