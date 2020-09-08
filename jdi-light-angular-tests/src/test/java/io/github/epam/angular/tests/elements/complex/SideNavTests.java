package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SideNavSection.basicSideNav;
import static io.github.com.pages.sections.SideNavSection.configurableMode;
import static io.github.com.pages.sections.SideNavSection.customEscapeBackdrop;
import static io.github.com.pages.sections.SideNavSection.implicitMainContent;
import static io.github.com.pages.sections.SideNavSection.openCloseBehavior;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SideNavTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    public static final String SIDE_NAV_CONTENT = "Sidenav content";

    public static final String STYLE = "style";
    public static final String STYLE_VISIBLE = "transform: none; visibility: visible;";
    public static final String STYLE_HIDDEN = "box-shadow: none; visibility: hidden;";
    public static final String MODE = "mode";
    public static final String SIDE = "side";

    @Test
    public void verifyBasicSideNavTest() {
        basicSideNav.is().displayed();
        basicSideNav.is().enabled();
        basicSideNav.is().navVisible();
        basicSideNav.is().navText(SIDE_NAV_CONTENT);
        basicSideNav.is().contentText("Main content");
    }

    @Test
    public void verifyImplicitMainContentWithTwoSideNavTest() {
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
        openCloseBehavior.getContent().is().displayed();
        openCloseBehavior.getContent().is().enabled();
        openCloseBehavior.getContentToggleButton().click();
        openCloseBehavior.getSideNav().has().text(SIDE_NAV_CONTENT);
        openCloseBehavior.checkbox().click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        openCloseBehavior.getContent().has().text("sidenav.opened\nsidenav.toggle()\nEvents:\nopen!\nclose!");

    }

//    @Test
//    public void toggleButtonTest() throws InterruptedException {
//        refresh();
//        configurableMode.clickContentToggleButton();
//        configurableMode.show();
//        Assert.assertTrue(configurableMode.isNavToggled());
//        configurableMode.base().timer().wait(() -> configurableMode.visualValidation(".mat-sidenav"));
//        configurableMode.getSideNav().has().attr(STYLE, STYLE_VISIBLE);
//        configurableMode.clickNavToggleButton();
//        configurableMode.base().timer().wait(() -> configurableMode.visualValidation(".mat-sidenav"));
//        configurableMode.getSideNav().has().attr(STYLE, STYLE_HIDDEN);
//    }
//
//    @Test
//    public void sideRadioGroupTest() {
//        refresh();
//        configurableMode.getContentToggleButton().click();
//        configurableMode.getContent().has().attr(STYLE, "");
//        configurableMode.clickNavRadioButton("Side");
//        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px;");
//        configurableMode.clickNavRadioButton("Push");
//        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px; margin-right: -258px;");
//    }
//
//    @Test
//    public void contentRadioButtonsTest() {
//        configurableMode.getContentToggleButton().click();
//        configurableMode.clickNavRadioButton("Side");
//        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px;");
//        configurableMode.clickContentRadioButton("Push");
//        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px; margin-right: -258px;");
//    }
//
//    @Test
//    public void openToggleBehaviorTest() {
//        customEscapeBackdrop.getContentToggleButton().click();
//        customEscapeBackdrop.getNavToggleButton().click();
//        customEscapeBackdrop.getContent().has().text("Open\nClosed due to: toggle button");
//    }
//
//    @Test
//    public void toggleBackdropBehaviorTest() {
//        customEscapeBackdrop.getContentToggleButton().click();
//        customEscapeBackdrop.core().click();
//        customEscapeBackdrop.getContent().has().text("Open\nClosed due to: backdrop");
//    }

}
