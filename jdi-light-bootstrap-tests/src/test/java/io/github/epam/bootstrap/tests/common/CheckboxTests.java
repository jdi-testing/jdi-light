package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.checkbox;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class CheckboxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        // customCheckbox.hover();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(checkbox);
    }

    @Test
    public void isValidationTests() {
        checkbox
                .is()
                .displayed()
                .enabled()
                .core();
    }

    @Test
    public void clickableTests() {
        checkbox.check();
        checkbox.is().selected();
        checkbox.uncheck();
        checkbox.is().deselected();
        checkbox.click();
        checkbox.is().selected();
        checkbox.click();
        checkbox.is().deselected();
        checkbox.check("true");
        checkbox.is().selected();
        checkbox.check("");
        checkbox.is().deselected();
    }

}
