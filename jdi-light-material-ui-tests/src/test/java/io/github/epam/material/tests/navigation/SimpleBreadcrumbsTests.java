package io.github.epam.material.tests.navigation;

import com.jdiai.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.simpleBreadcrumbsPage;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.breadcrumbsWithIcons;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.collapsedBreadcrumbs;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.collapsedButton;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.coreElement;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.customSeparatorBreadcrumbs;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.customizedBreadcrumbs;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.materialElement;
import static io.github.com.pages.navigation.SimpleBreadcrumbsPage.simpleBreadcrumbs;

/**
 * To see an example of a Breadcrumbs web element, please visit
 * https://material-ui.com/components/breadcrumbs/
 */

public class SimpleBreadcrumbsTests extends TestsInit {
    private static Timer timer = new Timer(3000L);

    @BeforeMethod
    public void before() {
        simpleBreadcrumbsPage.open();
        simpleBreadcrumbsPage.isOpened();
    }

    @Test
    public void simpleBreadcrumbsTest() {
        simpleBreadcrumbs.get(1).is().text("Material-UI");
        simpleBreadcrumbs.get(1).click();
        timer.wait(() -> materialElement.is().visible());
        simpleBreadcrumbs.get(2).is().text("Core");
        simpleBreadcrumbs.get(2).click();
        timer.wait(() -> materialElement.is().notVisible());
        timer.wait(() -> coreElement.is().visible());
    }

    @Test
    public void customSeparatorBreadcrumbsTest() {
        customSeparatorBreadcrumbs.get(1).getSeparators().get(1).is().text("›");
        customSeparatorBreadcrumbs.get(2).getSeparators().get(1).is().text("-");
    }

    @Test
    public void withIconsBreadcrumbsTest() {
        breadcrumbsWithIcons.getIcons().get(1).is().displayed();
        breadcrumbsWithIcons.getIcons().get(2).is().displayed();
        breadcrumbsWithIcons.getIcons().get(3).is().displayed();
    }

    @Test
    public void collapsedBreadcrumbsTest() {
        collapsedBreadcrumbs.get(1).is().displayed();
        collapsedBreadcrumbs.get(1).is().text("Home");
        collapsedBreadcrumbs.get(2).is().text("Belts");
        collapsedButton.is().displayed();
        collapsedButton.click();
        collapsedBreadcrumbs.get(2).is().text("Catalog");
        collapsedButton.is().notVisible();
    }

    @Test
    public void customizedBreadcrumbsTest() {
        customizedBreadcrumbs.get(1).is().text("Home");
        customizedBreadcrumbs.get(1).click();
        customizedBreadcrumbs.get(2).is().text("Catalog");
        customizedBreadcrumbs.get(2).click();
        customizedBreadcrumbs.get(3).is().text("Accessories");
        customizedBreadcrumbs.get(3).click();
    }
}
