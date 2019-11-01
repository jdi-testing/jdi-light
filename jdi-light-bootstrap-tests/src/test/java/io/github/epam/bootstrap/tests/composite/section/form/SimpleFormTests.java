package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsFormsPage;
import static io.github.com.pages.BootstrapFormsPage.lastLogEntry;
import static io.github.com.pages.BootstrapFormsPage.supportMessageForm;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.SupportMessages.EXAMPLE_MESSAGE;
import static org.hamcrest.Matchers.containsString;

public class SimpleFormTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsFormsPage.shouldBeOpened();
    }

    @Test
    public void fillAndVerifyForm() {
        supportMessageForm.fill(EXAMPLE_MESSAGE);
        supportMessageForm.verify(EXAMPLE_MESSAGE);
    }

    @Test
    public void submitForm() {
        supportMessageForm.submit(EXAMPLE_MESSAGE);
        lastLogEntry.has().text(containsString("support-button-submit:button clicked"));
        supportMessageForm.check(EXAMPLE_MESSAGE);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(supportMessageForm);
    }
}
