package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledName;
import static io.github.com.pages.HtmlElementsPage.name;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class TextFieldTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        name.setText(text);
    }
    String text = "TextField";

    @Test
    public void getTextTest() {
        assertEquals(name.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(name.getValue(), text);
    }

    @Test
    public void sendKeysTest() {
        name.sendKeys("Test");
        assertEquals(name.getValue(), text+"Test");
    }

    @Test
    public void inputTest() {
        name.input("New text");
        assertEquals(name.getText(), "New text");
    }

    @Test
    public void clearTest() {
        name.clear();
        assertEquals(name.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(name.placeholder(), "Input name");
    }

    @Test
    public void disabledTest() {
        try {
            disabledName.sendKeys(text);
        } catch (Exception ignore) {}
        assertEquals(disabledName.getText(), "");

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
