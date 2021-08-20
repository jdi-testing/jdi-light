package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.selectPage;
import static io.github.com.pages.inputs.SelectPage.controlledOpenSelect;
import static io.github.com.pages.inputs.SelectPage.disabledSelect;
import static io.github.com.pages.inputs.SelectPage.groupedSelect;
import static io.github.com.pages.inputs.SelectPage.multipleSelect;
import static io.github.com.pages.inputs.SelectPage.openSelectButton;
import static io.github.com.pages.inputs.SelectPage.simpleSelect;

/**
 * To see an example of Select web element please visit
 * https://material-ui.com/components/selects/
 */

public class SelectTests extends TestsInit {

    @BeforeMethod
    public void before() {
        selectPage.open();
    }

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
        String[] values =
                {"Category 1", "Option 1", "Option 2", "Category 2", "Option 3", "Option 4"};

        groupedSelect.expand();
        groupedSelect.has().values(values);
        groupedSelect.select(values[0]);
        groupedSelect.has().selected("​");
        groupedSelect.select(values[1]);
        groupedSelect.has().selected(values[1]);
    }

    @Test
    public void controlledOpenSelectTest() {
        String[] values = {"Ten", "Twenty"};
        openSelectButton.click();
        controlledOpenSelect.select(values[0]);
        controlledOpenSelect.has().selected(values[0]);

        controlledOpenSelect.select(values[1]);
        controlledOpenSelect.has().selected(values[1]);
    }
}
