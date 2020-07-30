package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.customTriggerTextSelect;

public class CustomTriggerTextSelectTests extends TestsSelectBase {
    @BeforeMethod()
    public void before() {
        customTriggerTextSelect.show();
    }

    @Test
    public void checkLabelValue() {
        customTriggerTextSelect.label().has().value("Toppings");
    }

    @Test
    public void checkOptionCanBeSelectedByName() {
        customTriggerTextSelect.multipleSelect(SAUSAGE);
        customTriggerTextSelect.is().selected(SAUSAGE);
        customTriggerTextSelect.multipleSelect(SAUSAGE);
    }

    @Test
    public void checkAllOptionsCanBeSelectedById() {
        customTriggerTextSelect.multipleSelect(1, 2, 3, 4, 5, 6);
        customTriggerTextSelect.verify().selected(EXTRA_CHEESE + " (+5 others)");
        customTriggerTextSelect.multipleSelect(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void checkListDisabledOptions() {
        customTriggerTextSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        customTriggerTextSelect.has()
                .listEnabled(Arrays.asList(EXTRA_CHEESE, MUSHROOM, ONION, PEPPERONI, SAUSAGE, TOMATO));
    }

    @Test
    public void checkAvailableOptions() {
        customTriggerTextSelect.assertThat().values(EXTRA_CHEESE, PEPPERONI, SAUSAGE, MUSHROOM, ONION, TOMATO);
    }
}
