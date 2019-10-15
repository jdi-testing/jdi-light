package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multipleAddonLower;
import static io.github.com.pages.BootstrapPage.multipleAddonUpper;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class InputGroupMultipleAddonsTests extends TestsInit{

    private String text = "Some text for tests";
    private String partOfText = "text ";
    private String emptyText = "";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        multipleAddonUpper.textField.clear();
        multipleAddonLower.textField.clear();
    }

    @DataProvider(name = "InputGroupMultipleAddonsLabels")
    public static Object[][] labels() {
        String firstLabel = "$";
        String secondLabel = "0.00";
        return new Object[][]{
                {multipleAddonUpper.firstLabel, firstLabel},
                {multipleAddonUpper.secondLabel, secondLabel},
                {multipleAddonLower.firstLabel, firstLabel},
                {multipleAddonLower.secondLabel, secondLabel}
        };
    }

    @DataProvider(name = "InputGroupMultipleAddonsTextFields")
    public static Object[][] textFields() {
        return new Object[][]{
                {multipleAddonUpper.textField},
                {multipleAddonLower.textField}
        };
    }

    @Test(dataProvider = "InputGroupMultipleAddonsLabels")
    public void getTextTestFromLabel(Label multipleAddonsLabel, String labelValue) {
        assertEquals(multipleAddonsLabel.getText(), labelValue);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsLabels")
    public void getValueTest(Label multipleAddonsLabel, String labelValue) {
        assertEquals(multipleAddonsLabel.getValue(), labelValue);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsLabels")
    public void assertTextFromValueTest(Label multipleAddonsLabel, String labelValue) {
        multipleAddonsLabel.is().text(labelValue);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsLabels")
    public void isValidationTest(Label multipleAddonsLabel, String labelValue) {
        multipleAddonsLabel.is()
                .displayed()
                .core()
                .hasClass("input-group-text")
                .text(labelValue);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void getTextTest(TextField textField) {
        textField.setText(text);
        assertEquals(textField.getText(), text);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void getValueTest(TextField textField) {
        textField.setText(text);
        assertEquals(textField.getValue(), text);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void sendKeysTest(TextField textField) {
        textField.sendKeys(text);
        textField.assertThat().text(is(text));
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void inputTest(TextField textField) {
        textField.input(text);
        textField.assertThat().text(is(text));
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void textFieldTests(TextField textField) {
        textField.setText(text);
        textField.is().text(text);
        textField.is().text(containsString(partOfText));
        textField.clear();
        textField.is().text(emptyText);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void placeholderTest(TextField textField) {
        assertEquals(textField.placeholder(), emptyText);
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void focusTest(TextField textField) {
        textField.focus();
    }

    @Test(dataProvider = "InputGroupMultipleAddonsTextFields")
    public void isValidationTest(TextField textField) {
        textField.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .text(is(emptyText));
    }
}
