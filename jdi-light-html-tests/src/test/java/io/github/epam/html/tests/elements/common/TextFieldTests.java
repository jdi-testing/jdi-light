package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.common.NullUserInputValueException;
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
        yourName.setText(text);
    }
    String text = "TextField";

    @Test
    public void getTextTest() {
        assertEquals(yourName.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(yourName.getValue(), text);
    }

    @Test
    public void sendKeysTest() {
        yourName.sendKeys("Test");
        assertEquals(yourName.getValue(), text+"Test");
    }

    @Test(expectedExceptions = {NullUserInputValueException.class})
    public void passingNull_ToSendKeys_ThrowsException() {
        yourName.sendKeys(null);
    }

    @Test(expectedExceptions = {NullUserInputValueException.class})
    public void passingNull_AsOneOfTheArguments_ToSendKeys_ThrowsException() {
        yourName.sendKeys(null, "Test");
    }

    @Test
    public void inputTest() {
        yourName.input("New text");
        assertEquals(yourName.getText(), "New text");
    }

    @Test(expectedExceptions = {NullUserInputValueException.class})
    public void passingNull_ToInput_ThrowsException() {
        yourName.input(null);
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
            disabledName.sendKeys(text);
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
        yourName.is().text(is(text));
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
        yourName.assertThat().text(is(text));
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

    @Test(expectedExceptions = {NullUserInputValueException.class})
    public void passingNull_ToSetText_ThrowsException() {
        yourName.setText(null);
    }

    @Test(expectedExceptions = {NullUserInputValueException.class})
    public void passingNull_ToSetValue_ThrowsException() {
        yourName.setValue(null);
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
