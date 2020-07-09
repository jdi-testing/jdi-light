package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        nativeErrorStateMatcherSelect.select("Valid option");
        nativeErrorStateMatcherSelect.is().selected("Valid option");
    }

    @Test
    public void checkInvalidOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        nativeErrorStateMatcherSelect.select("Invalid option");
        nativeErrorStateMatcherSelect.is().selected(matchesPattern("Invalid option"));
        nativeErrorStateMatcherSelect.error().assertThat().text("Your selection is invalid");
    }

    @Test
    public void checkClearOptionCanBeSelectedByNameAndErrorMessageWillAppear() {
        nativeErrorStateMatcherSelect.select("");
        nativeErrorStateMatcherSelect.is().selected("");
        nativeErrorStateMatcherSelect.error().assertThat().text("You must make a selection");
    }

    @Test
    public void checkAvailableOptions() {
        nativeErrorStateMatcherSelect.assertThat().values(hasItem("Valid option"))
                .values(hasItems("Valid option", "Invalid option", ""));
    }
}
