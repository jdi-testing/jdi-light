package io.github.epam.bootstrap.tests.composite.section;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkboxesDefault;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class CheckboxesDefaultTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        checkboxesDefault.hover();
    }

    @Test
    public void isValidationTests() {
        checkboxesDefault.checkboxOne
                .is()
                .displayed()
                .enabled()
                .core()
                .attr("type", "checkbox")
                .hasClass("form-check-input");
        checkboxesDefault.checkboxOne.label()
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-check-label")
                .text(is("Default checkbox"));
        checkboxesDefault.checkboxTwo
                .is()
                .displayed()
                .disabled()
                .core()
                .hasClass("form-check-input");
        checkboxesDefault.checkboxTwo.label()
                .is()
                .displayed()
                .core()
                .hasClass("form-check-label")
                .text(is("Disabled checkbox"));
    }

    @Test
    public void clickableTests() {
        checkboxesDefault.checkboxOne.check();
        checkboxesDefault.checkboxOne.is().selected();
        checkboxesDefault.checkboxOne.uncheck();
        checkboxesDefault.checkboxOne.is().deselected();
    }
}
