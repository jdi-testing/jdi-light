package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.epam.jdi.light.ui.bootstrap.BootstrapUtils.isElementInViewPort;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multipleInputs;
import static io.github.com.pages.BootstrapPage.redButton;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static io.github.epam.test.data.InputDataHelper.inputDataAsMap;
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
        multipleInputs.is().text(value, 1);

        int index = 2;
        String name = inputData.get(index);
        multipleInputs.setValue(name, index);
        multipleInputs.is().text(name, index);

        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.clear(locator);
        multipleInputs.setValue(surname, locator);
        multipleInputs.is().text(surname, locator);
    }

    @Test
    public void setAllValuesTest() {
        multipleInputs.clearAll();
        multipleInputs.setAllValues(inputDataList);
        multipleInputs.is().texts(inputDataList);
    }

    @Test
    public void sendKeysTest() {
        multipleInputs.clearAll();

        String value = inputData.get(1);
        multipleInputs.sendKeys(value);
        multipleInputs.is().text(value, 1);

        multipleInputs.clearAll();
        int index = 2;
        String name = inputData.get(index);
        multipleInputs.sendKeys(index, name);
        multipleInputs.is().text(name, index);

        multipleInputs.clearAll();
        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.sendKeys(locator, surname);
        multipleInputs.is().text(surname, locator);
    }

    @Test
    public void sendAllKeysTest() {
        multipleInputs.clearAll();

        multipleInputs.sendKeysAll(inputDataList);
        multipleInputs.is().texts(inputDataList);
    }

    @Test
    public void clearTest() {
        String value = inputData.get(1);
        multipleInputs.sendKeys(value);
        multipleInputs.clear();
        multipleInputs.is().text("", 1);

        int index = 2;
        String name = inputData.get(index);
        multipleInputs.sendKeys(index, name);
        multipleInputs.clear(index);
        multipleInputs.is().text("", index);

        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.sendKeys(locator, surname);
        multipleInputs.clear(locator);
        multipleInputs.is().text("", locator);
    }

    @Test
    public void clearAllTest() {
        multipleInputs.sendKeysAll(inputDataList);
        multipleInputs.clearAll();

        for(int i = 1; i <= inputDataList.size(); i++) {
            multipleInputs.is().text("", i);
        }
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
        multipleInputs.is().text(value, 1);

        multipleInputs.clearAll();
        int index = 2;
        String name = inputData.get(index);
        multipleInputs.input(name, index);
        multipleInputs.is().text(name, index);

        multipleInputs.clearAll();
        String locator = "#mi-i-2";
        String surname = inputData.get(2);
        multipleInputs.input(surname, locator);
        multipleInputs.is().text(surname, locator);
    }

    @Test
    public void inputAllTest() {
        multipleInputs.clearAll();

        multipleInputs.inputAll(inputDataList);
        multipleInputs.is().texts(inputDataList);
    }

    @Test
    public void isValidationTest() {
        multipleInputs.is().enabled();

        int index = 1;
        String value = inputData.get(index);
        multipleInputs.is().text(value, index);

        String locator = "#mi-i-2";
        multipleInputs.is().text(inputData.get(2), locator);

        multipleInputs.is().text(inputData.get(1));
        multipleInputs.is().text(containsString("1"), index);
        multipleInputs.is().text(containsString("2"), locator);

        multipleInputs.is().texts(inputDataList);

        multipleInputs.is().placeholder("", index);
        multipleInputs.is().placeholder("", locator);
        multipleInputs.is().placeholder("");
        multipleInputs.is().placeholder(containsString(""), index);
        multipleInputs.is().placeholder(containsString(""), locator);
        multipleInputs.is().placeholder(containsString(""));

        List<String> inputPlaceholders = new ArrayList<String>(Collections.nCopies(inputData.size(), ""));
        multipleInputs.is().placeholders(inputPlaceholders);

        multipleInputs.is().value(value, index);
        multipleInputs.is().value(inputData.get(2), locator);
        multipleInputs.is().value(inputData.get(1));
        multipleInputs.is().value(containsString("1"), index);
        multipleInputs.is().value(containsString("2"), locator);
        multipleInputs.is().value(containsString("1"), index);

        multipleInputs.is().values(inputDataList);
    }

    @Test
    public void assertThatTest() {
        int index = 1;
        String value = inputData.get(index);
        multipleInputs.assertThat().text(value, index);

        String locator = "#mi-i-2";
        multipleInputs.assertThat().text(inputData.get(2), locator);

        multipleInputs.assertThat().text(inputData.get(1));
        multipleInputs.assertThat().text(containsString("1"), index);
        multipleInputs.assertThat().text(containsString("2"), locator);

        multipleInputs.assertThat().texts(inputDataList);

        multipleInputs.assertThat().placeholder("", index);
        multipleInputs.assertThat().placeholder("", locator);
        multipleInputs.assertThat().placeholder("");
        multipleInputs.assertThat().placeholder(containsString(""), index);
        multipleInputs.assertThat().placeholder(containsString(""), locator);
        multipleInputs.assertThat().placeholder(containsString(""));

        List<String> inputPlaceholders = new ArrayList<String>(Collections.nCopies(inputData.size(), ""));
        multipleInputs.assertThat().placeholders(inputPlaceholders);

        multipleInputs.assertThat().value(value, index);
        multipleInputs.assertThat().value(inputData.get(2), locator);
        multipleInputs.assertThat().value(inputData.get(1));
        multipleInputs.assertThat().value(containsString("1"), index);
        multipleInputs.assertThat().value(containsString("2"), locator);
        multipleInputs.assertThat().value(containsString("1"), index);

        multipleInputs.assertThat().values(inputDataList);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(multipleInputs);
    }

    @Test
    public void labelTest() {
        assertEquals(multipleInputs.label().getText(), "First and last name");
        multipleInputs.label().is().text("First and last name");
        multipleInputs.label().is().text(containsString("name"));
    }
}
