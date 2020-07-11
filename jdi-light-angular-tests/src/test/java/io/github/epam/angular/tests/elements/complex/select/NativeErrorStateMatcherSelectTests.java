package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.sections.SelectSection.nativeErrorStateMatcherSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
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
        nativeErrorStateMatcherSelect.has().emptyDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        List<String> expectedEnabled = Arrays.asList("", VALID_OPTION, INVALID_OPTION);
        nativeErrorStateMatcherSelect.has().listEnabled(expectedEnabled);
    }

    @Test
    public void checkAvailableOptions() {
        nativeErrorStateMatcherSelect.assertThat().values(hasItem(VALID_OPTION))
                .values(hasItems(VALID_OPTION, INVALID_OPTION, ""));
    }
}
