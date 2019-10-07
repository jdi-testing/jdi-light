package io.github.epam.bootstrap.tests.composite.section.navbar;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static com.epam.jdi.light.elements.common.WindowsManager.*;
import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarNavWithDisabled;
import static io.github.com.pages.BootstrapPage.navbarNavWithDropdown;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class NavbarNavsTests extends TestsInit {

    private String textNavbarBrandDisabled = "Navbar";
    private String textNavbarBrandWithDropdown = "Navbar";
    private List<String> textLinksnavbarNavWithDisabled = Arrays.asList("Home", "HTML 5", "Bootstrap", "Disabled");
    private List<String> urlLinksnavbarNavWithDisabled = Arrays.asList("https://jdi-testing.github.io/jdi-light/index.html", "https://jdi-testing.github.io/jdi-light/html5.html", "https://jdi-testing.github.io/jdi-light/bootstrap.html", "#");
    private List<String> textLinksnavbarNavWithDropdown = Arrays.asList("Home", "HTML 5", "Bootstrap", "Navbar");
    private List<String> urlLinksnavbarNavWithDropdown = Arrays.asList("https://jdi-testing.github.io/jdi-light/index.html", "https://jdi-testing.github.io/jdi-light/html5.html", "https://jdi-testing.github.io/jdi-light/bootstrap.html");

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

    @Test
    public void clickNavbarNavWithDisabledLinksTest() throws RuntimeException {
        for (int i = 1; i < navbarNavWithDisabled.navbarLinks.size(); i++) {
            navbarNavWithDisabled.navbarLinks.get(i).is().text(containsString(textLinksnavbarNavWithDisabled.get(i)));
            try {
                navbarNavWithDisabled.navbarLinks.get(i).click();
                assertThat(windowsCount(), is(2));
                switchToWindow(2);
                assertThat(getUrl(), is(urlLinksnavbarNavWithDisabled.get(i)));
                closeWindow();
            } catch (RuntimeException e) {
                assertThat(e.getMessage(), containsString("is not clickable in any parts"));
                break;
            }
        }
    }

    @Test
    public void clickNavbarNavWithDropdownLinksTest() throws RuntimeException {
        for (int i = 1; i < navbarNavWithDropdown.navbarLinks.size(); i++) {
            navbarNavWithDropdown.navbarLinks.get(i).is().text(containsString(textLinksnavbarNavWithDropdown.get(i)));
            try {
                navbarNavWithDropdown.navbarLinks.get(i).click();
                if (navbarNavWithDropdown.navbarLinks.get(i).getAttribute("class").equals("nav-item dropdown show")) {
                    break;
                }
                assertThat(windowsCount(), is(2));
                switchToWindow(2);
                assertThat(getUrl(), is(urlLinksnavbarNavWithDropdown.get(i)));
                closeWindow();
            } catch (RuntimeException e) {
                assertThat(e.getMessage(), containsString("is not clickable in any parts"));
                break;
            }
        }
    }

    @Test
    public void isDisabledItem() {
        navbarNavWithDisabled.navbarLinks.get(3).is().disabled();
    }









}
