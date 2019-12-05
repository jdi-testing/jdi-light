package io.github.epam.bootstrap.tests.composite.section.form;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsFormsPage;
import static io.github.com.pages.BootstrapFormsPage.lastLogEntry;
import static io.github.com.pages.BootstrapFormsPage.supportMessageForm;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.SupportMessages.EXAMPLE_MESSAGE;
import static io.github.epam.test.data.SupportMessages.TEMPLATE_MESSAGE;
import static org.hamcrest.Matchers.containsString;

public class SimpleFormTests extends TestsInit {

    private final String logLineSubmit = "support-button-submit:button clicked";
    private final String logLineClear = " support-button-clear:button clicked";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsFormsPage.shouldBeOpened();
    }

    @Test
    public void submitButtonTest() {
        supportMessageForm.supportButtonSubmit.click();
        lastLogEntry.has().text(containsString(logLineSubmit));
    }

    @Test
    public void clearButtonTest() {
        supportMessageForm.supportButtonClear.click();
        lastLogEntry.has().text(containsString(logLineClear));
    }

    @Test
    public void submitFormTest() {
        setDefaultValues();
        supportMessageForm.submit(EXAMPLE_MESSAGE);
        lastLogEntry.has().text(containsString(logLineSubmit));
        supportMessageForm.check(EXAMPLE_MESSAGE);
    }

    @Test
    public void fillFormTest() {
        setDefaultValues();
        supportMessageForm.fill(EXAMPLE_MESSAGE);
        supportMessageForm.supportEmail.has().text(EXAMPLE_MESSAGE.supportEmail);
        supportMessageForm.supportMessage.has().text(EXAMPLE_MESSAGE.supportMessage);
        supportMessageForm.check(EXAMPLE_MESSAGE);
    }

    @Test
    public void clearFormTest() {
        setDefaultValues();
        supportMessageForm.clear(EXAMPLE_MESSAGE);
        lastLogEntry.has().text(containsString(logLineClear));
        supportMessageForm.check(TEMPLATE_MESSAGE);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(supportMessageForm);
    }

    private void setDefaultValues() {
        supportMessageForm.supportEmail.setValue(TEMPLATE_MESSAGE.supportEmail);
        supportMessageForm.supportMessage.setValue(TEMPLATE_MESSAGE.supportMessage);
    }
}
