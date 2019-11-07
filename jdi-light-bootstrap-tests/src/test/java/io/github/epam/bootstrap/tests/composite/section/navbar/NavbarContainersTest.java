package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarNav;
import static org.hamcrest.Matchers.is;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;

public class NavbarContainersTest extends TestsInit {

    private String textNavbarCentredContainer = "Navbar";
    private String textNavbarExpandedConteiner = "Navbar";
    private String url = "https://getbootstrap.com/docs/4.3/components/navbar/#containers";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        bsPage.refresh();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(navbarNav.navLinks1);
        baseValidation(navbarNav.navbarComplexLinks);
        baseValidation(navbarNav.navLinks1.brand);
        baseValidation(navbarNav.navbarComplexLinks.brand);
    }

    @Test
    public void isValidationTest() {
        navbarNav.navLinks1.is().displayed();
        navbarNav.navLinks1.is().enabled();
        navbarNav.navLinks1.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .cssClass("container")
                .tag(is("div"));

        navbarNav.navbarComplexLinks.is().displayed();
        navbarNav.navbarComplexLinks.is().enabled();
        navbarNav.navbarComplexLinks.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .hasClass("navbar")
                .hasClass("navbar-expand-lg")
                .hasClass("navbar-light")
                .hasClass("bg-light")
                .tag(is("nav"));
    }

    @Test
    public void getNameNavbarContainerBrandTest() {
        navbarNav.navLinks1.brand.is().text(textNavbarCentredContainer);
        navbarNav.navbarComplexLinks.brand.is().text(textNavbarExpandedConteiner);
    }

    @Test
    public void clickNavbarCentredContainerLinksTest() {
        navbarNav.navLinks1.brand.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(url));
        WindowsManager.closeWindow();
    }

    @Test
    public void clickNavbarExpandedContainerLinksTest() {
        navbarNav.navbarComplexLinks.brand.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(url));
        WindowsManager.closeWindow();
    }
}
