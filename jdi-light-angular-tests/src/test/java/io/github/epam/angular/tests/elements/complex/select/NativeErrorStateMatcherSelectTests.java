package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

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
        nativeErrorStateMatcherSelect.error().assertThat().text(INVALID_SELECTION);
    }

    @Test
    public void checkClearOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        nativeErrorStateMatcherSelect.select("");
        nativeErrorStateMatcherSelect.is().selected("");
        nativeErrorStateMatcherSelect.error().assertThat().text(MUST_MAKE_SELECTION);
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
    public void checkAvailableGroups() {
        nativeErrorStateMatcherSelect.is().groups(Collections.emptyList());
    }

    @Test
    public void checkAvailableOptions() {
        nativeErrorStateMatcherSelect.assertThat().values(VALID_OPTION).values(VALID_OPTION, INVALID_OPTION, "");
    }
}
