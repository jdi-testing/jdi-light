package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static io.github.com.pages.sections.SelectSection.basicNativeSelect;
import static org.hamcrest.Matchers.*;

// TODO Move to the new page
@Ignore
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
        basicNativeSelect.has().listDisabled(Collections.EMPTY_LIST);
    }

    @Test
    public void checkListEnabledOptions() {
        basicNativeSelect.has().listEnabled(Arrays.asList(VOLVO, SAAB, MERCEDES, AUDI));
    }

    @Test
    public void checkAvailableGroups() {
        basicNativeSelect.is().groups(Collections.EMPTY_LIST);
    }

    @Test
    public void checkAvailableOptions() {
        basicNativeSelect.assertThat().values(hasItem(AUDI)).values(hasItems(AUDI, VOLVO, SAAB, MERCEDES));
    }
}
