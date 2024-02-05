package io.github.epam.angular.tests.elements.complex;

import com.epam.jdi.light.angular.elements.complex.SideNav;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.sideNavPage;
import static io.github.com.enums.ConfigurableMode.OVER;
import static io.github.com.enums.ConfigurableMode.PUSH;
import static io.github.com.enums.ConfigurableMode.SIDE;
import static io.github.com.pages.SideNavPage.autoSizeSideNav;
import static io.github.com.pages.SideNavPage.backDropToggle;
import static io.github.com.pages.SideNavPage.basicDrawer;
import static io.github.com.pages.SideNavPage.basicSideNav;
import static io.github.com.pages.SideNavPage.bottomGap;
import static io.github.com.pages.SideNavPage.configurableMode;
import static io.github.com.pages.SideNavPage.contentRadioGroup;
import static io.github.com.pages.SideNavPage.contentToggle;
import static io.github.com.pages.SideNavPage.customEscapeBackdrop;
import static io.github.com.pages.SideNavPage.firstElementFocused;
import static io.github.com.pages.SideNavPage.fixSideNav;
import static io.github.com.pages.SideNavPage.fixedPosition;
import static io.github.com.pages.SideNavPage.implicitMainContent;
import static io.github.com.pages.SideNavPage.openCloseBehavior;
import static io.github.com.pages.SideNavPage.openSideNav;
import static io.github.com.pages.SideNavPage.responsiveContent;
import static io.github.com.pages.SideNavPage.sideNavFocusSelection;
import static io.github.com.pages.SideNavPage.sideNavOpened;
import static io.github.com.pages.SideNavPage.sideNavPosition;
import static io.github.com.pages.SideNavPage.sideNavRadioGroup;
import static io.github.com.pages.SideNavPage.sideNavToggle;
import static io.github.com.pages.SideNavPage.sideToggle;
import static io.github.com.pages.SideNavPage.sidenavBackdropContainer;
import static io.github.com.pages.SideNavPage.sidenavBackdropDrawer;
import static io.github.com.pages.SideNavPage.toggleAutoNav;
import static io.github.com.pages.SideNavPage.toggleExtraText;
import static io.github.com.pages.SideNavPage.toggleFixedSideNav;
import static io.github.com.pages.SideNavPage.toggleSideNav;
import static io.github.com.pages.SideNavPage.toolbarToggle;
import static io.github.com.pages.SideNavPage.topGap;
import static java.lang.String.format;
import static org.hamcrest.Matchers.containsString;


public class SideNavTests extends TestsInit {

    public static final String SIDE_NAV_CONTENT = "Sidenav content";
    public static final String DRAWER_CONTENT = "Drawer content";
    public static final String MAIN_CONTENT = "Main content";
    public static final String STYLE = "style";
    public static final String STYLE_VISIBLE = "transform: none; visibility: visible;";
    public static final String STYLE_HIDDEN = "box-shadow: none; visibility: hidden;";
    public static final String MODE = "mode";

    @BeforeClass(alwaysRun = true)
    public void before() {
        sideNavPage.open();
        waitCondition(() -> sideNavPage.isOpened());
        sideNavPage.checkOpened();
    }

    @Test(description = "Verify that the basic sideNav is displayed")
    public void verifyBasicSideNavTest() {
        basicSideNav.show();
        basicSideNav.is().displayed();
        basicSideNav.is().enabled();
        basicSideNav.getSideNav().has().text(SIDE_NAV_CONTENT);
        basicSideNav.getContent().has().text(MAIN_CONTENT);
    }

    @Test(description = "Verify that the basicDrawer sideNav is displayed")
    public void verifyBasicDrawerTest() {
        basicDrawer.show();
        basicDrawer.is().displayed();
        basicDrawer.is().enabled();
        basicDrawer.getMatDrawer().has().text(DRAWER_CONTENT);
        basicDrawer.getMatDrawerContent().has().text(MAIN_CONTENT);
    }

    @Test(description = "Tests confirm menu position changes for 'start' or 'end' selector options.")
    public void verifyPositionSelectionDrawerWithExplicitBackdropSettingSideNavTest() {
        sidenavBackdropContainer.show();
        sidenavBackdropContainer.is().displayed();
        sidenavBackdropContainer.is().enabled();

        sideNavPosition.click();
        sideNavPosition.select("End");

        backDropToggle.click();
        sidenavBackdropDrawer.is().displayed();
        sidenavBackdropContainer.has().sideNavSectionOnTheRight(sidenavBackdropDrawer.getLocation());
    }

    @Test(description = "Test verifies first menu item focus when 'true' is selected")
    public void verifyFocusSelectionDrawerWithExplicitBackdropSettingSideNavTest() {
        sidenavBackdropContainer.show();
        sidenavBackdropContainer.is().displayed();
        sidenavBackdropContainer.is().enabled();

        sideNavFocusSelection.click();
        sideNavFocusSelection.select("True");

        backDropToggle.click();

        firstElementFocused.has().text("First Element");
        firstElementFocused.is().displayed();
        firstElementFocused.is().focused();
    }

    @Test(description = "Verify main content is properly displayed alongside two side navigation panels")
    public void verifyImplicitMainContentWithTwoSideNavTest() {
        implicitMainContent.show();
        SideNav start = implicitMainContent.getSideNav("start");
        SideNav end = implicitMainContent.getSideNav("end");

        start.has().attr(MODE, SIDE.getMode());
        start.has().attr(STYLE, STYLE_VISIBLE);
        start.has().text("Start content");

        end.has().attr(MODE, SIDE.getMode());
        end.has().attr(STYLE, STYLE_VISIBLE);
        end.has().text("End content");

        implicitMainContent.getContent().has().text("Implicit main content");
        implicitMainContent.getContent().is().displayed();
        implicitMainContent.getContent().is().enabled();
    }

    @Test(description = "Tests the opening and closing functionality of the component")
    public void verifyOpenCloseBehaviorTest() {
        refresh();
        openCloseBehavior.show();
        openCloseBehavior.getContent().is().displayed();
        openCloseBehavior.getContent().is().enabled();

        sideNavToggle.click();
        openCloseBehavior.getSideNav().has().text(SIDE_NAV_CONTENT);

        sideNavOpened.click();
        openCloseBehavior.isEnabled();
        openCloseBehavior.getSideNav().is().notVisible();
    }

    @Test(description = "Verify SideNav with with configurable mode")
    public void toggleConfigurableSideNavTest() {
        refresh();
        configurableMode.show();
        contentToggle.click();
        configurableMode.base().timer().wait(() -> configurableMode.getSideNav().has().attr(STYLE, STYLE_VISIBLE));
        configurableMode.getSideNav().has().attr(STYLE, STYLE_VISIBLE);

        sideToggle.click();
        configurableMode.base().timer().wait(() -> configurableMode.getSideNav().has().attr(STYLE, STYLE_HIDDEN));
        configurableMode.getSideNav().has().attr(STYLE, STYLE_HIDDEN);
    }

    @Test(description = "Verify side radio group buttons")
    public void sideRadioGroupTest() {
        refresh();
        contentToggle.click();

        sideNavRadioGroup.show();
        configurableMode.getContent().is().displayed();
        configurableMode.getMatDrawer().has().configurableMode(OVER.getMode());

        sideNavRadioGroup.click(SIDE.getMode());
        configurableMode.getContent().is().displayed();
        configurableMode.getMatDrawer().has().configurableMode(SIDE.getMode());

        sideNavRadioGroup.click(PUSH.getMode());
        configurableMode.getContent().is().displayed();
        configurableMode.getMatDrawer().has().configurableMode(PUSH.getMode());
    }

    @Test(description = "Verify content radio group buttons")
    public void contentRadioButtonsTest() {
        refresh();
        contentToggle.click();
        sideNavRadioGroup.show();

        sideNavRadioGroup.click(SIDE.getMode());
        configurableMode.getMatDrawer().has().configurableMode(SIDE.getMode());

        contentRadioGroup.click(PUSH.getMode());
        configurableMode.getMatDrawer().has().configurableMode(PUSH.getMode());
    }

    @Test(description = "Verify toggle button")
    public void closeByToggleTest() {
        refresh();
        customEscapeBackdrop.show();
        openSideNav.click();
        toggleSideNav.click();
        customEscapeBackdrop.getContent().has().text(containsString("toggle button"));
    }

    @Test(description = "Verify backdrop click behavior")
    public void closeByBackdropTest() {
        openSideNav.click();
        customEscapeBackdrop.core().click();
        customEscapeBackdrop.getContent().has().text(containsString("backdrop"));
    }

    @Test(description = "Verify auto size SideNav")
    public void verifyAutoSizeSideNav() {
        autoSizeSideNav.show();
        toggleAutoNav.click();
        toggleExtraText.click();
        autoSizeSideNav.getMatDrawer().has().text(containsString("Toggle extra text"));
    }

    @Test(description = "Verify fixed sideNav")
    public void fixedSideNavTest() {
        String testValue = "100";
        fixedPosition.show();
        topGap.clear();
        topGap.setValue(testValue);
        bottomGap.clear();
        bottomGap.setValue(testValue);
        fixSideNav.click();
        fixedPosition.getSideNav().has().attr(STYLE, "transform: none; visibility: visible; top: 100px; bottom: " +
            "100px;");

        toggleFixedSideNav.click();

        fixedPosition.base().timer().wait(() -> fixedPosition.getSideNav().is().hidden());
        fixedPosition.getSideNav().has().attr(STYLE, "top: 100px; bottom: 100px; box-shadow: none; visibility: " +
            "hidden;");
    }

    @Test(description = "Verify toggle responsive sideNave")
    public void toggleResponsiveSideNavTest() {
        int[] testValues = {1, 3};
        responsiveContent.show();
        toolbarToggle.click();
        for (int value : testValues) {
            responsiveContent.getSideNav().getSideNavLinks().get(value).click();
            responsiveContent.getResponsiveResults().get(value).has().text(format("Selected Nav Item %d", value));
        }
    }
}
