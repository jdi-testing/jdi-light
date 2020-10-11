package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SelectSection.customTriggerTextSelect;

public class CustomTriggerTextSelectTests extends TestsSelectBase {
    private String[] multiOptions = new String[1];
    private int[] multiSelect = new int[6];

    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.open();
        customTriggerTextSelect.show();
    }

    @Test
    public void checkLabelValue() {
        customTriggerTextSelect.label().has().value("Toppings");
    }

    @Test
    public void checkOptionCanBeSelectedByName() {
        multiOptions[0] = SAUSAGE;
        customTriggerTextSelect.multipleSelect(multiOptions);
        customTriggerTextSelect.is().selected(multiOptions[0]);
    }

    @Test
    public void checkAllOptionsCanBeSelectedById() {
        multiSelect = new int[] {1, 2, 3, 4, 5, 6};
        customTriggerTextSelect.multipleSelect(multiSelect);
        customTriggerTextSelect.verify().selected(EXTRA_CHEESE + " (+5 others)");
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
