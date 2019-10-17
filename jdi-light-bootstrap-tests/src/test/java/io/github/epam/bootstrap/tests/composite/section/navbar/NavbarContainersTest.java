package io.github.epam.bootstrap.tests.composite.section.navbar;

import com.epam.jdi.light.elements.common.WindowsManager;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.getUrl;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.navbarCentredContainer;
import static io.github.com.pages.BootstrapPage.navbarExpandedContainer;
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
        baseValidation(navbarCentredContainer);
        baseValidation(navbarExpandedContainer);
        baseValidation(navbarCentredContainer.navbarBrand);
        baseValidation(navbarExpandedContainer.navbarBrand);
    }

    @Test
    public void isValidationTest() {
        navbarCentredContainer.is().displayed();
        navbarCentredContainer.is().enabled();
        navbarCentredContainer.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .cssClass("container")
                .tag(is("div"));

        navbarExpandedContainer.is().displayed();
        navbarExpandedContainer.is().enabled();
        navbarExpandedContainer.assertThat().displayed()
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
        navbarCentredContainer.navbarBrand.is().text(textNavbarCentredContainer);
        navbarExpandedContainer.navbarBrand.is().text(textNavbarExpandedConteiner);
    }

    @Test
    public void clickNavbarCentredContainerLinksTest() {
        navbarCentredContainer.navbarBrand.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(url));
        WindowsManager.closeWindow();
    }

    @Test
    public void clickNavbarExpandedContainerLinksTest() {
        navbarExpandedContainer.navbarBrand.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(url));
        WindowsManager.closeWindow();
    }
}
