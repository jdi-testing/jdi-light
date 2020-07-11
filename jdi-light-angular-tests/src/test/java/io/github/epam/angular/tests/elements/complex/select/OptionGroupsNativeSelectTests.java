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
        List<String> expectedEnabled = Arrays.asList(VOLVO, SAAB, MERCEDES, AUDI);
        optionGroupsNativeSelect.has().listEnabled(expectedEnabled);
    }

    @Test
    public void checkAvailableOptions() {
        optionGroupsNativeSelect.assertThat().values(hasItem(MERCEDES)).values(hasItems(VOLVO, SAAB, AUDI, MERCEDES));
    }

    @Test
    public void checkAvailableGroups() {
        List<String> expectedGroups = Arrays.asList("Swedish Cars", "German Cars");
        optionGroupsNativeSelect.is().groups(expectedGroups);
    }

    @Test
    public void checkAvailableOptionsAndGroups() {
        Map<String, List<String>> expectedResult = new LinkedHashMap<>();
        List<String> expectedGroups = Arrays.asList("Swedish Cars", "German Cars");
        expectedResult.put(expectedGroups.get(0), Arrays.asList(VOLVO, SAAB));
        expectedResult.put(expectedGroups.get(1), Arrays.asList(MERCEDES, AUDI));
        optionGroupsNativeSelect.assertThat().groupsAndOptions(expectedResult);
    }
}
