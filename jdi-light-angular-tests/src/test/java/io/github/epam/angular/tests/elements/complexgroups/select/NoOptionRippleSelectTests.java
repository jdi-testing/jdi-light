package io.github.epam.angular.tests.elements.complexgroups.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.noOptionRippleSelect;
import static org.hamcrest.Matchers.hasItems;

public class NoOptionRippleSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        noOptionRippleSelect.show();
    }

    @Test
    public void checkLabelValue() {
        noOptionRippleSelect.label().has().value("Select an option");
    }

    @Test
    public void checkOptionCanBeSelectedByName() {
        noOptionRippleSelect.select(OPTION_1);
        noOptionRippleSelect.is().selected(OPTION_1);
    }

    @Test
    public void checkListDisabledOptions() {
        noOptionRippleSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        noOptionRippleSelect.has().listEnabled(Arrays.asList(OPTION_1, OPTION_2, OPTION_3));
    }

    @Test
    public void checkAvailableOptions() {
        noOptionRippleSelect.assertThat().values(hasItems(OPTION_1, OPTION_2, OPTION_3));
    }
}
