package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SideNavSection.basicDrawer;
import static io.github.com.pages.sections.SideNavSection.implicitMainContent;
import static io.github.com.pages.sections.SideNavSection.openCloseBehavior;
import static io.github.com.pages.sections.SideNavSection.responsiveContent;
import static io.github.com.pages.sections.SideNavSection.sideNavToggle;
import static io.github.com.pages.sections.SideNavSection.toolbarToggle;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class SideNavUnitTests extends TestsInit {

    @BeforeMethod(alwaysRun = true)
    public void before() {
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

    @Test
    public void getEventsTest() {
        sideNavToggle.click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        assertEquals(openCloseBehavior.getEvents().getText(), "open!");
    }

    @Test
    public void getSideNavLinksTest() {
        sideNavToggle.click();
        assertEquals(responsiveContent.getSideNavLinks().get(1).getText(), "Nav Item 1");
    }

    @Test
    public void getResponsiveResultsTest() {
        toolbarToggle.click();
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
