package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarContainers;
import static org.hamcrest.Matchers.is;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
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
        baseValidation(navbarContainers.navLinks1);
        baseValidation(navbarContainers.navbarComplexLinks);
        baseValidation(navbarContainers.navLinks1.brand);
        baseValidation(navbarContainers.navbarComplexLinks.brand);
    }

    @Test
    public void isValidationTest() {
        navbarContainers.navLinks1.is().displayed();
        navbarContainers.navLinks1.is().enabled();
        navbarContainers.navLinks1.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .cssClass("container")
                .tag(is("div"));

        navbarContainers.navbarComplexLinks.is().displayed();
        navbarContainers.navbarComplexLinks.is().enabled();
        navbarContainers.navbarComplexLinks.assertThat().displayed()
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
        navbarContainers.navLinks1.brand.is().text(textNavbarCentredContainer);
        navbarContainers.navbarComplexLinks.brand.is().text(textNavbarExpandedConteiner);
    }

    @Test
    public void clickNavbarCentredContainerLinksTest() {
        navbarContainers.navLinks1.brand.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(url));
        WindowsManager.closeWindow();
    }

    @Test
    public void clickNavbarExpandedContainerLinksTest() {
        navbarContainers.navbarComplexLinks.brand.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(url));
        WindowsManager.closeWindow();
    }
}
