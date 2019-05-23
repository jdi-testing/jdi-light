package io.github.epam.html.tests.suspend;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.disabledName;
import static io.github.com.pages.HtmlElementsPage.name;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageTextFieldTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.shouldBeOpened();
        name.setText(text);
    }
    String text = "TextField";

    @Test
    public void disabledTest() {
        TIMEOUT.set(2);
        try {
            disabledName.sendKeys(text);
        } catch (Exception ignore) {}
        assertEquals(disabledName.getText(), "");
        TIMEOUT.set(2);
        try {
            disabledName.input(text);
        } catch (Exception ignore) {}
        assertEquals(disabledName.getText(), "");
    }

    @Test
    public void focusTest() {
        name.focus();
    }

    @Test
    public void isValidationTest() {
        name.is().enabled();
        name.is().text(is(text));
        name.is().text(containsString("Field"));
        disabledName.is().disabled();
    }

    @Test
    public void labelTest() {
        assertEquals(name.label().getText(), "Your name:");
        name.label().is().text(containsString("Your"));
        disabledName.label().is().text(equalToIgnoringCase("Surname:"));
    }

    @Test
    public void assertValidationTest() {
        name.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(name);
    }
}
