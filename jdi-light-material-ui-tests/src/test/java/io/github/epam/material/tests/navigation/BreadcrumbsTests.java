package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.breadcrumbsFrame;
import static io.github.com.StaticSite.simpleBreadcrumbsPage;
import static io.github.com.StaticSite.customizedBreadcrumbsPage;
import static io.github.com.StaticSite.customSeparatorBreadcrumbsPage;
import static io.github.com.StaticSite.withIconsBreadcrumbsPage;
import static io.github.com.StaticSite.collapsedBreadcrumbsPage;
import static io.github.com.StaticSite.routerIntegrationBreadcrumbsPage;

public class BreadcrumbsTests extends TestsInit {
    @Test
    public void simpleBreadcrumbsTest(){
        simpleBreadcrumbsPage.open();

        commonCheck();
    }

    @Test
    public void customSeparatorBreadcrumbsTest(){
        customSeparatorBreadcrumbsPage.open();

        commonCheck();

        breadcrumbsFrame.breadcrumb.getSeparatorByIndex(1).is().text("›");
        breadcrumbsFrame.breadcrumb.getSeparatorByIndex(2).is().text("›");
        breadcrumbsFrame.breadcrumb.getSeparatorByIndex(3).is().text("-");
        breadcrumbsFrame.breadcrumb.getSeparatorByIndex(4).is().text("-");
    }

    @Test
    public void withIconsBreadcrumbsTest(){
        withIconsBreadcrumbsPage.open();

        commonCheck();

        breadcrumbsFrame.breadcrumb.getIconByIndex(1).is().displayed();
        breadcrumbsFrame.breadcrumb.getIconByIndex(2).is().displayed();
        breadcrumbsFrame.breadcrumb.getIconByIndex(3).is().displayed();
    }

    @Test
    public void collapsedBreadcrumbsTest(){
        collapsedBreadcrumbsPage.open();

        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Belts");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).click();

        breadcrumbsFrame.collapsedButton.is().displayed();
        breadcrumbsFrame.collapsedButton.click();

        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Catalog");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).is().text("Accessories");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(4).is().text("New Collection");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(4).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(5).is().text("Belts");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(5).click();

        breadcrumbsFrame.collapsedButton.is().notVisible();
    }

    @Test
    public void routerIntegrationBreadcrumbsTest(){
        routerIntegrationBreadcrumbsPage.open();

        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Inbox");

        breadcrumbsFrame.breadcrumb.getButtonByText("Trash").click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Trash");
    }

    @Test
    public void routerIntegrationBreadcrumbsIconClickTest() {
        routerIntegrationBreadcrumbsPage.open();

        breadcrumbsFrame.breadcrumb.getButtonByText("Important").click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Inbox");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).is().text("Important");

        breadcrumbsFrame.breadcrumb.getIconByIndex(1).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Inbox");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).is().notVisible();
    }

    @Test
    public void customizedBreadcrumbsTest(){
        customizedBreadcrumbsPage.open();

        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Home");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Catalog");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).is().text("Accessories");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).click();
    }

    private void commonCheck(){
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).is().text("Material-UI");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(1).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).is().text("Core");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(2).click();
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).is().text("Breadcrumb");
        breadcrumbsFrame.breadcrumb.getBreadcrumbByIndex(3).click();
    }
}
