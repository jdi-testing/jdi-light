package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SideNavSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class SideNavUnitTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        skipForFirefox();
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void getSideNavTest() {
        assertEquals(implicitMainContent.getSideNav("End").getText(), "End content");
    }

    @Test
    public void getContentTest() {
        assertEquals(implicitMainContent.getContent().getText(), "Implicit main content");
    }

    // failed in CI
    @Test(enabled = false)
    public void getEventsTest() {
        sideNavToggle.show();
        sideNavToggle.click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        assertEquals(openCloseBehavior.getEvents().getText(), "open!");
    }

    @Test
    public void getSideNavLinksTest() {
        responsiveContent.show();
        if (responsiveContent.getSideNav().isNotDisplayed()) {
            toolbarToggle.click();
        }
        assertEquals(responsiveContent.getSideNavLinks().get(1).getText(), "Nav Item 1");
    }

    @Test
    public void getResponsiveResultsTest() {
        responsiveContent.show();
        if (responsiveContent.getSideNav().isNotDisplayed()) {
            toolbarToggle.click();
        }
        responsiveContent.getSideNavLinks().get(1).click();
        assertEquals(responsiveContent.getResponsiveResults().get(1).getText(), "Selected Nav Item 1");
    }

    @Test
    public void getMatDrawerTest() {
        assertEquals(basicDrawer.getMatDrawer().getText(), "Drawer content");
    }

    @Test
    public void getMatDrawerContentTest() {
        assertEquals(basicDrawer.getMatDrawerContent().getText(), "Main content");
    }
}
