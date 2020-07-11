package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.github.com.pages.sections.SelectSection.optionGroupsNativeSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class OptionGroupsNativeSelectTests extends TestsSelectBase {
    private static final String SWEDISH_CARS = "Swedish Cars";
    private static final String GERMAN_CARS = "German Cars";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        optionGroupsNativeSelect.show();
    }

    @Test
    public void checkLabelValue() {
        optionGroupsNativeSelect.label().has().value("Cars");
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByName() {
        optionGroupsNativeSelect.select(SAAB);
        optionGroupsNativeSelect.is().selected(SAAB);
    }

    @Test
    public void checkListDisabledOptions() {
        optionGroupsNativeSelect.has().emptyDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        optionGroupsNativeSelect.has().listEnabled(Arrays.asList(VOLVO, SAAB, MERCEDES, AUDI));
    }

    @Test
    public void checkAvailableOptions() {
        optionGroupsNativeSelect.assertThat().values(hasItem(MERCEDES)).values(hasItems(VOLVO, SAAB, AUDI, MERCEDES));
    }

    @Test
    public void checkAvailableGroups() {
        List<String> expectedGroups = Arrays.asList(SWEDISH_CARS, GERMAN_CARS);
        optionGroupsNativeSelect.is().groups(expectedGroups);
    }

    @Test
    public void checkAvailableOptionsAndGroups() {
        Map<String, List<String>> expectedResult = new LinkedHashMap<>();
        expectedResult.put(SWEDISH_CARS, Arrays.asList(VOLVO, SAAB));
        expectedResult.put(GERMAN_CARS, Arrays.asList(MERCEDES, AUDI));
        optionGroupsNativeSelect.assertThat().groupsAndOptions(expectedResult);
    }
}
