package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.github.com.pages.sections.SelectSection.basicNativeSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;

public class BasicNativeSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        basicNativeSelect.show();
    }

    @Test
    public void checkLabelValue() {
        basicNativeSelect.label().has().value("Cars *");
    }

    @Test
    public void checkPreselectedValue() {
        basicNativeSelect.verify().selected(matchesPattern("[a-zA-Z]+"));
    }

    @Test
    public void checkOptionCanBeSelectedByName() {
        basicNativeSelect.select(SAAB);
        basicNativeSelect.is().selected(SAAB);
    }

    @Test
    public void checkListDisabledOptions() {
        basicNativeSelect.has().emptyDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        List<String> expectedEnabled = Arrays.asList(VOLVO, SAAB, MERCEDES, AUDI);
        basicNativeSelect.has().listEnabled(expectedEnabled);
    }

    @Test
    public void checkAvailableOptions() {
        basicNativeSelect.assertThat().values(hasItem(AUDI)).values(hasItems(AUDI, VOLVO, SAAB, MERCEDES));
    }
}
