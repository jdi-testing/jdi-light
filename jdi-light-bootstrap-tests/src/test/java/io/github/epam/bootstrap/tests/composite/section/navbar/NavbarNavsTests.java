package io.github.epam.bootstrap.tests.composite.section.navbar;

import io.github.epam.TestsInit;
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

public class NavbarNavsTests extends TestsInit {
    private static final String JS_SCROLL_TO_ELEMENT = "scrollIntoView(true);";
    private static final String BRAND_NAME = "Navbar";
    private static final String NAVBAR_BOOTSTRAP = "Navbar · Bootstrap";
    private static final String HOME = "Home\n(current)";
    private static final String HOME_PAGE = "Home Page";
    private static final String HTML5 = "HTML 5";
    private static final String HTML5_PAGE = HTML5;
    private static final String BOOTSTRAP = "Bootstrap";
    private static final String BOOTSTRAP_PAGE = BOOTSTRAP;
    private static final String ITEM_BRAND = "Brand";
    private static final String ITEM_NAV = "Nav";
    private static final String ITEM_FORMS = "Forms";

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
    public void getNameNavbarBrandTest() {
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

    @Test
    public void clickNavbarNavWithDropdownLinksTest() {
        navbarNav.navbarComplexLinks.listPages.get(4)
                .is()
                .displayed();
        navbarNav.navbarComplexLinks.selectMenu(ITEM_BRAND);
        newWindowTitleCheck(NAVBAR_BOOTSTRAP);
        navbarNav.navbarComplexLinks.selectMenu(ITEM_NAV);
        newWindowTitleCheck(NAVBAR_BOOTSTRAP);
        navbarNav.navbarComplexLinks.selectMenu(ITEM_FORMS);
        newWindowTitleCheck(NAVBAR_BOOTSTRAP);
    }

    @Test
    public void isDisabledItemNavWithDisabled() {
        navbarNav.navLinks1.listPages.get(4)
                .is()
                .displayed();
        navbarNav.navLinks1.listPages.get(4)
                .is()
                .disabled();
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
