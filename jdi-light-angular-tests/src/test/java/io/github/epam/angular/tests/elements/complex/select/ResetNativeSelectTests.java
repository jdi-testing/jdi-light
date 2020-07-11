package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.sections.SelectSection.resetNativeSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;

public class ResetNativeSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        resetNativeSelect.show();
    }

    @Test
    public void checkLabelValue() {
        resetNativeSelect.label().has().value("Select your car");
    }

    @Test
    public void checkResetOptionCanBeSelectedById() {
        resetNativeSelect.select(1);
        resetNativeSelect.is().selected(matchesPattern("\\W*"));
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByName() {
        resetNativeSelect.select(AUDI);
        resetNativeSelect.is().selected(AUDI);
    }

    @Test
    public void checkListDisabledOptions() {
        resetNativeSelect.has().emptyDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        List<String> expectedEnabled = Arrays.asList("", VOLVO, SAAB, MERCEDES, AUDI);
        resetNativeSelect.has().listEnabled(expectedEnabled);
    }

    @Test
    public void checkAvailableOptions() {
        resetNativeSelect.assertThat().values(hasItem(MERCEDES)).values(hasItems(SAAB, AUDI, VOLVO));
    }
}
