package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSupportedContent;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavbarSupportedContentTests extends TestsInit {

    private static final String navbarBrandText = "Navbar brand";
    private static final String bootstrapNavPageUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";
    private static final String jdiPageUrl = "https://github.com/jdi-testing/jdi-light/";
    private static final String jdiBootstrapPageUrl = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private static final String activeLinkText = "Active link\n(current)";
    private static final String jdiLinkText = "JDI Light";
    private static final String disabledLinkText = "Disabled link";

    private static final String dropdownAction = "Action";
    private static final String dropdownActionAlert = "Action Clicked!";
    private static final String dropdownAnotherAction = "Another action";
    private static final String dropdownAnotherActionAlert = "Another action Clicked!";
    private static final String dropdownSmthElse = "Something else here";
    private static final String dropdownSmthElseAlert = "Something else happened!";

    @DataProvider
    public Object[][] navbarLinkData() {
        return new Object[][] {
                {activeLinkText, activeLinkText, bootstrapNavPageUrl},
                {jdiLinkText, jdiLinkText, jdiPageUrl},
                {disabledLinkText, disabledLinkText, jdiBootstrapPageUrl}
        };
    }

    @DataProvider
    public Object[][] dropdownData() {
        return new Object[][] {
                {dropdownAction, dropdownActionAlert},
                {dropdownAnotherAction, dropdownAnotherActionAlert},
                {dropdownSmthElse, dropdownSmthElseAlert},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void navbarBrandTest() {
        navbarSupportedContent.brand.is().text(navbarBrandText);
        navbarSupportedContent.brand.click();

        WindowsManager.switchToWindow(2);
        assertEquals(getUrl(), bootstrapNavPageUrl);
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(1);
    }

    @Test(dataProvider = "navbarLinkData")
    public void navLinkTest(String elementName,
                                    String elementText,
                                    String elementUrl) {
        navbarSupportedContent.nav.highlight();
        navbarSupportedContent.nav.list().get(elementName)
                .is()
                .text(elementText)
                .and()
                .attr("href", elementUrl);
    }

    @Test(dataProvider = "dropdownData")
    public void dropdownContentTest(String element, String alertText) {
        navbarSupportedContent.dropdown.highlight();

        navbarSupportedContent.dropdown.toggle();
        navbarSupportedContent.dropdown.list().select(element);
        validateAlert(is(alertText));
    }

    @Test
    public void resizeTest() {
        Dimension dimension = new Dimension(900, 600);
        WebDriverFactory.getDriver().manage().window().setSize(dimension);
        navbarSupportedContent.nav.highlight();
        navbarSupportedContent.nav.toggle();
        assertTrue(navbarSupportedContent.nav.isExpanded());
    }

}
