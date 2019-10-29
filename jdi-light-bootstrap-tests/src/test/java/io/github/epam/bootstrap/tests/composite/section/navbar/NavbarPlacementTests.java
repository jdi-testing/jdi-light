package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
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

    private static final String stickyTopLinkText = "Sticky Top";
    private static final String bootstrapNavbarPlacementPageUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#placement";
    private static final String homeLinkText = "Home";
    private static final String featuresLinkText = "Features";
    private static final String pricingLinkText = "Pricing";
    private static final String disabledLinkText = "Disabled";

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
        navbarPlacementStickyTop.stickyTop.is().text(stickyTopLinkText);
        navbarPlacementStickyTop.stickyTop.click();
        assertEquals(getUrl(), bootstrapNavbarPlacementPageUrl);
    }

    @Test
    public void navLinkTextTest() {
        navbarPlacementStickyTop.navbarLinks.is()
                .values(homeLinkText, featuresLinkText, pricingLinkText, disabledLinkText);
    }

    @Test
    public void navbarPositionTest() {
        navbarPlacementStickyTop.show();
        navbarPlacementStickyTop.core().
                is().
                css("position", "sticky").
                css("top", "0px");
    }

    @Test
    public void navbarScrollTest() throws InterruptedException {
        navbarPlacementStickyTop.core().jsExecute("scrollIntoView()");
        int heightOfContainer = getHeightOfContainer();
        int top1 = getTopValueOfNavbarPlacementStickyTop();
        assertEquals(top1, 0);
        bsPageExecuteJS("scrollBy(0," + heightOfContainer/3 + ")");
        int top2 = getTopValueOfNavbarPlacementStickyTop();
        assertEquals(top2, 0);
        bsPageExecuteJS("scrollBy(0," + heightOfContainer + ")");
        int top3 = getTopValueOfNavbarPlacementStickyTop();
        assertNotEquals(top3, 0);
    }

    private int getHeightOfContainer() {
        UIElement parentContainer = navbarPlacementStickyTop.find(By.xpath("./.."));
        String heightOfContainerWithPaddings = parentContainer.core().jsExecute("clientHeight");
        String nonDigitsRegexp = "[^0-9.]";
        String contentPT = parentContainer.core().css("padding-top").replaceAll(nonDigitsRegexp,"");
        String contentPB = parentContainer.core().css("padding-bottom").replaceAll(nonDigitsRegexp, "");
        return parseInt(heightOfContainerWithPaddings) - parseInt(contentPT) - parseInt(contentPB);
    }

    private void bsPageExecuteJS(String jsCode) {
        bsPage.js().executeScript(jsCode);
    }

    private int getTopValueOfNavbarPlacementStickyTop() {
        String topStr = navbarPlacementStickyTop.core().jsExecute("getBoundingClientRect().top");
        double topDouble = Double.parseDouble(topStr);
        return (int) Math.round(topDouble);
    }
}
