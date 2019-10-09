package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

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
        baseValidation(navbarExpandedConteiner);
        baseValidation(navbarCentredContainer.navbarBrand);
        baseValidation(navbarExpandedConteiner.navbarBrand);
    }

    @Test
    public void isValidationTest() {
        navbarCentredContainer.is().displayed();
        navbarCentredContainer.is().enabled();
        navbarCentredContainer.assertThat().displayed()
                .core()
                .css("font-size", is("20px"))
                .cssClass("container")
                .tag(is("div"));

        navbarExpandedConteiner.is().displayed();
        navbarExpandedConteiner.is().enabled();
        navbarExpandedConteiner.assertThat().displayed()
                .core()
                .css("font-size", is("20px"))
                .cssClass("container")
                .tag(is("div"));
    }

    @Test
    public void getNameNavbarContainerBrandTest() {
        navbarCentredContainer.navbarBrand.is().text(textNavbarCentredContainer);
        navbarExpandedConteiner.navbarBrand.is().text(textNavbarExpandedConteiner);
    }

    @Test
    public void clickNavbarCentredContainerLinksTest() {
        navbarNavWithDropdown.navbarBrand.click();
        assertThat(WindowsManager.windowsCount(), is(2));
        WindowsManager.switchToWindow(2);
        assertThat(getUrl(), is(url));
        WindowsManager.closeWindow();
    }


    //проверить разные бутстрап классы навса

}
