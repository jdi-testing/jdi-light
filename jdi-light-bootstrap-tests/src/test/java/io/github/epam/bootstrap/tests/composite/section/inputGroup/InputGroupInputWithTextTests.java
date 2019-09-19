package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupUsername;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Iulia Litvin on 13.09.2019
 * Email: iulia.litwin@yandex.ru
 */

public class InputGroupInputWithTextTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        inputGroupUsername.input.setText(text);
    }

    private String text = "Input text";

    @Test
    public void checkClass() {
        inputGroupUsername.assertThat()
                .core().hasClass("flex-nowrap");

    }

    @Test
    public void getTextInputTest() {
        assertEquals(inputGroupUsername.input.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(inputGroupUsername.input.getValue(), text);
    }

    @Test
    public void sendKeysTest() {
        inputGroupUsername.input.sendKeys("Test");
        assertEquals(inputGroupUsername.input.getValue(), text + "Test");
    }

    @Test
    public void inputTest() {
        inputGroupUsername.input.input("New text");
        assertEquals(inputGroupUsername.input.getText(), "New text");
    }

    @Test
    public void clearTest() {
        inputGroupUsername.input.clear();
        assertEquals(inputGroupUsername.input.getText(), "");
    }

    @Test
    public void placeholderTest() {
        assertEquals(inputGroupUsername.input.placeholder(), "Username");
    }

    @Test
    public void focusTest() {
        inputGroupUsername.input.focus();
    }

    @Test
    public void isValidationInputTest() {
        inputGroupUsername.input.is().enabled();
        inputGroupUsername.input.is().text(is(text));
        inputGroupUsername.input.is().text(containsString("text"));
    }

    @Test
    public void assertValidationInputTest() {
        inputGroupUsername.input.assertThat().text(is(text));
    }

   private final String symbols = "`!@#";

    @Test
    public void inputSymbolsTest() {
        inputGroupUsername.input.input(symbols);
        assertEquals(inputGroupUsername.input.getText(), symbols);
    }

    @Test
    public void setTextSymbolsTest() {
        inputGroupUsername.input.setText(symbols);
        assertEquals(inputGroupUsername.input.getText(), symbols);
    }

    @Test
    public void sendKeysSymbolsTest() {
        inputGroupUsername.input.clear();
        inputGroupUsername.input.sendKeys(symbols);
        assertEquals(inputGroupUsername.input.getText(), symbols);
    }

    @Test
    public void baseValidationInputTest() {
        baseValidation(inputGroupUsername.input);
    }

    private String addon_text = "@";

    @Test
    public void getTextTest() {
        assertEquals(inputGroupUsername.text.getText(), addon_text);
    }

    @Test
    public void assertValidationTextTest() {
        inputGroupUsername.text.assertThat().text(is(addon_text));
    }

    @Test
    public void isValidationTextTest() {
        inputGroupUsername.text.is().enabled();
        inputGroupUsername.text.is().text(is(addon_text));
        inputGroupUsername.text.is().text(containsString("@"));
    }

    @Test
    public void baseValidationTextTest() {
        baseValidation(inputGroupUsername.text);
    }
}
