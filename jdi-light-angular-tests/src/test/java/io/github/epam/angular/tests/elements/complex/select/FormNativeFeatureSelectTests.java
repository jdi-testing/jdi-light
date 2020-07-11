package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.formNativeFeatureSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

public class FormNativeFeatureSelectTests extends TestsSelectBase {
    private static final String ARIA_INVALID = "aria-invalid";

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
        formNativeFeatureSelect.waitFor().attr(ARIA_INVALID, "false");
        formNativeFeatureSelect.hint().assertThat().text("You can pick up your favorite car here");
    }

    @Test
    public void checkListDisabledOptions() {
        formNativeFeatureSelect.has().emptyDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        formNativeFeatureSelect.has().listEnabled(Arrays.asList("", SAAB, MERCEDES, AUDI));
    }

    @Test
    public void checkEmptyOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        formNativeFeatureSelect.select("");
        formNativeFeatureSelect.core().click(0, formNativeFeatureSelect.core().getRect().getHeight() + 1);
        formNativeFeatureSelect.core().click(0, formNativeFeatureSelect.core().getRect().getHeight() + 1);
        formNativeFeatureSelect.is().selected("");
        formNativeFeatureSelect.waitFor().attr(ARIA_INVALID, "true");
        formNativeFeatureSelect.error().assertThat().text("This field is required");
    }

    @Test
    public void checkAvailableOptions() {
        formNativeFeatureSelect.assertThat().values(hasItem(AUDI)).values(hasItems(SAAB, MERCEDES));
    }
}
