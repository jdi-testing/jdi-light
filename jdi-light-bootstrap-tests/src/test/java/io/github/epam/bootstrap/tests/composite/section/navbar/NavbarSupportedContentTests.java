package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarSupportedContent;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavbarSupportedContentTests extends TestsInit {

    private static final String navbarBrandText = "Navbar brand";
    private static final String bootstrapNavPageUrl = "https://getbootstrap.com/docs/4.3/components/navbar/#nav";
    private static final String jdiPageUrl = "https://github.com/jdi-testing/jdi-light/";
    private static final String jdiBootstrapPageUrl = "https://jdi-testing.github.io/jdi-light/bootstrap.html#";
    private static final String activeLinkText = "Active link";
    private static final String jdiLinkText = "JDI Light";
    private static final String disabledLinkText = "Disabled link";
    private static final String dropdownLinkText = "Dropdown";

    private static final String dropdownAction = "Action";
    private static final String dropdownActionAlert = "Action Clicked!";
    private static final String dropdownAnotherAction = "Another action";
    private static final String dropdownAnotherActionAlert = "Another action Clicked!";
    private static final String dropdownSmthElse = "Something else here";
    private static final String dropdownSmthElseAlert = "Something else happened!";

    private static final String searchButtonText = "Search";
    private static final String searchButtonAlertText = "Search Button Clicked!";


    @DataProvider
    public Object[][] navbarLinkData() {
        return new Object[][]{
                {activeLinkText, activeLinkText, bootstrapNavPageUrl},
                {jdiLinkText, jdiLinkText, jdiPageUrl},
                {disabledLinkText, disabledLinkText, jdiBootstrapPageUrl}
        };
    }

    @DataProvider
    public Object[][] dropdownData() {
        return new Object[][]{
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
    public void navClassCheck() {
        assertThat(navbarSupportedContent.nav.hasClass("navbar-nav"), is(true));
    }

    @Test
    public void navbarLinkTest() {
        navbarSupportedContent.brand.is().text(navbarBrandText);
        navbarSupportedContent.brand.click();

        WindowsManager.switchToWindow(2);
        assertEquals(getUrl(), bootstrapNavPageUrl);
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(1);
    }

    @Test(dataProvider = "navbarLinkData")
    public void navLinkContentsTest(String elementName,
                                    String elementText,
                                    String elementUrl) {
        navbarSupportedContent.nav.show();
        navbarSupportedContent.nav.list().get(elementName)
                .is()
                .text(elementText)
                .and()
                .attr("href", elementUrl);
    }

    @Test(dataProvider = "dropdownData")
    public void dropdownContentTest(String element, String alertText) {
        navbarSupportedContent.dropdown.show();

        navbarSupportedContent.dropdown.toggle();
        navbarSupportedContent.dropdown.list().select(element);

        validateAlert(is(alertText));
    }

    @Test(priority = 10)
    public void resizeLinkTest() {
        WindowsManager.resizeWindow(900, 600);

        navbarSupportedContent.navExpand.show();
        navbarSupportedContent.navExpand.click();

        navbarSupportedContent.nav.is().expanded();

        navbarSupportedContent.nav.list().select("Active link");
        WindowsManager.switchToWindow(2);
        assertEquals(getUrl(), bootstrapNavPageUrl);
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(1);

        navbarSupportedContent.nav.list().select("JDI Light");
        WindowsManager.switchToWindow(2);
        assertEquals(getUrl(), jdiPageUrl);
        WindowsManager.closeWindow();
        WindowsManager.switchToWindow(1);
    }

    @Test(priority = 11)
    public void collapseLinkTextTest() {
        List<String> links = Arrays.asList(
                activeLinkText,
                jdiLinkText,
                dropdownLinkText,
                dropdownAction,
                dropdownAnotherAction,
                dropdownSmthElse,
                disabledLinkText
        );
        
        WindowsManager.resizeWindow(900, 600);

        navbarSupportedContent.navExpand.show();
        navbarSupportedContent.navExpand.click();

        navbarSupportedContent.nav.is().expanded();
        
        List<String> actual = navbarSupportedContent.nav.list().values().stream().map(s->s.replaceAll("\\s+", " ")).collect(Collectors.toList());
        assertTrue(actual.containsAll(links));
    }

    @Test
    public void searchFormTest() {
        navbarSupportedContent.searchField.show();
        navbarSupportedContent.searchField.setValue("JDI Light");
        assertThat(navbarSupportedContent.searchField.getValue(), is("JDI Light"));
    }

    @Test
    public void searchButtonTest() {
        navbarSupportedContent.searchButton.show();
        navbarSupportedContent.searchButton.is().text(searchButtonText);
        navbarSupportedContent.searchButton.click();
        validateAlert(is(searchButtonAlertText));
    }

}
