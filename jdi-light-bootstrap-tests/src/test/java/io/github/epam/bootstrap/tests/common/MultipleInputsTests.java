package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static com.epam.jdi.light.ui.bootstrap.elements.BootstrapUtils.isElementInViewPort;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multipleInputs;
import static io.github.com.pages.BootstrapPage.redButton;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.InputData.inputDataAsList;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MultipleInputsTests extends TestsInit {

    private static List<String> inputData;

    @BeforeClass
    public void beforeClass() {
        inputData = inputDataAsList(2);
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        multipleInputs.setAllValues(inputData);
    }

    @Test
    public void getTextTest() {
        int index = 1;

        String name = multipleInputs.getText(index);
        assertEquals(name, inputData.get(--index));

        String surname = multipleInputs.getText("#mi-i-2");
        assertEquals(surname, inputData.get(1));

        String text = multipleInputs.getText();
        assertEquals(text, inputData.get(0));
    }

    @Test
    public void getTextAllTest() {
        assertEquals(multipleInputs.getAllTexts(), inputData);
    }

    @Test
    public void getValueTest() {
        int index = 1;

        String name = multipleInputs.getValue(index);
        assertEquals(name, inputData.get(--index));

        String surname = multipleInputs.getValue("#mi-i-2");
        assertEquals(surname, inputData.get(1));

        String value = multipleInputs.getValue();
        assertEquals(value, inputData.get(0));
    }

    @Test
    public void getValueAllTest() {
        assertEquals(multipleInputs.getAllValues(), inputData);
    }

    @Test
    public void setValueTest() {
        multipleInputs.clearAll();

        String value = inputData.get(0);
        multipleInputs.setValue(value);
        assertEquals(multipleInputs.getValue(1), value);

        int index = 2;
        String name = inputData.get(index - 1);
        multipleInputs.setValue(name, index);
        assertEquals(multipleInputs.getValue(index), name);

        String locator = "#mi-i-2";
        String surname = inputData.get(1);
        multipleInputs.clear(locator);
        multipleInputs.setValue(surname, locator);
        assertEquals(multipleInputs.getValue(locator), surname);
    }

    @Test
    public void setAllValuesTest() {
        multipleInputs.clearAll();
        multipleInputs.setAllValues(inputData);
        assertEquals(multipleInputs.getAllValues(), inputData);
    }

    @Test
    public void sendKeysTest() {
        multipleInputs.clearAll();

        String value = inputData.get(0);
        multipleInputs.sendKeys(value);
        assertEquals(multipleInputs.getText(), value);

        multipleInputs.clearAll();
        int index = 1;
        String name = inputData.get(index);
        multipleInputs.sendKeys(index, name);
        assertEquals(multipleInputs.getText(index), name);

        multipleInputs.clearAll();
        String locator = "#mi-i-2";
        String surname = inputData.get(1);
        multipleInputs.sendKeys(locator, surname);
        assertEquals(multipleInputs.getText(locator), surname);
    }

    @Test
    public void sendAllKeysTest() {
        multipleInputs.clearAll();

        multipleInputs.sendKeysAll(inputData);
        assertEquals(multipleInputs.getAllTexts(), inputData);
    }

    @Test
    public void clearTest() {
        String value = inputData.get(0);
        multipleInputs.sendKeys(value);
        multipleInputs.clear();
        assertEquals(multipleInputs.getText(), "");

        int index = 1;
        String name = inputData.get(index);
        multipleInputs.sendKeys(index, name);
        multipleInputs.clear(index);
        assertEquals(multipleInputs.getText(index), "");

        String locator = "#mi-i-2";
        String surname = inputData.get(1);
        multipleInputs.sendKeys(locator, surname);
        multipleInputs.clear(locator);
        assertEquals(multipleInputs.getText(locator), "");
    }

    @Test
    public void clearAllTest() {
        multipleInputs.sendKeysAll(inputData);
        multipleInputs.clearAll();

        multipleInputs.getAllTexts().forEach(t -> assertEquals(t, ""));
    }

    @Test
    public void focusTest() {
        multipleInputs.focus();
        assertTrue(isElementInViewPort(multipleInputs.core()));
        redButton.hover();

        int index = 2;
        multipleInputs.focus(index);
        assertTrue(isElementInViewPort(multipleInputs.core()));
        redButton.hover();

        String locator = "#mi-i-1";
        multipleInputs.focus(locator);
        assertTrue(isElementInViewPort(multipleInputs.core()));
    }

    @Test
    public void placeholderTest() {
        assertEquals(multipleInputs.placeholder(), "");
        assertEquals(multipleInputs.placeholder(1), "");
        assertEquals(multipleInputs.placeholder("#mi-i-2"), "");
    }

    @Test
    public void placeholderAllTest() {
        multipleInputs.placeholderAll().forEach(p -> assertEquals(p, ""));
    }

    @Test
    public void inputTest() {
        multipleInputs.clearAll();

        String value = inputData.get(0);
        multipleInputs.input(value);
        assertEquals(multipleInputs.getText(), value);

        multipleInputs.clearAll();
        int index = 1;
        String name = inputData.get(index);
        multipleInputs.input(name, index);
        assertEquals(multipleInputs.getText(index), name);

        multipleInputs.clearAll();
        String locator = "#mi-i-2";
        String surname = inputData.get(1);
        multipleInputs.input(surname, locator);
        assertEquals(multipleInputs.getText(locator), surname);
    }

    @Test
    public void inputAllTest() {
        multipleInputs.clearAll();

        multipleInputs.inputAll(inputData);
        assertEquals(multipleInputs.getAllTexts(), inputData);
    }

    @Test
    public void isValidationTest() {
        multipleInputs.is().enabled();

        int index = 1;
        multipleInputs.is().text(inputData.get(index - 1), index);

        String locator = "#mi-i-2";
        multipleInputs.is().text(inputData.get(1), locator);

        multipleInputs.is().text(inputData.get(0));
        multipleInputs.is().text(inputData);
        multipleInputs.is().text(containsString("0"), index);
        multipleInputs.is().text(containsString("1"), locator);
    }

    @Test
    public void assertThatTest() {
        int index = 1;
        multipleInputs.assertThat().text(inputData.get(index - 1), index);

        String locator = "#mi-i-2";
        multipleInputs.assertThat().text(inputData.get(1), locator);

        multipleInputs.assertThat().text(inputData.get(0));
        multipleInputs.assertThat().text(inputData);
        multipleInputs.assertThat().text(containsString("0"), index);
        multipleInputs.assertThat().text(containsString("1"), locator);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(multipleInputs);
    }

    @Test
    public void labelTest() {
        assertEquals(multipleInputs.label().getText(), "First and last name");
        multipleInputs.label().is().text(containsString("name"));
    }
}
