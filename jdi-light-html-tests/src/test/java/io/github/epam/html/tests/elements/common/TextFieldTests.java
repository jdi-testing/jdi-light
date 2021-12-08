package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class TextFieldTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        yourName.setText(defaultText);
    }
    String defaultText = "TextField";

    @Test
    public void getTextTest() {
        assertEquals(yourName.getText(), defaultText);
    }

    @Test
    public void getValueTest() {
        assertEquals(yourName.getValue(), defaultText);
    }

    @Test
    public void sendKeysTest() {
        yourName.sendKeys("Test");
        assertEquals(yourName.getValue(), defaultText +"Test");
    }

    @Test
    public void sendNullValueTest() {
        String value = yourName.getText();
        yourName.sendKeys(null);
        yourName.has().text(value);
    }

    @Test
    public void setFirstNullValueTest() {
        yourName.sendKeys(null, "Test");
        yourName.has().text(defaultText);
    }

    @Test
    public void inputTest() {
        yourName.input("New text");
        assertEquals(yourName.getText(), "New text");
    }

    @Test
    public void inputNullValueTest() {
        String value = yourName.getText();
        yourName.input(null);
        yourName.has().text(value);
    }

    @Test
    public void clearTest() {
        yourName.clear();
        assertEquals(yourName.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(yourName.placeholder(), "Input name");
    }

    //TODO Performance issue
    @Test
    public void disabledTest() {
        try {
            disabledName.sendKeys(defaultText);
        } catch (Exception ignore) {}
        assertEquals(disabledName.getText(), "");
    }

    @Test
    public void focusTest() {
        yourName.focus();
    }

    @Test
    public void isValidationTest() {
        yourName.is().enabled();
        yourName.is().text(is(defaultText));
        yourName.is().text(containsString("Field"));
        disabledName.is().disabled();
    }

    @Test
    public void labelTest() {
        assertEquals(yourName.label().getText(), "Your name:");
        yourName.label().is().text(containsString("Your"));
        disabledName.label().is().text(equalToIgnoringCase("Surname:"));
    }

    @Test
    public void assertValidationTest() {
        yourName.assertThat().text(is(defaultText));
    }

    final String symbols = "`!@#//$%ˆ*()_+˜@[\"№;:?-=]{}'/\\|<>";

    @Test
    public void inputSymbolsTest() {
        yourName.input(symbols);
        assertEquals(yourName.getText(), symbols);
    }
    @Test
    public void setTextSymbolsTest() {
        yourName.setText(symbols);
        assertEquals(yourName.getText(), symbols);
    }

    @Test
    public void setTextAsNullTest() {
        String value = yourName.getText();
        yourName.setText(null);
        yourName.has().text(value);
    }

    @Test
    public void setNullValueTest() {
        String value = yourName.getText();
        yourName.setValue(null);
        yourName.has().text(value);
    }

    @Test
    public void sendKeysSymbolsTest() {
        yourName.clear();
        yourName.sendKeys(symbols);
        assertEquals(yourName.getText(), symbols);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(yourName);
    }
}
