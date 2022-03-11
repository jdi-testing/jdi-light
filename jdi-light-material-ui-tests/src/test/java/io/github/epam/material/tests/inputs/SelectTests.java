package io.github.epam.material.tests.inputs;

import static io.github.com.StaticSite.selectPage;
import static io.github.com.pages.inputs.SelectPage.controlledOpenSelect;
import static io.github.com.pages.inputs.SelectPage.disabledSelect;
import static io.github.com.pages.inputs.SelectPage.groupedSelect;
import static io.github.com.pages.inputs.SelectPage.multipleSelect;
import static io.github.com.pages.inputs.SelectPage.nativeHelperSelect;
import static io.github.com.pages.inputs.SelectPage.openSelectButton;
import static io.github.com.pages.inputs.SelectPage.simpleSelect;

import io.github.epam.TestsInit;
import io.github.epam.test.data.SelectDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestsInit {

    @BeforeMethod
    public void before() {
        selectPage.open();
        selectPage.isOpened();
    }

    // TODO: Add check for placeholders, labels, helper texts, errors
    @Test
    public void simpleSelectTest() {
        String value = "Hansen";

        simpleSelect.expand();
        simpleSelect.is().expanded();
        simpleSelect.close();
        simpleSelect.is().collapsed();
        simpleSelect.select(value);
        simpleSelect.has().selected(value);
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

    @Test(dataProvider = "controlledOpenSelectTestData", dataProviderClass = SelectDataProvider.class)
    public void controlledOpenSelectTest(String value) {
        openSelectButton.click();
        controlledOpenSelect.show();
        controlledOpenSelect.is().expanded();

        controlledOpenSelect.select(value);
        controlledOpenSelect.has().selected(value);

    }

    @Test
    public void nativeHelperSelectTest() {
        String value = "Ten";

        nativeHelperSelect.expand();
        nativeHelperSelect.is().expanded();
        nativeHelperSelect.close();
        nativeHelperSelect.is().collapsed();
        nativeHelperSelect.select(value);
        nativeHelperSelect.has().selected(value);
    }
}
