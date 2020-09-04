package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SideNavSection.basicSideNav;
import static io.github.com.pages.sections.SideNavSection.configurableMode;
import static io.github.com.pages.sections.SideNavSection.implicitMainContent;
import static io.github.com.pages.sections.SideNavSection.openCloseBehavior;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SideNavTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    private static final String SIDE_NAV_CLASS = "mat-drawer-container mat-sidenav-container example-container";

    @Test
    public void verifyBasicSideNavTest() {
        basicSideNav.has().classValue(SIDE_NAV_CLASS);
        basicSideNav.getSideNav().has().attr("mode", "side");
        basicSideNav.getSideNav().has().text("Sidenav content");
        basicSideNav.getSideNav().has().attr("style", "transform: none; visibility: visible;");

        basicSideNav.getContent().is().displayed();
        basicSideNav.getContent().is().enabled();
        basicSideNav.getContent().has().text("Main content");
    }

    @Test
    public void verifyImplicitMainContentWithTwoSideNavTest() {
        implicitMainContent.has().classValue(SIDE_NAV_CLASS);
        UIElement startSideNav = implicitMainContent.getSideNav("start");
        UIElement endSideNav = implicitMainContent.getSideNav("end");
        startSideNav.has().attr("mode", "side");
        startSideNav.has().attr("style", "transform: none; visibility: visible;");
        startSideNav.has().text("Start content");
        endSideNav.has().attr("mode", "side");
        endSideNav.has().attr("style", "transform: none; visibility: visible;");
        endSideNav.has().text("End content");

        implicitMainContent.getContent().has().text("Implicit main content");
        implicitMainContent.getContent().is().displayed();
        implicitMainContent.getContent().is().enabled();
    }


    @Test
    public void verifyOpenCloseBehaviorTest() {
        openCloseBehavior.has().classValue(SIDE_NAV_CLASS);
        openCloseBehavior.toggleButton().click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        openCloseBehavior.getSideNav().has().attr("style", "transform: none; visibility: visible;");
        openCloseBehavior.getSideNav().has().text("Sidenav content");

        openCloseBehavior.checkbox().click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        openCloseBehavior.getSideNav().has().attr("style", "box-shadow: none; visibility: hidden;");
        openCloseBehavior.openCloseEvents().has().values("open!\nclose!");

        openCloseBehavior.getContent().is().displayed();
        openCloseBehavior.getContent().is().enabled();
    }

    @Test
    public void verifyTest() {
        configurableMode.has().classValue(SIDE_NAV_CLASS);


        configurableMode.getContent().is().displayed();
        configurableMode.getContent().is().enabled();
    }
}
