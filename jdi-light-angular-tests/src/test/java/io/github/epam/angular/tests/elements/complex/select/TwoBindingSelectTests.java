package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.selectBindingConfirmation;
import static io.github.com.pages.sections.SelectSection.twoBindingSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;

public class TwoBindingSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        twoBindingSelect.show();
    }

    @Test
    public void checkLabelValue() {
        twoBindingSelect.label().has().value("Select an option");
    }

    @Test
    public void checkOptionCanBeSelectedByNameAndConfirmMessageWillAppear() {
        twoBindingSelect.select(OPTION_1);
        twoBindingSelect.is().selected(OPTION_1);
        selectBindingConfirmation.assertThat().text("You selected: option1");
    }

    @Test
    public void checkNoneOptionCanBeSelectedByNameAndConfirmMessageWillBeEmpty() {
        twoBindingSelect.select("None");
        twoBindingSelect.is().selected(matchesPattern("\\W+"));
        selectBindingConfirmation.assertThat().text("You selected:");
    }

    @Test
    public void checkAvailableOptions() {
        twoBindingSelect.assertThat().values(hasItem(OPTION_2)).values(hasItems("None", OPTION_1, OPTION_3));
    }
}
