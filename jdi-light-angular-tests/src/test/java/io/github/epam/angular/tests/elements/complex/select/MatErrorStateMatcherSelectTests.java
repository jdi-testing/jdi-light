package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.matErrorStateMatcherSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;

public class MatErrorStateMatcherSelectTests extends TestsSelectBase {
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
        matErrorStateMatcherSelect.select("Valid option");
        matErrorStateMatcherSelect.is().selected("Valid option");
        matErrorStateMatcherSelect.hint().assertThat().text("Errors appear instantly!");
    }

    @Test
    public void checkInvalidOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        matErrorStateMatcherSelect.select("Invalid option");
        matErrorStateMatcherSelect.is().selected(matchesPattern("Invalid option"));
        matErrorStateMatcherSelect.error().assertThat().text("Your selection is invalid");
    }

    @Test
    public void checkClearOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        matErrorStateMatcherSelect.select("Clear");
        matErrorStateMatcherSelect.is().selected(matchesPattern("\\W+"));
        matErrorStateMatcherSelect.error().assertThat().text("You must make a selection");
    }

    @Test
    public void checkAvailableOptions() {
        matErrorStateMatcherSelect.assertThat()
                .values(hasItem("Valid option"))
                .values(hasItems("Valid option", "Invalid option", "Clear"));
    }
}
