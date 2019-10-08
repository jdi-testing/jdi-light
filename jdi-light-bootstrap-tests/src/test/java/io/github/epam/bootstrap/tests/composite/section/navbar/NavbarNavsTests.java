package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarNavWithDisabled;
import static io.github.com.pages.BootstrapPage.navbarNavWithDropdown;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NavbarNavsTests extends TestsInit {

    private String textNavbarBrandDisabled = "Navbar";
    private String textNavbarBrandWithDropdown = "Navbar";

    @DataProvider
    public Object[][] linkNavbarDisabledTest() {
        return new Object[][]{
                {0, "Home\n(current)", "https://jdi-testing.github.io/jdi-light/index.html"},
                {1, "HTML 5", "https://jdi-testing.github.io/jdi-light/html5.html"},
                {2, "Bootstrap", "https://jdi-testing.github.io/jdi-light/bootstrap.html"},
                {3, "Disabled", "#"},
        };
    }

    @DataProvider
    public Object[][] linkNavbarWithDropdownTest() {
        return new Object[][]{
                {0, "Home\n(current)", "https://jdi-testing.github.io/jdi-light/index.html"},
                {1, "HTML 5", "https://jdi-testing.github.io/jdi-light/html5.html"},
                {2, "Bootstrap", "https://jdi-testing.github.io/jdi-light/bootstrap.html"},
                {3, "Navbar", "#"},
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        bsPage.refresh();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(navbarNavWithDisabled);
        baseValidation(navbarNavWithDropdown);
    }

    @Test
    public void isValidationTest() {
        navbarNavWithDisabled.is().displayed();
        navbarNavWithDisabled.is().enabled();
        assertThat(navbarNavWithDisabled.core().css("font-size"), is("14px"));
        navbarNavWithDisabled.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .cssClass("navbar navbar-expand-lg navbar-light bg-light")
                .tag(is("nav"));

        navbarNavWithDropdown.is().displayed();
        navbarNavWithDropdown.is().enabled();
        assertThat(navbarNavWithDropdown.core().css("font-size"), is("14px"));
        navbarNavWithDropdown.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .cssClass("navbar navbar-expand-lg navbar-light bg-light")
                .tag(is("nav"));
    }

    @Test
    public void getNameNavbarBrandTest() {
        navbarNavWithDisabled.navbarBrand.is().text(textNavbarBrandDisabled);
        navbarNavWithDropdown.navbarBrand.is().text(textNavbarBrandWithDropdown);
    }

    @Test(dataProvider = "linkNavbarDisabledTest")
    public void clickNavbarNavWithDisabledLinksTest(int i, String text, String url) {
        UIElement link = navbarNavWithDisabled.navbarLinks.get(i);
        link.is().text(text);
        if (link.isDisabled()) {
            link.is().disabled();
        } else {
            link.click();
            assertThat(WindowsManager.windowsCount(), is(2));
            WindowsManager.switchToWindow(2);
            assertThat(getUrl(), is(url));
            WindowsManager.closeWindow();
        }
    }

    @Test(dataProvider = "linkNavbarWithDropdownTest")
    public void clickNavbarNavWithDropdownLinksTest(int i, String text, String url) {
        UIElement link = navbarNavWithDropdown.navbarLinks.get(i);
        link.is().text(text);
        if (link.getAttribute("class").equals("nav-item dropdown")) {
            baseValidation(link);
        } else {
            link.click();
            assertThat(WindowsManager.windowsCount(), is(2));
            WindowsManager.switchToWindow(2);
            assertThat(getUrl(), is(url));
            WindowsManager.closeWindow();
        }
    }
}
