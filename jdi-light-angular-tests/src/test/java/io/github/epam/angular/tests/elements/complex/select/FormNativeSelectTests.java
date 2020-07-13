package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.formNativeSelect;
import static io.github.com.pages.sections.SelectSection.formNativeSelectConfirmation;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class FormNativeSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        formNativeSelect.show();
    }

    @Test
    public void checkLabelValue() {
        formNativeSelect.label().has().value("Favorite car");
    }

    @Test
    public void checkOptionCanBeSelectedByNameAndConfirmMessageWillAppear() {
        formNativeSelect.select(VOLVO);
        formNativeSelect.is().selected(containsString(VOLVO));
        formNativeSelectConfirmation.assertThat().text("Selected car: volvo");
    }

    @Test
    public void checkListDisabledOptions() {
        formNativeSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        formNativeSelect.has().listEnabled(Arrays.asList("", VOLVO, SAAB, MERCEDES));
    }

    @Test
    public void checkAvailableOptions() {
        formNativeSelect.assertThat().values(hasItem(VOLVO)).values(hasItems(VOLVO, SAAB, MERCEDES));
    }
}
