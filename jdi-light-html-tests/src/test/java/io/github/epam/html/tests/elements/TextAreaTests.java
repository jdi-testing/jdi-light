package io.github.epam.html.tests.elements;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class TextAreaTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
        textArea.clear();
    }
    String text = "TextArea";

    @Test
    public void getTextTest() {
        textArea.setText(text);
        assertEquals(textArea.getText(), text);
    }

    @Test
    public void getValueTest() {
        textArea.setText(text);
        assertEquals(textArea.getValue(), text);
    }

    @Test
    public void sendKeysTest() {
        textArea.setText(text);
        textArea.sendKeys("Test");
        assertEquals(textArea.getValue(), text+"Test");
    }
    @Test
    public void inputTest() {
        textArea.setText(text);
        textArea.input("New text");
        assertEquals(textArea.getText(), "New text");
    }

    @Test
    public void setValueTest() {
        textArea.setText(text);
        textArea.setValue("New text");
        assertEquals(textArea.getText(), "New text");
    }

    @Test
    public void clearTest() {
        textArea.setText(text);
        textArea.clear();
        assertEquals(textArea.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(textArea.placeholder(), "Input huge text");
    }

    @Test
    public void disabledTest() {
        disabledTextArea.setText(text);
        assertEquals(textArea.getText(), "");
    }

    @Test
    public void focusTest() {
        textArea.focus();
    }

    @Test
    public void isValidationTest() {
        textArea.setText(text);
        textArea.is().text(is(text));
        textArea.is().text(containsString("Area"));
    }

    @Test
    public void labelTest() {
        assertEquals(textArea.labelText(), "Text example:");
        textArea.label().is().text(containsString("example"));
    }

    @Test
    public void assertValidationTest() {
        textArea.setText(text);
        textArea.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(name);
    }
}
