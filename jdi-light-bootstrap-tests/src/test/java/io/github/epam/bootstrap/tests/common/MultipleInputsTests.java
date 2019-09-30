package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.ui.bootstrap.elements.BootstrapUtils.isElementInViewPort;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multipleInputs;
import static io.github.com.pages.BootstrapPage.redButton;
import static io.github.epam.bootstrap.tests.BaseValidations.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.InputData.inputDataAsMap;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MultipleInputsTests extends TestsInit {

    private static Map<Integer, String> inputData;
    private static List<String> inputDataList;

    @BeforeClass
    public void beforeClass() {
        inputData = inputDataAsMap(2);
        inputDataList = new ArrayList<String>(inputData.values());
    }

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        multipleInputs.setAllValues(inputDataList);
    }

    @Test
    public void getTextTest() {
        int index = 1;

        String name = multipleInputs.getText(index);
        assertEquals(name, inputData.get(index));

        String surname = multipleInputs.getText("#mi-i-2");
        assertEquals(surname, inputData.get(2));

        String text = multipleInputs.getText();
        assertEquals(text, inputData.get(1));
    }

    @Test
    public void getTextAllTest() {
        assertEquals(multipleInputs.getAllTexts(), inputDataList);
    }

    @Test
    public void getValueTest() {
        int index = 1;

        String name = multipleInputs.getValue(index);
        assertEquals(name, inputData.get(index));

        String surname = multipleInputs.getValue("#mi-i-2");
        assertEquals(surname, inputData.get(2));

        String value = multipleInputs.getValue();
        assertEquals(value, inputData.get(1));
    }

    @Test
    public void getValueAllTest() {
        assertEquals(multipleInputs.getAllValues(), inputDataList);
    }

    @Test
    public void setValueTest() {
        multipleInputs.clearAll();

        String value = inputData.get(1);
        multipleInputs.setValue(value);
        assertEquals(multipleInputs.getValue(1), value);

        int index = 2;
        String name = inputData.get(index);
        multipleInputs.setValue(name, index);
        assertEquals(multipleInputs.getValue(index), name);

        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.clear(locator);
        multipleInputs.setValue(surname, locator);
        assertEquals(multipleInputs.getValue(locator), surname);
    }

    @Test
    public void setAllValuesTest() {
        multipleInputs.clearAll();
        multipleInputs.setAllValues(inputDataList);
        assertEquals(multipleInputs.getAllValues(), inputDataList);
    }

    @Test
    public void sendKeysTest() {
        multipleInputs.clearAll();

        String value = inputData.get(1);
        multipleInputs.sendKeys(value);
        assertEquals(multipleInputs.getText(), value);

        multipleInputs.clearAll();
        int index = 2;
        String name = inputData.get(index);
        multipleInputs.sendKeys(index, name);
        assertEquals(multipleInputs.getText(index), name);

        multipleInputs.clearAll();
        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.sendKeys(locator, surname);
        assertEquals(multipleInputs.getText(locator), surname);
    }

    @Test
    public void sendAllKeysTest() {
        multipleInputs.clearAll();

        multipleInputs.sendKeysAll(inputDataList);
        assertEquals(multipleInputs.getAllTexts(), inputDataList);
    }

    @Test
    public void clearTest() {
        String value = inputData.get(1);
        multipleInputs.sendKeys(value);
        multipleInputs.clear();
        assertEquals(multipleInputs.getText(), "");

        int index = 2;
        String name = inputData.get(index);
        multipleInputs.sendKeys(index, name);
        multipleInputs.clear(index);
        assertEquals(multipleInputs.getText(index), "");

        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.sendKeys(locator, surname);
        multipleInputs.clear(locator);
        assertEquals(multipleInputs.getText(locator), "");
    }

    @Test
    public void clearAllTest() {
        multipleInputs.sendKeysAll(inputDataList);
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

        String value = inputData.get(1);
        multipleInputs.input(value);
        assertEquals(multipleInputs.getText(), value);

        multipleInputs.clearAll();
        int index = 2;
        String name = inputData.get(index);
        multipleInputs.input(name, index);
        assertEquals(multipleInputs.getText(index), name);

        multipleInputs.clearAll();
        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.input(surname, locator);
        assertEquals(multipleInputs.getText(locator), surname);
    }

    @Test
    public void inputAllTest() {
        multipleInputs.clearAll();

        multipleInputs.inputAll(inputDataList);
        assertEquals(multipleInputs.getAllTexts(), inputDataList);
    }

    @Test
    public void isValidationTest() {
        multipleInputs.is().enabled();

        int index = 1;
        multipleInputs.is().text(inputData.get(index), index);

        String locator = "#mi-i-2";
        multipleInputs.is().text(inputData.get(2), locator);

        multipleInputs.is().text(inputData.get(1));
        multipleInputs.is().text(inputDataList);
        multipleInputs.is().text(containsString("1"), index);
        multipleInputs.is().text(containsString("2"), locator);
    }

    @Test
    public void assertThatTest() {
        int index = 1;
        multipleInputs.assertThat().text(inputData.get(index), index);

        String locator = "#mi-i-2";
        multipleInputs.assertThat().text(inputData.get(2), locator);

        multipleInputs.assertThat().text(inputData.get(1));
        multipleInputs.assertThat().text(inputDataList);
        multipleInputs.assertThat().text(containsString("1"), index);
        multipleInputs.assertThat().text(containsString("2"), locator);
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
