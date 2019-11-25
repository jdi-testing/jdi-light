package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupCheckBox;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Iulia Litvin on 13.09.2019
 * Email: iulia.litwin@yandex.ru
 */

public class InputGroupCheckboxesTests extends TestsInit {

    private String text = "Input text";
    private String new_text = "New text";
    private String added_text=" add some text";
    private String part_of_text = "text";
    private String placeholder_text = "";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void clickCheckboxTest() {
        inputGroupCheckBox.checkbox.check();
        inputGroupCheckBox.checkbox.is().selected();
        inputGroupCheckBox.checkbox.uncheck();
        inputGroupCheckBox.checkbox.is().deselected();
        inputGroupCheckBox.checkbox.click();
        inputGroupCheckBox.checkbox.is().selected();
        inputGroupCheckBox.checkbox.click();
        inputGroupCheckBox.checkbox.is().deselected();
    }

    @Test
    public void getTextInputTest() {
        inputGroupCheckBox.input.setText(text);
        inputGroupCheckBox.input.assertThat().text(is(text));
    }

    @Test
    public void isValidationTests() {
        inputGroupCheckBox.checkbox
                .is()
                .displayed()
                .enabled()
                .core()
                .hasClass("input-group-text")
                .tag(is("div"));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(inputGroupCheckBox.checkbox);
    }

    @Test
    public void sendKeysTest() {
        inputGroupCheckBox.input.sendKeys(added_text);
        inputGroupCheckBox.input.assertThat().text(is(new_text + added_text));
    }

    @Test
    public void inputTest() {
        inputGroupCheckBox.input.input(new_text);
        inputGroupCheckBox.input.assertThat().text(is(new_text));
    }

    @Test
    public void clearTest() {
        inputGroupCheckBox.input.clear();
        inputGroupCheckBox.input.assertThat().text(is(""));
    }

    @Test
    public void placeholderTest() {
        assertEquals(inputGroupCheckBox.input.placeholder(), placeholder_text);
    }

    @Test
    public void focusTest() {
        inputGroupCheckBox.input.focus();
    }

    @Test
    public void isValidationInputTest() {
        inputGroupCheckBox.input.is().enabled();
        inputGroupCheckBox.input.is().text(is(new_text));
        inputGroupCheckBox.input.is().text(containsString(part_of_text));
    }

}
