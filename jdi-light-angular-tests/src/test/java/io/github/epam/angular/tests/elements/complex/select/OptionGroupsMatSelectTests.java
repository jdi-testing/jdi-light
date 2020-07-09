package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static io.github.com.pages.sections.SelectSection.optionGroupsMatSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;
import static org.testng.Assert.assertEquals;

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
    public void checkAvailableOptions() {
        optionGroupsMatSelect.assertThat().values(hasItem("Bulbasaur"))
                .values(hasItems("Bellsprout", "Squirtle", "Vulpix", "Mew", "Horsea", "Charmander", "Mewtwo"));
    }

    @Test
    public void checkAvailableGroups() {
        List<String> expectedGroups = Arrays.asList("Grass", "Water", "Fire", "Psychic");
        List<String> actualGroups = optionGroupsMatSelect.groups();
        assertEquals(actualGroups, expectedGroups, "Pokemon groups are not equal");
    }

    @Test
    public void checkAvailableOptionsAndGroups() {
        Map<String, List<String>> expectedResult = new LinkedHashMap<>();
        expectedResult.put("Grass", Arrays.asList("Bulbasaur", "Oddish", "Bellsprout"));
        expectedResult.put("Water", Arrays.asList("Squirtle", "Psyduck", "Horsea"));
        expectedResult.put("Fire", Arrays.asList("Charmander", "Vulpix", "Flareon"));
        expectedResult.put("Psychic", Arrays.asList("Mew", "Mewtwo"));
        Map<String, List<String>> actualResult = optionGroupsMatSelect.groupsAndOptions();
        assertEquals(actualResult, expectedResult, "Some groups and (or) options in the Pokemon map are not equal");
    }
}
