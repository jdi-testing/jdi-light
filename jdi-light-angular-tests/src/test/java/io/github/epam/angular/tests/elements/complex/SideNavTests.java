package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SideNavSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;

public class SideNavTests extends TestsInit {

    public static final String SIDE_NAV_CONTENT = "Sidenav content";
    public static final String DRAWER_CONTENT = "Drawer content";
    public static final String MAIN_CONTENT = "Main content";
    public static final String STYLE = "style";
    public static final String STYLE_VISIBLE = "transform: none; visibility: visible;";
    public static final String STYLE_HIDDEN = "box-shadow: none; visibility: hidden;";
    public static final String MODE = "mode";
    public static final String SIDE = "side";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void verifyBasicSideNavTest() {
        basicSideNav.show();
        basicSideNav.is().displayed();
        basicSideNav.is().enabled();
        basicSideNav.getSideNav().has().text(SIDE_NAV_CONTENT);
        basicSideNav.getContent().has().text(MAIN_CONTENT);
    }

    @Test
    public void verifyBasicDrawerTest() {
        basicDrawer.show();
        basicDrawer.is().displayed();
        basicDrawer.is().enabled();
        basicDrawer.getMatDrawer().has().text(DRAWER_CONTENT);
        basicDrawer.getMatDrawerContent().has().text(MAIN_CONTENT);
    }

    @Test
    public void verifyImplicitMainContentWithTwoSideNavTest() {
        implicitMainContent.show();
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
        openCloseBehavior.show();
        openCloseBehavior.getContent().is().displayed();
        openCloseBehavior.getContent().is().enabled();

        sideNavToggle.click();
        openCloseBehavior.getSideNav().has().text(SIDE_NAV_CONTENT);

        sideNavOpened.click();
        openCloseBehavior.base().timer().wait(() -> openCloseBehavior.isEnabled());
        openCloseBehavior.getEvents().has().text("open!\nclose!");
    }

    @Test
    public void toggleConfigurableSideNavTest() {
        refresh();
        configurableMode.show();
        contentToggle.click();
        configurableMode.base().timer().wait(() -> configurableMode.visualValidation(".mat-sidenav"));
        configurableMode.getSideNav().has().attr(STYLE, STYLE_VISIBLE);

        sideToggle.click();
        configurableMode.base().timer().wait(() -> configurableMode.visualValidation(".mat-sidenav"));
        configurableMode.getSideNav().has().attr(STYLE, STYLE_HIDDEN);
    }

    @Test
    public void sideRadioGroupTest() {
        refresh();
        contentToggle.click();
        configurableMode.getContent().has().attr(STYLE, "");

        sideNavRadioButtons.click("Side");
        configurableMode.getContent().has().attr(STYLE, "margin-left: 257px;");

        sideNavRadioButtons.click("Push");
        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px; margin-right: -258px;");
    }

    @Test
    public void contentRadioButtonsTest() {
        contentToggle.click();
        sideNavRadioButtons.click("Side");
        configurableMode.getContent().has().attr(STYLE, "margin-left: 257px;");

        contentRadioButtons.click("Push");
        configurableMode.getContent().has().attr(STYLE, "margin-left: 258px; margin-right: -258px;");
    }

    @Test
    public void closeByToggleTest() {
        refresh();
        customEscapeBackdrop.show();
        openSideNav.click();
        toggleSideNav.click();
        customEscapeBackdrop.getContent().has().text(containsString("toggle button"));
    }

    @Test
    public void closeByBackdropTest() {
        openSideNav.click();
        customEscapeBackdrop.core().click();
        customEscapeBackdrop.getContent().has().text(containsString("backdrop"));
    }

    @Test
    public void verifyAutoSizeSideNav() {
        autoSizeSideNav.show();
        toggleAutoNav.click();
        toggleExtraText.click();
        autoSizeSideNav.getMatDrawer().has().text(containsString("Toggle extra text"));
        autoSizeSideNav.getMatDrawerContent().has().attr(STYLE, "margin-left: 293px;");
    }

    @Test
    public void fixedSideNavTest() {
        String testValue = "100";
        fixedPosition.show();
        topGap.click();
        topGap.clear();
        topGap.sendKeys(testValue);
        bottomGap.click();
        bottomGap.clear();
        bottomGap.sendKeys(testValue);
        fixSideNav.click();
        fixedPosition.getSideNav().has().attr(STYLE, "transform: none; visibility: visible; top: 100px; bottom: " +
                "100px;");

        toggleFixedSideNav.click();
        fixedPosition.base().timer().wait(() -> fixedPosition.visualValidation(".mat-sidenav-content"));
        fixedPosition.getSideNav().has().attr(STYLE, "top: 100px; bottom: 100px; box-shadow: none; visibility: " +
                "hidden;");
    }

    @Test
    public void toggleResponsiveSideNavTest() {
        int[] testValues = {1, 3};
        responsiveContent.show();
        toolbarToggle.click();
        for (int value : testValues) {
            responsiveContent.getSideNavLinks().get(value).click();
            responsiveContent.getResponsiveResults().get(value).has().text(String.format("Selected Nav Item %d", value));
        }
    }
}
