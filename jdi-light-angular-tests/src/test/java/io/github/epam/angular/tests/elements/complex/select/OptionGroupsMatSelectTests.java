package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
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
        optionGroupsMatSelect.select(ELEMENT.startIndex);
        optionGroupsMatSelect.is().selected(matchesPattern("\\W+"));
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByName() {
        optionGroupsMatSelect.select(ODDISH);
        optionGroupsMatSelect.is().selected(ODDISH);
    }

    @Test
    public void checkDisabledOptionCannotBeSelectedByName() {
        String preselectedValue = optionGroupsMatSelect.selected();
        optionGroupsMatSelect.multipleSelect(FLAREON);
        optionGroupsMatSelect.is().selected(preselectedValue);
    }

    @Test
    public void checkListDisabledOptions() {
        optionGroupsMatSelect.has().listDisabled(CHARMANDER, VULPIX, FLAREON);
    }

    @Test
    public void checkListEnabledOptions() {
        optionGroupsMatSelect.has()
                .listEnabled("-- None --", BULBASAUR, ODDISH, BELLSPROUT, SQUIRTLE, PSYDUCK, HORSEA, MEW, MEWTWO);
    }

    @Test
    public void checkAvailableOptions() {
        optionGroupsMatSelect.assertThat()
                .values("-- None --", BELLSPROUT, ODDISH, SQUIRTLE, VULPIX, MEW, HORSEA, CHARMANDER);
    }

    @Test
    public void checkAvailableGroups() {
        optionGroupsMatSelect.has().groups(Arrays.asList(GRASS, WATER, FIRE, PSYCHIC));
    }

    @Test
    public void checkAvailableOptionsAndGroups() {
        optionGroupsMatSelect.has().groupsAndOptions(getPokemonsMap());
    }
}
