package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledName;
import static io.github.com.pages.HtmlElementsPage.name;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class TextFieldTests extends TestsInit {

    private String text = "TextField";
    private final String symbols = "`!@#";//$%ˆ*()_+˜@[\"№;:?-=]{}'/\\|<>";


    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        name.setText(text);
    }

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

    //TODO Performance issue
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
    public void inputSymbolsTest() {
        name.input(symbols);
        assertEquals(name.getText(), symbols);
    }
    @Test
    public void setTextSymbolsTest() {
        name.setText(symbols);
        assertEquals(name.getText(), symbols);
    }
    @Test
    public void sendKeysSymbolsTest() {
        name.clear();
        name.sendKeys(symbols);
        assertEquals(name.getText(), symbols);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(name);
    }
}
