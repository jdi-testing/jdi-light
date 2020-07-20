package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.multipleSelect;
import static org.hamcrest.Matchers.hasItems;

public class MultipleSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        multipleSelect.show();
    }

    @Test
    public void checkLabelValue() {
        multipleSelect.label().has().value("Toppings");
    }

    @Test
    public void checkSingleOptionCanBeSelectedById() {
        multipleSelect.multipleSelect(3);
        multipleSelect.is().selected(ONION);
        multipleSelect.multipleSelect(3);
    }

    @Test
    public void checkThreeOptionsCanBeSelectedByName() {
        multipleSelect.multipleSelect(EXTRA_CHEESE, PEPPERONI, TOMATO);
        multipleSelect.is().selected(EXTRA_CHEESE + ", " + PEPPERONI + ", " + TOMATO);
        multipleSelect.multipleSelect(EXTRA_CHEESE, PEPPERONI, TOMATO);
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
}
