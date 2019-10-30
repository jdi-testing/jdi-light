package io.github.epam.bootstrap.tests.composite.section.navbar;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.getUrl;
import static io.github.com.pages.BootstrapPage.navbarPlacementStickyTop;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static java.lang.Integer.parseInt;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class NavbarPlacementTests extends TestsInit {

    private static final String STICKY_TOP_LINK_TEXT = "Sticky Top";
    private static final String BOOTSTRAP_NAVBAR_PLACEMENT_PAGE_URL = "https://getbootstrap.com/docs/4.3/components/navbar/#placement";
    private static final String HOME_LINK_TEXT = "Home";
    private static final String FEATURES_LINK_TEXT = "Features";
    private static final String PRICING_LINK_TEXT = "Pricing";
    private static final String DISABLED_LINK_TEXT = "Disabled";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(navbarPlacementStickyTop);
    }

    @Test
    public void navbarLinkTest() {
        navbarPlacementStickyTop.stickyTop.is().text(STICKY_TOP_LINK_TEXT);
        navbarPlacementStickyTop.stickyTop.click();
        assertEquals(getUrl(), BOOTSTRAP_NAVBAR_PLACEMENT_PAGE_URL);
    }

    @Test
    public void navLinkTextTest() {
        navbarPlacementStickyTop.navbarLinks.is()
                .values(HOME_LINK_TEXT, FEATURES_LINK_TEXT, PRICING_LINK_TEXT, DISABLED_LINK_TEXT);
    }

    @Test
    public void navbarPositionTest() {
        navbarPlacementStickyTop.show();
        navbarPlacementStickyTop.core()
                .is()
                .css("position", "sticky")
                .css("top", "0px");
    }

    @Test
    public void navbarScrollTest() throws InterruptedException {
        navbarPlacementStickyTop.core().jsExecute("scrollIntoView()");
        int heightOfContainer = getHeightOfContainer();
        int top1 = getTopValueOfNavbarPlacementStickyTop();
        assertEquals(top1, 0);
        bsPageScroll(0, heightOfContainer/3);
        int top2 = getTopValueOfNavbarPlacementStickyTop();
        assertEquals(top2, 0);
        bsPageScroll(0, heightOfContainer);
        int top3 = getTopValueOfNavbarPlacementStickyTop();
        assertNotEquals(top3, 0);
    }

    private int getHeightOfContainer() {
        int heightOfContainerWithPaddings = navbarPlacementStickyTop.parentContainer.getRect().getHeight();
        String nonDigitsRegexp = "[^0-9.]";
        String contentPT = navbarPlacementStickyTop.parentContainer.core().css("padding-top").replaceAll(nonDigitsRegexp,"");
        String contentPB = navbarPlacementStickyTop.parentContainer.core().css("padding-bottom").replaceAll(nonDigitsRegexp, "");
        return heightOfContainerWithPaddings - parseInt(contentPT) - parseInt(contentPB);
    }

    private void bsPageScroll(int x, int y) {
        bsPage.js().executeScript("scrollBy(" + x + "," + y + ")");
    }

    private int getTopValueOfNavbarPlacementStickyTop() {
        String topStr = navbarPlacementStickyTop.core().jsExecute("getBoundingClientRect().top");
        double topDouble = Double.parseDouble(topStr);
        return (int) Math.round(topDouble);
    }
}
