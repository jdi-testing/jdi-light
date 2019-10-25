package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.getUrl;
import static io.github.com.pages.BootstrapPage.navbarPlacementStickyTop;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class NavbarPlacementTests extends TestsInit {

    private static final String stickyTopLinkText = "Sticky Top";
    private static final String bootstrapNavbarPlacementPageUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#placement";
    private static final String homeLinkText = "Home";
    private static final String featuresLinkText = "Features";
    private static final String pricingLinkText = "Pricing";
    private static final String disabledLinkText = "Disabled";


    @DataProvider
    public Object[][] navLinkTextData() {
        return new Object[][]{
                {homeLinkText},
                {featuresLinkText},
                {pricingLinkText},
                {disabledLinkText}
        };
    }

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
    public void navbarPositionTest() {
        navbarPlacementStickyTop.show();
        navbarPlacementStickyTop.core().
                is().
                css("position", "sticky").
                css("top", "0px");
    }

    @Test
    public void navbarSectionTest() throws InterruptedException {
        navbarPlacementStickyTop.core().jsExecute("scrollIntoView()");
        WebDriver driver = WebDriverFactory.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0, 100);");
        Thread.sleep(1000);

    }


    @Test(dataProvider = "navLinkTextData")
    public void navLinkTextTest(String linkText) {
        navbarPlacementStickyTop.navbarLinks.show();
        navbarPlacementStickyTop.navbarLinks.is()
                .text(linkText);
    }

}
