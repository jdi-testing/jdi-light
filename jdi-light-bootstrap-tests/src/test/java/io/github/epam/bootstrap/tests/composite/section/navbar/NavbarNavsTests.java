package io.github.epam.bootstrap.tests.composite.section.navbar;


import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.com.pages.BootstrapPage.progressWithLabels;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class NavbarNavsTests extends TestsInit {

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
        progressWithLabels.is().displayed();
        progressWithLabels.is().enabled();
        assertThat(progressWithLabels.core().css("font-size"), is("14px"));
        progressWithLabels.assertThat().displayed()
                .core()
                .css("font-size", is("14px"))
                .cssClass("navbar")
                .tag(is("nav"));
    }

}
