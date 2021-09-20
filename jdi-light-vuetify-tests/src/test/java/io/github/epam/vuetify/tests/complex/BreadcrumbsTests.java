package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.breadcrumbsPage;
import static io.github.com.pages.BreadcrumbsPage.dashedBreadcrumbs;

public class BreadcrumbsTests extends TestsInit {
    @BeforeClass
    public void before() {
        breadcrumbsPage.open();
        breadcrumbsPage.checkOpened();
    }

    @Test
    public void dividersTypeTest() {
        dashedBreadcrumbs.dividers().has().size(2);
    }
}
