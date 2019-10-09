package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSupportedContent;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class NavbarSupportedContentTests extends TestsInit {

    private static final String navbarBrandText = "Navbar brand";
    private static final String bootstrapNavPageUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";
    private static final String jdiPageUrl = "https://github.com/jdi-testing/jdi-light/";
    private static final String jdiBootstrapPageUrl = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";

    private static final String activeLinkText = "Active link\n(current)";
    private static final String jdiLinkText = "JDI Light";
    private static final String disabledLinkText = "Disabled link";

    @DataProvider
    public Object[][] navbarLinkData() {
        return new Object[][] {
                {activeLinkText, activeLinkText, bootstrapNavPageUrl},
                {jdiLinkText, jdiLinkText, jdiPageUrl},
                {disabledLinkText, disabledLinkText, jdiBootstrapPageUrl}
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
        assertEquals(getUrl() , bootstrapNavPageUrl);
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(1);
    }

    @Test(dataProvider = "navbarLinkData")
    public void navLinksContentTest(String elementName,
                                    String elementText,
                                    String elementUrl) {
        navbarSupportedContent.nav.highlight();
        navbarSupportedContent.nav.list().get(elementName)
                .is()
                .text(elementText)
                .and()
                .attr("href", elementUrl);
    }

    @Test
    public void dropdownTest() throws InterruptedException {
        navbarSupportedContent.dropdown.highlight();
        Thread.sleep(2000);
        navbarSupportedContent.dropdown.toggle();
        Thread.sleep(2000);
        navbarSupportedContent.dropdown.list().get("Action").click();
    }

}
