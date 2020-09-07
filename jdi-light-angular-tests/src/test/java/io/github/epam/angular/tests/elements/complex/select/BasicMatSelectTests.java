package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static io.github.com.pages.sections.SelectSection.basicMatSelect;
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
    public void checkSelectorExpanded() {
        basicMatSelect.expand();
        basicMatSelect.is().expanded();
    }

    @Test
    public void checkSelectorCollapsed() {
        basicMatSelect.collapse();
        basicMatSelect.is().collapsed();
    }

    @Test
    public void checkOptionCanBeSelectedByIndex() {
        basicMatSelect.select(2);
        basicMatSelect.is().selected(PIZZA);
    }

    @Test
    public void checkListDisabledOptions() {
        basicMatSelect.has().listDisabled(Collections.EMPTY_LIST);
    }

    @Test
    public void checkListEnabledOptions() {
        basicMatSelect.has().listEnabled(Arrays.asList(STEAK, PIZZA, TACOS));
    }

    @Test
    public void checkAvailableOptions() {
        basicMatSelect.assertThat().values(hasItems(TACOS, STEAK, PIZZA));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (basicMatSelect.isExpanded()) {
            basicMatSelect.collapse();
        }
    }
}
