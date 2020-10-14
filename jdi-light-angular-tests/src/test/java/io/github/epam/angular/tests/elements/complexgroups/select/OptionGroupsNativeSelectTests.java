package io.github.epam.angular.tests.elements.complexgroups.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.optionGroupsNativeSelect;

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
        optionGroupsNativeSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        optionGroupsNativeSelect.has().listEnabled(Arrays.asList(VOLVO, SAAB, MERCEDES, AUDI));
    }

    @Test
    public void checkAvailableOptions() {
        optionGroupsNativeSelect.assertThat().values(MERCEDES).values(VOLVO, SAAB, AUDI, MERCEDES);
    }

    @Test
    public void checkAvailableGroups() {
        optionGroupsNativeSelect.is().groups(Arrays.asList(SWEDISH_CARS, GERMAN_CARS));
    }

    @Test
    public void checkAvailableOptionsAndGroups() {
        optionGroupsNativeSelect.assertThat().groupsAndOptions(getCarsMap());
    }
}
