package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
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

    public static final String SIDE_NAV_CLASS = "mat-drawer-container mat-sidenav-container example-container";
    public static final String STYLE = "style";
    public static final String STYLE_VISIBLE = "transform: none; visibility: visible;";
    public static final String STYLE_HIDDEN = "box-shadow: none; visibility: hidden;";
    public static final String SIDE_NAV_CONTENT = "Sidenav content";
    public static final String MODE = "mode";
    public static final String SIDE = "side";

    @Test
    public void verifyBasicSideNavTest() {
        basicSideNav.has().classValue(SIDE_NAV_CLASS);
        basicSideNav.getSideNav().has().attr(MODE, SIDE);
        basicSideNav.getSideNav().has().text(SIDE_NAV_CONTENT);
        basicSideNav.getSideNav().has().attr(STYLE, STYLE_VISIBLE);

        basicSideNav.getContent().is().displayed();
        basicSideNav.getContent().is().enabled();
        basicSideNav.getContent().has().text("Main content");
    }

    @Test
    public void verifyImplicitMainContentWithTwoSideNavTest() {
        implicitMainContent.has().classValue(SIDE_NAV_CLASS);
        UIElement startSideNav = implicitMainContent.getSideNav("start");
        UIElement endSideNav = implicitMainContent.getSideNav("end");
        startSideNav.has().attr(MODE, SIDE);
        startSideNav.has().attr(STYLE, STYLE_VISIBLE);
        startSideNav.has().text("Start content");
        endSideNav.has().attr(MODE, SIDE);
        endSideNav.has().attr(STYLE, STYLE_VISIBLE);
        endSideNav.has().text("End content");

        implicitMainContent.getContent().has().text("Implicit main content");
        implicitMainContent.getContent().is().displayed();
        implicitMainContent.getContent().is().enabled();
    }

    @Test
    public void verifyOpenCloseBehaviorTest() {
        refresh();
        openCloseBehavior.has().classValue(SIDE_NAV_CLASS);
        openCloseBehavior.toggleButton().click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        openCloseBehavior.getSideNav().has().attr(STYLE, STYLE_VISIBLE);
        openCloseBehavior.getSideNav().has().text(SIDE_NAV_CONTENT);

        openCloseBehavior.checkbox().click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        openCloseBehavior.getSideNav().has().attr(STYLE, STYLE_HIDDEN);
        openCloseBehavior.getContent().is().displayed();
        openCloseBehavior.getContent().is().enabled();
    }

    @Test
    public void toggleButtonTest() {
        refresh();
        configurableMode.has().classValue(SIDE_NAV_CLASS);
        configurableMode.getSideNav().has().attr(STYLE, STYLE_HIDDEN);
        configurableMode.getContentToggleButton().click();
        configurableMode.base().timer().wait(() -> configurableMode.isEnabled());
        configurableMode.getSideNav().has().attr(STYLE, STYLE_VISIBLE);
        configurableMode.getSideNavToggleButton().click();

    }

    @Test
    public void sideRadioGroupTest() {
        refresh();
        configurableMode.getContentToggleButton().click();
        configurableMode.getContent().has().attr(STYLE, "");
        configurableMode.sideNavRadioButtons().get("Side").click();
        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px;");
        configurableMode.sideNavRadioButtons().get("Push").click();
        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px; margin-right: -258px;");
    }

    @Test
    public void contentRadioButtonsTest() {
        refresh();
        configurableMode.getContentToggleButton().click();
        configurableMode.sideNavRadioButtons().get("Side").click();
        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px;");
        configurableMode.getContentRadioButtons().get("Push").click();
        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px; margin-right: -258px;");
    }
}
