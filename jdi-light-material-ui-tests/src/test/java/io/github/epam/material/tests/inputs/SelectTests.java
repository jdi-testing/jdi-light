package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.selectPage;
import static io.github.com.pages.inputs.SelectPage.controlledOpenSelect;
import static io.github.com.pages.inputs.SelectPage.disableLabel;
import static io.github.com.pages.inputs.SelectPage.disabledSelect;
import static io.github.com.pages.inputs.SelectPage.errorLabel;
import static io.github.com.pages.inputs.SelectPage.groupedSelect;
import static io.github.com.pages.inputs.SelectPage.helperLabel;
import static io.github.com.pages.inputs.SelectPage.labelPlaceholderSelect;
import static io.github.com.pages.inputs.SelectPage.multipleSelect;
import static io.github.com.pages.inputs.SelectPage.nativeDisableSelect;
import static io.github.com.pages.inputs.SelectPage.nativeErrorSelect;
import static io.github.com.pages.inputs.SelectPage.nativeHelperSelect;
import static io.github.com.pages.inputs.SelectPage.openSelectButton;
import static io.github.com.pages.inputs.SelectPage.placeholderLabel;
import static io.github.com.pages.inputs.SelectPage.simpleSelect;

import io.github.epam.TestsInit;
import io.github.epam.test.data.SelectDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestsInit {

    private static final String DISABLED = "Disabled";
    private static final String ERROR = "Error";
    private static final String PLACEHOLDER = "Label + placeholder";
    private static final String HELPER = "Some important helper text";
    private static final String SIMPLE_VALUE = "Hansen";
    private static final String NAME_VALUE = "Kevin";

    @BeforeMethod
    public void before() {
        selectPage.open();
        selectPage.isOpened();
    }

    @Test
    public void simpleSelectTest() {
        simpleSelect.expand();
        simpleSelect.is().expanded();
        simpleSelect.close();
        simpleSelect.is().collapsed();
        simpleSelect.select(SIMPLE_VALUE);
        simpleSelect.has().selected(SIMPLE_VALUE);
    }

    @Test
    public void disabledSelectTest() {
        disabledSelect.is().disabled();
        disabledSelect.expand();
        disabledSelect.is().collapsed();
    }

    @Test
    public void multipleSelectTest() {
        String[] values = {"Oliver", "Omar", "Kelly"};
        String separator = ", ";
        String result = String.join(separator, values);

        multipleSelect.select(values);
        multipleSelect.has().selected(result);
    }

    @Test
    public void groupingSelectTest() {
        String[] values = {"Category 1", "Option 1", "Option 2", "Category 2", "Option 3", "Option 4"};

        groupedSelect.expand();
        groupedSelect.has().values(values);
        groupedSelect.select(values[0]);
        groupedSelect.has().selected("​");
        groupedSelect.select(values[1]);
        groupedSelect.has().selected(values[1]);
    }

    @Test(dataProvider = "ageSelectTestData", dataProviderClass = SelectDataProvider.class)
    public void controlledOpenSelectTest(String value) {
        openSelectButton.click();
        controlledOpenSelect.show();
        controlledOpenSelect.is().expanded();

        controlledOpenSelect.select(value);
        controlledOpenSelect.has().selected(value);
    }

    @Test(dataProvider = "ageSelectTestData", dataProviderClass = SelectDataProvider.class)
    public void nativeHelperSelectTest(String value) {
        nativeHelperSelect.select(value);
        nativeHelperSelect.has().selected(value);

        helperLabel.has().text(HELPER);
    }

    @Test(dataProvider = "ageSelectTestData", dataProviderClass = SelectDataProvider.class)
    public void labelPlaceholderSelectTest(String value) {
        labelPlaceholderSelect.select(value);
        labelPlaceholderSelect.has().selected(value);

        placeholderLabel.has().text(PLACEHOLDER);
    }

    @Test
    public void nativeErrorSelectTest() {
        nativeErrorSelect.select(NAME_VALUE);
        nativeErrorSelect.has().selected(NAME_VALUE);

        errorLabel.has().text(ERROR);
    }

    @Test
    public void nativeDisabledSelectTest() {
        nativeDisableSelect.is().disabled();
        disableLabel.has().text(DISABLED);
    }
}
