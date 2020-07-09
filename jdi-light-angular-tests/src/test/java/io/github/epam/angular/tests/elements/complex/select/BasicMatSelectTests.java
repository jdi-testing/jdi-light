package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.basicMatSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class BasicMatSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        basicMatSelect.show();
    }

    @Test
    public void checkLabelValue() {
        basicMatSelect.label().has().value("Favorite food");
    }

    @Test
    public void checkOptionCanBeSelectedByIndex() {
        basicMatSelect.select(2);
        basicMatSelect.is().selected(PIZZA);
    }

    @Test
    public void checkAvailableOptions() {
        basicMatSelect.assertThat().values(hasItem(STEAK)).values(hasItems(TACOS, STEAK, PIZZA));
    }
}
