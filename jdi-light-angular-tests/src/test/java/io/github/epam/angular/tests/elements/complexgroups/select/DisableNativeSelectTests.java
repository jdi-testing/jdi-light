package io.github.epam.angular.tests.elements.complexgroups.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.pages.sections.SelectSection.disableNativeSelect;

public class DisableNativeSelectTests extends TestsSelectBase {
    private static final String DISABLED = "disabled";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        disableNativeSelect.show();
    }

    @Test
    public void checkLabelValue() {
        disableNativeSelect.label().has().value("Choose an option");
    }

    @Test
    public void verifyCheckboxCanDisableSelect() {
        pickDisableSelectCheckboxAsChecked();
        disableNativeSelect.waitFor().has().attr(DISABLED);
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByIndex() {
        pickDisableSelectCheckboxAsUnchecked();
        disableNativeSelect.waitFor().displayed();
        disableNativeSelect.select(ELEMENT.startIndex + 1);
        disableNativeSelect.is().selected(VOLVO);
    }

    @Test
    public void checkDisabledOptionCannotBeSelectedByName() {
        pickDisableSelectCheckboxAsUnchecked();
        disableNativeSelect.waitFor().displayed();
        String preselectedValue = disableNativeSelect.selected();
        disableNativeSelect.select(SAAB);
        disableNativeSelect.is().selected(preselectedValue);
    }

    @Test
    public void checkListDisabledOptions() {
        disableNativeSelect.has().listDisabled("", SAAB);
    }

    @Test
    public void checkListEnabledOptions() {
        disableNativeSelect.has().listEnabled(Arrays.asList(VOLVO, MERCEDES, AUDI));
    }

    @Test
    public void checkAvailableGroups() {
        disableNativeSelect.is().groups();
    }

    @Test
    public void checkAvailableOptions() {
        disableNativeSelect.assertThat().values(AUDI).values(Arrays.asList(AUDI, SAAB, MERCEDES, VOLVO));
    }
}
