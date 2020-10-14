package io.github.epam.angular.tests.elements.complexgroups.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static io.github.com.pages.sections.SelectSection.selectBindingConfirm;
import static io.github.com.pages.sections.SelectSection.twoBindingSelect;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;

public class TwoBindingSelectTests extends TestsSelectBase {
    private static final String NONE = "None";

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
        selectBindingConfirm.assertThat().text("You selected: option1");
    }

    @Test
    public void checkNoneOptionCanBeSelectedByNameAndConfirmMessageWillBeEmpty() {
        twoBindingSelect.select(NONE);
        twoBindingSelect.is().selected(matchesPattern("\\W+"));
        selectBindingConfirm.assertThat().text("You selected:");
    }

    @Test
    public void checkListDisabledOptions() {
        twoBindingSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        twoBindingSelect.has().listEnabled(Arrays.asList(NONE, OPTION_1, OPTION_2, OPTION_3));
    }

    @Test
    public void checkAvailableOptions() {
        twoBindingSelect.assertThat().values(hasItems(NONE, OPTION_1, OPTION_2, OPTION_3));
    }
}
