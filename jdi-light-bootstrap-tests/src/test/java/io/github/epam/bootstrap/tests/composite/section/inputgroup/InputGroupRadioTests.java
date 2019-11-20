package io.github.epam.bootstrap.tests.composite.section.inputgroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupRadio;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Iulia Litvin on 13.09.2019
 * Email: iulia.litwin@yandex.ru
 */

public class InputGroupRadioTests extends TestsInit {

    private String text = "Input text";
    private String new_text = "New text";
    private String added_text = " add some text";
    private String part_of_text = "text";
    private String placeholder_text = "";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void selectNumTest() {
        inputGroupRadio.radio.select(1);
        assertEquals(inputGroupRadio.radio.selected(), "");
    }

    @Test
    public void getSizeRadioButtons() {
        inputGroupRadio.radio.is().size(1);
    }

    @Test
    public void getTextInputTest() {
        inputGroupRadio.input.setText(text);
        inputGroupRadio.input.assertThat().text(is(text));
    }

    @Test
    public void sendKeysTest() {
        inputGroupRadio.input.sendKeys(added_text);
        inputGroupRadio.input.assertThat().text(is(new_text + added_text));
    }

    @Test
    public void inputTest() {
        inputGroupRadio.input.input(new_text);
        inputGroupRadio.input.assertThat().text(is(new_text));
    }

    @Test
    public void clearTest() {
        inputGroupRadio.input.clear();
        inputGroupRadio.input.assertThat().text(is(""));
    }

    @Test
    public void placeholderTest() {
        assertEquals(inputGroupRadio.input.placeholder(), placeholder_text);
    }

    @Test
    public void focusTest() {
        inputGroupRadio.input.focus();
    }

    @Test
    public void isValidationInputTest() {
        inputGroupRadio.input.is().enabled();
        inputGroupRadio.input.is().text(is(new_text));
        inputGroupRadio.input.is().text(containsString(part_of_text));
    }

    @Test
    public void isValidationRadioTest() {
        inputGroupRadio.radio.is().enabled();
        inputGroupRadio.radio.is().displayed();
    }

}
