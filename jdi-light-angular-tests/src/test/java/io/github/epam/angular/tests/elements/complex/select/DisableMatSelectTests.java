package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.checkboxDisableSelect;
import static io.github.com.pages.sections.SelectSection.disableMatSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class DisableMatSelectTests extends TestsSelectBase {
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
        checkboxDisableSelect.label().has().value("Disable select");
    }

    @Test
    public void verifyCheckboxCanDisableSelect() {
        pickDisableSelectCheckboxAsChecked();
        disableMatSelect.waitFor().attr("aria-disabled", "true");
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByIndex() {
        pickDisableSelectCheckboxAsUnchecked();
        disableMatSelect.waitFor().attr("aria-disabled", "false");
        disableMatSelect.select(3);
        disableMatSelect.is().selected(OPTION_3);
    }

    @Test
    public void checkDisabledOptionCannotBeSelectedByName() {
        pickDisableSelectCheckboxAsUnchecked();
        disableMatSelect.waitFor().attr("aria-disabled", "false");
        String preselectedValue = disableMatSelect.selected();
        disableMatSelect.multipleSelect("Option 2 (disabled)");
        disableMatSelect.is().selected(preselectedValue);
    }

    @Test
    public void checkAvailableOptions() {
        disableMatSelect.assertThat().values(hasItem("Option 2 (disabled)")).values(hasItems(OPTION_1, OPTION_3));
    }
}
