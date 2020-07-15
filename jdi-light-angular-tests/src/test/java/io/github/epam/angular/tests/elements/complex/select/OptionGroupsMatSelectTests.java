package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.github.com.pages.sections.SelectSection.optionGroupsMatSelect;
import static org.hamcrest.Matchers.matchesPattern;

public class OptionGroupsMatSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        optionGroupsMatSelect.show();
    }

    @Test
    public void checkLabelValue() {
        optionGroupsMatSelect.label().has().value("Pokemon");
    }

    @Test
    public void checkNoneOptionCanBeSelectedById() {
        optionGroupsMatSelect.select(1);
        optionGroupsMatSelect.is().selected(matchesPattern("\\W+"));
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByName() {
        optionGroupsMatSelect.select("Oddish");
        optionGroupsMatSelect.is().selected("Oddish");
    }

    @Test
    public void checkDisabledOptionCannotBeSelectedByName() {
        String preselectedValue = optionGroupsMatSelect.selected();
        optionGroupsMatSelect.multipleSelect("Flareon");
        optionGroupsMatSelect.is().selected(preselectedValue);
    }

    @Test
    public void checkListDisabledOptions() {
        optionGroupsMatSelect.has().listDisabled("Charmander", "Vulpix", "Flareon");
    }

    @Test
    public void checkListEnabledOptions() {
        optionGroupsMatSelect.has()
                .listEnabled("Bulbasaur", "Oddish", "Bellsprout", "Squirtle", "Psyduck", "Horsea", "Mew", "Mewtwo");
    }

    @Test
    public void checkAvailableOptions() {
        optionGroupsMatSelect.assertThat().values("Bellsprout", "Squirtle", "Vulpix", "Mew", "Horsea", "Charmander");
    }

    @Test
    public void checkAvailableGroups() {
        optionGroupsMatSelect.has().groups(Arrays.asList("Grass", "Water", "Fire", "Psychic"));
    }

    @Test
    public void checkAvailableOptionsAndGroups() {
        Map<String, List<String>> expectedResult = new LinkedHashMap<>();
        expectedResult.put("Grass", Arrays.asList("Bulbasaur", "Oddish", "Bellsprout"));
        expectedResult.put("Water", Arrays.asList("Squirtle", "Psyduck", "Horsea"));
        expectedResult.put("Fire", Arrays.asList("Charmander", "Vulpix", "Flareon"));
        expectedResult.put("Psychic", Arrays.asList("Mew", "Mewtwo"));
        optionGroupsMatSelect.has().groupsAndOptions(expectedResult);
    }
}
