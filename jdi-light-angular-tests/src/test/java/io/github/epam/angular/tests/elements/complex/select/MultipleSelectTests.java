package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.multipleSelect;
import static org.hamcrest.Matchers.hasItems;

public class MultipleSelectTests extends TestsSelectBase {
    private String[] multiOptions = new String[3];
    private int[] multiSelect = new int[1];

    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.open();
        multipleSelect.show();
    }

    @Test
    public void checkLabelValue() {
        multipleSelect.label().has().value("Toppings");
    }

    @Test
    public void checkSingleOptionCanBeSelectedById() {
        multiSelect[0] = 3;
        multipleSelect.multipleSelect(multiSelect);
        multipleSelect.is().selected(ONION);
    }

    @Test
    public void checkThreeOptionsCanBeSelectedByName() {
        multiOptions[0] = EXTRA_CHEESE;
        multiOptions[1] = PEPPERONI;
        multiOptions[2] = TOMATO;
        multipleSelect.multipleSelect(multiOptions);
        multipleSelect.is().selected(multiOptions[0] + ", " + multiOptions[1] + ", " + multiOptions[2]);
    }

    @Test
    public void checkListDisabledOptions() {
        multipleSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        multipleSelect.has().listEnabled(Arrays.asList(EXTRA_CHEESE, MUSHROOM, ONION, PEPPERONI, SAUSAGE, TOMATO));
    }

    @Test
    public void checkAvailableOptions() {
        multipleSelect.assertThat().values(hasItems(PEPPERONI, SAUSAGE, TOMATO, ONION, EXTRA_CHEESE, MUSHROOM));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (multiSelect[0] != 0) {
            multipleSelect.multipleSelect(multiSelect);
            multiSelect[0] = 0;
        }
        if (multiOptions[0] != null) {
            multipleSelect.multipleSelect(multiOptions);
            multiOptions[0] = null;
            multiOptions[1] = null;
            multiOptions[2] = null;
        }
    }
}
