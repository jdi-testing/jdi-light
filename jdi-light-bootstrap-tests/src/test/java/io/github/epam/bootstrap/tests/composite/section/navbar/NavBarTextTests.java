package io.github.epam.bootstrap.tests.composite.section.navbar;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarText;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;
import static org.testng.Assert.assertEquals;

public class NavBarTextTests extends TestsInit {
    private static final String JS_SCROLL_TO_ELEMENT = "scrollIntoView(true);";
    private static final String inlineElement = "Navbar text with an inline element";
    private static final String brandName = "Navbar w/ text";
    private static final String navbarBootstrap = "Navbar · Bootstrap";
    private static final String linkName1 = "Home\n(current)";
    private static final String linkName2 = "HTML 5";
    private static final String linkName3 = "Bootstrap";
    private static final String page1 = "Home Page";
    private static final String page2 = linkName2;
    private static final String page3 = linkName3;

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        $(navbarText.core().getLocator()).jsExecute(JS_SCROLL_TO_ELEMENT);
    }

    @Test
    public void verifySimpleNavbarTextTest() {
        navbarText.simpleText
                .is()
                .text(is(inlineElement));
    }

    @Test
    public void verifyComplexNavbarTextTest() {
        navbarText.complexNavbar.simpleText
                .is()
                .text(is(inlineElement));
    }

    @Test
    public void verifyComplexNavbarBrandTest() {
        navbarText.complexNavbar.brand
                .is()
                .text(is(brandName));
        navbarText.complexNavbar.brand.click();
        newWindowTitleCheck(navbarBootstrap);
    }

    @Test
    public void verifyComplexNavbarHomeTest() {
        navbarText.complexNavbar.listPages.get(1)
                .is()
                .text(is(linkName1));
        navbarText.complexNavbar.listPages.get(1).click();
        newWindowTitleCheck(page1);
        navbarText.complexNavbar.listPages.get(2)
                .is()
                .text(is(linkName2));
        navbarText.complexNavbar.listPages.get(2).click();
        newWindowTitleCheck(page2);
        navbarText.complexNavbar.listPages.get(3)
                .is()
                .text(is(linkName3));
        navbarText.complexNavbar.listPages.get(3).click();
        newWindowTitleCheck(page3);
    }

    private void newWindowTitleCheck(String pageTitle) {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
