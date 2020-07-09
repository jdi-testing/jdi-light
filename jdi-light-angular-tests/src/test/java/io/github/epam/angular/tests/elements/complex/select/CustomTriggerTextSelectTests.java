package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.customTriggerTextSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

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
    public void checkAvailableOptions() {
        customTriggerTextSelect.assertThat().values(hasItem(ONION)).values(hasItems(PEPPERONI, SAUSAGE, MUSHROOM));
    }
}
