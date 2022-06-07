package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.simpleBreadcrumbsPage;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.endsWith;

public class SimpleBreadcrumbsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        simpleBreadcrumbsPage.open();
        simpleBreadcrumbsPage.checkOpened();
    }

    @Test
    public void simpleBreadcrumbsTest() {
        simpleBreadcrumbs.has().values("Material-UI", "Core", "Breadcrumb");

        simpleBreadcrumbs.get("Material-UI").has().attr("href", containsString("#materialUI"));
        simpleBreadcrumbs.get("Material-UI").click();
        simpleBreadcrumbs.has().currentUrl(endsWith("#materialUI"));

        simpleBreadcrumbs.get("Core").has().attr("href", endsWith("#core"));
        simpleBreadcrumbs.get("Core").click();
        simpleBreadcrumbs.has().currentUrl(endsWith("#core"));

        simpleBreadcrumbs.separators().foreach(separator -> separator.has().text("/"));
    }

    @Test
    public void withIconsBreadcrumbsTest() {
        breadcrumbsWithIcons.list().foreach(item -> item.find(".MuiSvgIcon-root").is().displayed());
    }

    @Test
    public void customSeparatorBreadcrumbsTest() {
        customSeparatorBreadcrumbsMore.separators().foreach(separator -> separator.has().text("›"));
        customSeparatorBreadcrumbsMinus.separators().foreach(separator -> separator.has().text("-"));
        customSeparatorBreadcrumbsIcon.separators().foreach(separator ->
                separator.has().classValue(containsString("MuiSvgIcon-fontSizeSmall"))
        );
    }

    @Test
    public void collapsedBreadcrumbsTest() {
        collapsedBreadcrumbs.has().values("Home", "Belts");
        collapsedBreadcrumbs.expand();
        collapsedBreadcrumbs.has().values("Home", "Catalog", "Accessories", "New Collection", "Belts");
    }

    @Test
    public void customizedBreadcrumbsTest() {
        customizedBreadcrumbs.has().values("Home", "Catalog", "Accessories");

        customizedBreadcrumbs.get("Home").click();
        customizedBreadcrumbs.has().currentUrl(endsWith("#materialUI"));

        customizedBreadcrumbs.get("Catalog").click();
        customizedBreadcrumbs.has().currentUrl(endsWith("#catalog"));

        customizedBreadcrumbs.get("Accessories").click();
        customizedBreadcrumbs.has().currentUrl(endsWith("#catalog"));
    }
}
