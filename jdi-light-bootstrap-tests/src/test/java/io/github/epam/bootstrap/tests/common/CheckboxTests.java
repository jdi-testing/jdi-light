package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.customCheckbox;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.CoreMatchers.is;

public class CheckboxTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        customCheckbox.hover();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(customCheckbox);
    }

    @Test
    public void isValidationTests() {
        customCheckbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("custom-control custom-checkbox")
                .tag(is("div"));
        customCheckbox.label()
                .is()
                .core()
                .hasClass("custom-control-label")
                .text(is("Check this custom checkbox"))
                .tag(is("label"));
    }

    @Test
    public void clickableTests() {
        customCheckbox.check();
        customCheckbox.is().selected();
        customCheckbox.uncheck();
        customCheckbox.is().deselected();
        customCheckbox.click();
        customCheckbox.is().selected();
        customCheckbox.click();
        customCheckbox.is().deselected();
        customCheckbox.check("true");
        customCheckbox.is().selected();
        customCheckbox.check("");
        customCheckbox.is().deselected();
    }

}
