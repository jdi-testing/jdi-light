package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarNav;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

public class NavbarNavTests extends TestsInit {
    private static final String JS_SCROLL_TO_ELEMENT = "scrollIntoView(true);";
    private static final String BRAND_NAME = "Navbar";
    private static final String NAVBAR_BOOTSTRAP = "Navbar · Bootstrap";
    private static final String HOME = "Home\n(current)";
    private static final String HOME_PAGE = "Home Page";
    private static final String HTML5 = "HTML 5";
    private static final String HTML5_PAGE = HTML5;
    private static final String BOOTSTRAP = "Bootstrap";
    private static final String BOOTSTRAP_PAGE = BOOTSTRAP;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        $(navbarNav.core().getLocator()).jsExecute(JS_SCROLL_TO_ELEMENT);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(navbarNav.navLinks1);
        baseValidation(navbarNav.navbarComplexLinks);
    }

    @Test
    public void verifyComplexNavbarBrandTest() {
        navbarNav.navLinks1.brand
                .is()
                .text(is(BRAND_NAME));
        navbarNav.navLinks1.brand.click();
        newWindowTitleCheck(NAVBAR_BOOTSTRAP);
        navbarNav.navbarComplexLinks.brand
                .is()
                .text(is(BRAND_NAME));
        navbarNav.navbarComplexLinks.brand.click();
        newWindowTitleCheck(NAVBAR_BOOTSTRAP);
    }

    @Test
    public void clickNavbarNavWithDisabledLinksTest() {
        navbarNav.navLinks1.listPages.get(1)
                .is()
                .text(is(HOME));
        navbarNav.navLinks1.listPages.get(1).click();
        newWindowTitleCheck(HOME_PAGE);

        navbarNav.navLinks1.listPages.get(2)
                .is()
                .text(is(HTML5));
        navbarNav.navLinks1.listPages.get(2).click();
        newWindowTitleCheck(HTML5_PAGE);

        navbarNav.navLinks1.listPages.get(3)
                .is()
                .text(is(BOOTSTRAP));
        navbarNav.navLinks1.listPages.get(3).click();
        newWindowTitleCheck(BOOTSTRAP_PAGE);
    }

    @Test
    public void verifyDisbledLinkTest() {
        navbarNav.navLinks1.listPages.get(4)
                .is()
                .displayed();
        navbarNav.navLinks1.listPages.get(4)
                .is()
                .disabled();
    }

    @Test
    public void verifyDropdownLinkTest() {
        navbarNav.navbarComplexLinks.listPages.get(4)
                .is()
                .displayed();
        UIElement element = navbarNav.navbarComplexLinks.listPages.get(4);
//        element.get().click();
        Dropdown dropdown = navbarNav.navbarComplexLinks.dropdown;
//        Dropdown dropdown = new Dropdown();
//        dropdown.setCore(Dropdown.class, element.find(".dropdown").base());
//        dropdown.expandLocator = "#navbarDropdownMenuLink";
//        dropdown.listLocator = "a";
        select(dropdown,"Brand");
        select(dropdown,"Nav");
        select(dropdown,"Forms");
    }

    @Test
    public void clickNavbarNavWithComplexLinksTest() {
        navbarNav.navbarComplexLinks.listPages.get(1)
                .is()
                .text(is(HOME));
        navbarNav.navbarComplexLinks.listPages.get(1).click();
        newWindowTitleCheck(HOME_PAGE);

        navbarNav.navbarComplexLinks.listPages.get(2)
                .is()
                .text(is(HTML5));
        navbarNav.navbarComplexLinks.listPages.get(2).click();
        newWindowTitleCheck(HTML5_PAGE);

        navbarNav.navbarComplexLinks.listPages.get(3)
                .is()
                .text(is(BOOTSTRAP));
        navbarNav.navbarComplexLinks.listPages.get(3).click();
        newWindowTitleCheck(BOOTSTRAP_PAGE);
    }

    private void select(Dropdown dd, String item) {
        dd.show();
        dd.toggle();
        dd.list().select(item);
        newWindowTitleCheck(NAVBAR_BOOTSTRAP);
    }

    private void select(String item) {
        navbarNav.navbarComplexLinks.dropdown.show();
        navbarNav.navbarComplexLinks.dropdown.toggle();
        navbarNav.navbarComplexLinks.dropdown.list().select(item);
        newWindowTitleCheck(NAVBAR_BOOTSTRAP);
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
