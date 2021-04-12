package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.simpleBreadcrumbsPage;
import static io.github.com.StaticSite.routerIntegrationBreadcrumbsPage;
import static org.testng.Assert.assertTrue;
import static io.github.com.pages.navigation.BreadcrumbsPage.*;


public class BreadcrumbsTests extends TestsInit {
    @Test
    public void simpleBreadcrumbsTest(){
        simpleBreadcrumbsPage.open();

       simpleBreadcrumb.getBreadcrumbByIndex(1).is().text("Material-UI");
       simpleBreadcrumb.getBreadcrumbByIndex(1).click();
       simpleBreadcrumb.getBreadcrumbByIndex(2).is().text("Core");
       simpleBreadcrumb.getBreadcrumbByIndex(2).click();
       simpleBreadcrumb.getBreadcrumbByIndex(3).is().text("Breadcrumb");
       simpleBreadcrumb.getBreadcrumbByIndex(3).click();
    }

    @Test
    public void customSeparatorBreadcrumbsTest(){
        simpleBreadcrumbsPage.open();

        simpleBreadcrumb.getSeparatorByIndex(5).is().text("›");
        simpleBreadcrumb.getSeparatorByIndex(7).is().text("-");
    }

    @Test
    public void withIconsBreadcrumbsTest() {
        simpleBreadcrumbsPage.open();

        simpleBreadcrumb.getIconByIndex(1).is().displayed();
        simpleBreadcrumb.getIconByIndex(2).is().displayed();
        simpleBreadcrumb.getIconByIndex(3).is().displayed();
    }

    @Test
    public void collapsedBreadcrumbsTest(){
        simpleBreadcrumbsPage.open();

        simpleBreadcrumb.getBreadcrumbByIndex(16).is().displayed();
        simpleBreadcrumb.getBreadcrumbByIndex(16).is().text("Home");
        simpleBreadcrumb.getBreadcrumbByIndex(17).is().text("Belts");

        collapsedButton.is().displayed();
        collapsedButton.click();

        simpleBreadcrumb.getBreadcrumbByIndex(17).is().text("Catalog");

        collapsedButton.is().notVisible();
    }

    @Test
    public void customizedBreadcrumbsTest(){
        simpleBreadcrumbsPage.open();

        simpleBreadcrumb.getBreadcrumbByIndex(18).is().text("Home");
        simpleBreadcrumb.getBreadcrumbByIndex(18).click();
        simpleBreadcrumb.getBreadcrumbByIndex(19).is().text("Catalog");
        simpleBreadcrumb.getBreadcrumbByIndex(19).click();
        simpleBreadcrumb.getBreadcrumbByIndex(20).is().text("Accessories");
        simpleBreadcrumb.getBreadcrumbByIndex(20).click();
    }

    @Test
    public void routerIntegrationBreadcrumbsTest(){
        routerIntegrationBreadcrumbsPage.open();

        routerBreadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        routerBreadcrumb.getBreadcrumbByIndex(2).is().text("Inbox");

        routerBreadcrumb.getButtonByText("Trash").click();
        routerBreadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        routerBreadcrumb.getBreadcrumbByIndex(2).is().text("Trash");
    }

    @Test
    public void routerIntegrationBreadcrumbsIconClickTest() {
        routerIntegrationBreadcrumbsPage.open();

        routerBreadcrumb.getButtonByText("Important").click();
        routerBreadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        routerBreadcrumb.getBreadcrumbByIndex(2).is().text("Inbox");
        routerBreadcrumb.getBreadcrumbByIndex(3).is().text("Important");

        routerBreadcrumb.getButtonByText("Inbox").click();
        routerBreadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        routerBreadcrumb.getBreadcrumbByIndex(2).is().text("Inbox");
        assertTrue(breadcrumbsSectionImportant.isHidden());
    }

}
