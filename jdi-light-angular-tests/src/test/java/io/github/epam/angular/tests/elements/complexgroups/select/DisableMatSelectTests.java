package io.github.epam.angular.tests.elements.complexgroups.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.pages.sections.SelectSection.disableCheckboxSelect;
import static io.github.com.pages.sections.SelectSection.disableMatSelect;

public class DisableMatSelectTests extends TestsSelectBase {
    private static final String ARIA_DISABLED = "aria-disabled";
    private static final String OPTION_2_DISABLED = "Option 2 (disabled)";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        disableMatSelect.show();
    }

    @Test
    public void checkLabelValue() {
        disableMatSelect.label().has().value("Choose an option");
    }

    @Test
    public void verifyCheckboxLabelValue() {
        disableCheckboxSelect.label().has().value("Disable select");
    }

    @Test
    public void verifyCheckboxCanDisableSelect() {
        pickDisableSelectCheckboxAsChecked();
        disableMatSelect.waitFor().attr(ARIA_DISABLED, "true");
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByIndex() {
        pickDisableSelectCheckboxAsUnchecked();
        disableMatSelect.waitFor().attr(ARIA_DISABLED, "false");
        disableMatSelect.select(ELEMENT.startIndex + 2);
        disableMatSelect.is().selected(OPTION_3);
    }

    @Test
    public void checkDisabledOptionCannotBeSelectedByName() {
        pickDisableSelectCheckboxAsUnchecked();
        disableMatSelect.waitFor().attr(ARIA_DISABLED, "false");
        String preselectedValue = disableMatSelect.selected();
        disableMatSelect.multipleSelect(OPTION_2_DISABLED);
        disableMatSelect.is().selected(preselectedValue);
    }

    @Test
    public void checkListDisabledOptions() {
        disableMatSelect.has().listDisabled(OPTION_2_DISABLED);
    }

    @Test
    public void checkListEnabledOptions() {
        disableMatSelect.has().listEnabled(Arrays.asList(OPTION_1, OPTION_3));
    }

    @Test
    public void checkAvailableOptions() {
        disableMatSelect.assertThat().values(OPTION_1, OPTION_2_DISABLED, OPTION_3);
    }
}
