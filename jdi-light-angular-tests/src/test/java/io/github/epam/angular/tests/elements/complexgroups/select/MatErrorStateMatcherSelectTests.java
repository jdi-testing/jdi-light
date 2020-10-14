package io.github.epam.angular.tests.elements.complexgroups.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.matErrorStateMatcherSelect;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;

public class MatErrorStateMatcherSelectTests extends TestsSelectBase {
    private static final String CLEAR = "Clear";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        matErrorStateMatcherSelect.show();
    }

    @Test
    public void checkLabelValue() {
        matErrorStateMatcherSelect.label().has().value("Choose one");
    }

    @Test
    public void checkValidOptionCanBeSelectedByNameAndHintMessageWillAppear() {
        matErrorStateMatcherSelect.select(VALID_OPTION);
        matErrorStateMatcherSelect.is().selected(VALID_OPTION);
        matErrorStateMatcherSelect.hint().assertThat().text("Errors appear instantly!");
    }

    @Test
    public void checkInvalidOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        matErrorStateMatcherSelect.select(INVALID_OPTION);
        matErrorStateMatcherSelect.is().selected(matchesPattern(INVALID_OPTION));
        matErrorStateMatcherSelect.error().assertThat().text(INVALID_SELECTION);
    }

    @Test
    public void checkClearOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        matErrorStateMatcherSelect.select(CLEAR);
        matErrorStateMatcherSelect.is().selected(matchesPattern("\\W+"));
        matErrorStateMatcherSelect.error().assertThat().text(MUST_MAKE_SELECTION);
    }

    @Test
    public void checkListDisabledOptions() {
        matErrorStateMatcherSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        matErrorStateMatcherSelect.has().listEnabled(Arrays.asList(CLEAR, VALID_OPTION, INVALID_OPTION));
    }

    @Test
    public void checkAvailableOptions() {
        matErrorStateMatcherSelect.assertThat().values(hasItems(VALID_OPTION, INVALID_OPTION, CLEAR));
    }
}
