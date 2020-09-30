package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledName;
import static io.github.com.pages.HtmlElementsPage.firstName;
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
        firstName.setText(text);
    }
    String text = "TextField";

    @Test
    public void getTextTest() {
        assertEquals(firstName.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(firstName.getValue(), text);
    }

    @Test
    public void sendKeysTest() {
        firstName.sendKeys("Test");
        assertEquals(firstName.getValue(), text+"Test");
    }

    @Test
    public void inputTest() {
        firstName.input("New text");
        assertEquals(firstName.getText(), "New text");
    }

    @Test
    public void clearTest() {
        firstName.clear();
        assertEquals(firstName.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(firstName.placeholder(), "Input name");
    }

    //TODO Performance issue
    @Test
    public void disabledTest() {
        try {
            disabledName.sendKeys(text);
        } catch (Exception ignore) {}
        assertEquals(disabledName.getText(), "");
    }

    @Test
    public void focusTest() {
        firstName.focus();
    }

    @Test
    public void isValidationTest() {
        firstName.is().enabled();
        firstName.is().text(is(text));
        firstName.is().text(containsString("Field"));
        disabledName.is().disabled();
    }

    @Test
    public void labelTest() {
        assertEquals(firstName.label().getText(), "Your name:");
        firstName.label().is().text(containsString("Your"));
        disabledName.label().is().text(equalToIgnoringCase("Surname:"));
    }

    @Test
    public void assertValidationTest() {
        firstName.assertThat().text(is(text));
    }

    final String symbols = "`!@#//$%ˆ*()_+˜@[\"№;:?-=]{}'/\\|<>";

    @Test
    public void inputSymbolsTest() {
        firstName.input(symbols);
        assertEquals(firstName.getText(), symbols);
    }
    @Test
    public void setTextSymbolsTest() {
        firstName.setText(symbols);
        assertEquals(firstName.getText(), symbols);
    }
    @Test
    public void sendKeysSymbolsTest() {
        firstName.clear();
        firstName.sendKeys(symbols);
        assertEquals(firstName.getText(), symbols);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(firstName);
    }
}
