package io.github.epam.html.tests.elements;

import io.github.epam.TestsInit;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.alert;
import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class TextFieldTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
        name.clear();
    }
    String text = "TextField";

    @Test
    public void getTextTest() {
        name.setText(text);
        assertEquals(name.getText(), text);
    }

    @Test
    public void getValueTest() {
        name.setText(text);
        assertEquals(name.getValue(), text);
    }

    @Test
    public void sendKeysTest() {
        name.setText(text);
        name.sendKeys("Test");
        assertEquals(name.getValue(), text+"Test");
    }
    @Test
    public void inputTest() {
        name.setText(text);
        name.input("New text");
        assertEquals(name.getText(), "New text");
    }

    @Test
    public void setValueTest() {
        name.setText(text);
        name.setValue("New text");
        assertEquals(name.getText(), "New text");
    }

    @Test
    public void clearTest() {
        name.setText(text);
        name.clear();
        assertEquals(name.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(name.placeholder(), "Input name");
    }

    @Test
    public void disabledTest() {
        disabledName.setText(text);
        assertEquals(name.getText(), "");
    }

    @Test
    public void focusTest() {
        name.focus();
    }

    @Test
    public void isValidationTest() {
        name.setText(text);
        name.is().text(is(text));
        name.is().text(containsString("Field"));
    }

    @Test
    public void labelTest() {
        assertEquals(name.label().getText(), "Your name:");
        name.label().is().text(containsString("Your"));
        disabledName.label().is().text(equalToIgnoringCase("Surname:"));
    }

    @Test
    public void assertValidationTest() {
        name.setText(text);
        name.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(name);
    }
}
