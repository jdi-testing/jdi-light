package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import io.github.com.sections.navbar.NavbarColorScheme;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Mariia Tikhonova on 10.10.2019
 * Email: mariia_tikhonova@epam.com, Skype: mariatikhonova5_2
 */

public class NavbarColorSchemeTests extends TestsInit {

    @DataProvider(name = "navbarColorSchemes")
    public static Object[][] navbarColorSchemes() {
        return new Object[][]{
                {navbarDarkColorScheme},
                {navbarBlueColorScheme},
                {navbarLightColorScheme}
        };
    }

    @DataProvider(name = "navbarColorSchemesWithColors")
    public static Object[][] navbarColorSchemesWithColors() {
        return new Object[][]{
                {navbarDarkColorScheme, "rgba(52, 58, 64, 1)", "rgba(255, 255, 255, 1)", "rgba(255, 255, 255, 0.5)", "(23, 162, 184"},
                {navbarBlueColorScheme, "rgba(0, 123, 255, 1)", "rgba(255, 255, 255, 1)", "rgba(255, 255, 255, 0.5)", "(248, 249, 250"},
                {navbarLightColorScheme, "rgba(227, 242, 253, 1)", "rgba(0, 0, 0, 0.9)", "rgba(0, 0, 0, 0.5)", "(0, 123, 255"}
        };
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        navbarDarkColorScheme.hover();
    }

    @Test(dataProvider = "navbarColorSchemes")
    public void baseValidationTest(NavbarColorScheme navbarColorScheme) {
        baseValidation(navbarColorScheme);
    }

    @Test(dataProvider = "navbarColorSchemesWithColors")
    public void colorSchemeAccordanceTest(NavbarColorScheme navbarColorScheme, String backgroundColor, String navbarAndHomeColor, String contactAndMetalsColor, String searchColor) {
        navbarColorScheme.core().is()
                .css("background-color", backgroundColor);
        checkColorOfElement(navbarColorScheme.navbarLink, navbarAndHomeColor);
        checkColorOfElement(navbarColorScheme.homeLink, navbarAndHomeColor);
        checkColorOfElement(navbarColorScheme.contactFormLink, contactAndMetalsColor);
        checkColorOfElement(navbarColorScheme.metalsAndColorsLink, contactAndMetalsColor);
        checkColorOfElement(navbarColorScheme.searchButton, String.format("rgba%s, 1)", searchColor));
        navbarColorScheme.searchButton.core().is()
                .css("border-color", String.format("rgb%s)", searchColor));
    }

    @Test(dataProvider = "navbarColorSchemes")
    public void linksTest(NavbarColorScheme navbarColorScheme) {
        checkLink(navbarColorScheme.navbarLink, "https://getbootstrap.com/docs/4.0/components/navbar/#color-schemes", "Navbar");
        checkLink(navbarColorScheme.homeLink, "https://jdi-testing.github.io/jdi-light/index.html", "Home\n(current)");
        checkLink(navbarColorScheme.contactFormLink, "https://jdi-testing.github.io/jdi-light/contacts.html", "Contact form");
        checkLink(navbarColorScheme.metalsAndColorsLink, "https://jdi-testing.github.io/jdi-light/metals-colors.html", "Metals & Colors");
    }

    @Test(dataProvider = "navbarColorSchemes")
    public void searchTextFieldTest(NavbarColorScheme navbarColorScheme) {
        navbarColorScheme.searchFormInput.core().is()
                .tag("input")
                .attr("placeholder", "Search")
                .attr("aria-label", "Search");
        navbarColorScheme.searchFormInput.sendKeys("hello world 123");
        navbarColorScheme.searchFormInput.is().text("hello world 123");
    }

    @Test(dataProvider = "navbarColorSchemes")
    public void searchButtonTest(NavbarColorScheme navbarColorScheme) {
        navbarColorScheme.searchButton.core().is()
                .tag("button")
                .attr("type", "button")
                .attr("onclick", "alert('Search');")
                .text("Search");
        navbarColorScheme.searchButton.click();
        Alerts.validateAlert(is("Search"));
    }

    private void checkColorOfElement(ICoreElement elem, String color) {
        elem.core().is()
                .css("color", color);
    }

    private void checkLink(Link elem, String href, String linkText) {
        elem.core().is()
                .tag("a")
                .attr("href", href)
                .text(linkText);
    }
}
