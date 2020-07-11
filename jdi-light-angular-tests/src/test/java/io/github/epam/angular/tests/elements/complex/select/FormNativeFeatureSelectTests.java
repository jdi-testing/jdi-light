package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.sections.SelectSection.formNativeFeatureSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class FormNativeFeatureSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        formNativeFeatureSelect.show();
    }

    @Test
    public void checkLabelValue() {
        formNativeFeatureSelect.label().has().value("Select your car (required) *");
    }

    @Test
    public void checkOptionCanBeSelectedByNameAndHintMessageWillAppear() {
        formNativeFeatureSelect.select(MERCEDES);
        formNativeFeatureSelect.is().selected(MERCEDES);
        formNativeFeatureSelect.waitFor().attr("aria-invalid", "false");
        formNativeFeatureSelect.hint().assertThat().text("You can pick up your favorite car here");
    }

    @Test
    public void checkListDisabledOptions() {
        formNativeFeatureSelect.has().emptyDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        List<String> expectedEnabled = Arrays.asList("", SAAB, MERCEDES, AUDI);
        formNativeFeatureSelect.has().listEnabled(expectedEnabled);
    }

    @Test
    public void checkEmptyOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        formNativeFeatureSelect.select("");
        formNativeFeatureSelect.core().click(0, formNativeFeatureSelect.core().getRect().getHeight() + 1);
        formNativeFeatureSelect.core().click(0, formNativeFeatureSelect.core().getRect().getHeight() + 1);
        formNativeFeatureSelect.is().selected("");
        formNativeFeatureSelect.waitFor().attr("aria-invalid", "true");
        formNativeFeatureSelect.error().assertThat().text("This field is required");
    }

    @Test
    public void checkAvailableOptions() {
        formNativeFeatureSelect.assertThat().values(hasItem(AUDI)).values(hasItems(SAAB, MERCEDES));
    }
}
