package io.github.epam.material.tests.navigation;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.simpleBreadcrumbsPage;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.breadcrumbsWithIcons;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.collapsedBreadcrumbs;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.customSeparatorBreadcrumbsIcon;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.customSeparatorBreadcrumbsMinus;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.customSeparatorBreadcrumbsMore;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.customizedBreadcrumbs;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.simpleBreadcrumbs;
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
        jdiAssert(simpleBreadcrumbsPage.driver().getCurrentUrl(), endsWith("#materialUI"));

        simpleBreadcrumbs.get("Core").has().attr("href", endsWith("#core"));
        simpleBreadcrumbs.get("Core").click();
        jdiAssert(simpleBreadcrumbsPage.driver().getCurrentUrl(), endsWith("#core"));

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
        // TODO: Add expand method
        collapsedBreadcrumbs.find(".MuiButtonBase-root").click();
        collapsedBreadcrumbs.has().values("Home", "Catalog", "Accessories", "New Collection", "Belts");
    }

    @Test
    public void customizedBreadcrumbsTest() {
        customizedBreadcrumbs.has().values("Home", "Catalog", "Accessories");
        customizedBreadcrumbs.get("Home").click();
        jdiAssert(simpleBreadcrumbsPage.driver().getCurrentUrl(), endsWith("#materialUI"));
        customizedBreadcrumbs.get("Catalog").click();
        jdiAssert(simpleBreadcrumbsPage.driver().getCurrentUrl(), endsWith("#catalog"));
        customizedBreadcrumbs.get("Accessories").click();
        jdiAssert(simpleBreadcrumbsPage.driver().getCurrentUrl(), endsWith("#catalog"));
    }
}
