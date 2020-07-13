package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.nativeErrorStateMatcherSelect;
import static org.hamcrest.Matchers.matchesPattern;

public class NativeErrorStateMatcherSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        nativeErrorStateMatcherSelect.show();
    }

    @Test
    public void checkLabelValue() {
        nativeErrorStateMatcherSelect.label().has().value("Choose one");
    }

    @Test
    public void checkValidOptionCanBeSelectedByName() {
        nativeErrorStateMatcherSelect.select(VALID_OPTION);
        nativeErrorStateMatcherSelect.is().selected(VALID_OPTION);
    }

    @Test
    public void checkInvalidOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        nativeErrorStateMatcherSelect.select(INVALID_OPTION);
        nativeErrorStateMatcherSelect.is().selected(matchesPattern(INVALID_OPTION));
        nativeErrorStateMatcherSelect.error().assertThat().text("Your selection is invalid");
    }

    @Test
    public void checkClearOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        nativeErrorStateMatcherSelect.select("");
        nativeErrorStateMatcherSelect.is().selected("");
        nativeErrorStateMatcherSelect.error().assertThat().text("You must make a selection");
    }

    @Test
    public void checkListDisabledOptions() {
        nativeErrorStateMatcherSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        nativeErrorStateMatcherSelect.has().listEnabled(Arrays.asList("", VALID_OPTION, INVALID_OPTION));
    }

    @Test
    public void checkAvailableOptions() {
        nativeErrorStateMatcherSelect.assertThat().values(VALID_OPTION).values(VALID_OPTION, INVALID_OPTION, "");
    }
}
