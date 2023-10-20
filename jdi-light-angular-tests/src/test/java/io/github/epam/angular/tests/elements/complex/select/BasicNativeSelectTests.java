package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static io.github.com.pages.SelectPage.basicNativeSelect;
import static org.hamcrest.Matchers.*;

public class BasicNativeSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        basicNativeSelect.show();
    }

    @Test(description = "Test checks label value")
    public void checkLabelValue() {
        basicNativeSelect.label().has().value("Cars");
    }

    @Test(description = "Test checks preselected value in the field")
    public void checkPreselectedValue() {
        basicNativeSelect.verify().selected(matchesPattern("[a-zA-Z]+"));
    }

    @Test(description = "Test checks option can be selected by name")
    public void checkOptionCanBeSelectedByName() {
        basicNativeSelect.select(SAAB);
        basicNativeSelect.is().selected(SAAB);
    }

    @Test(description = "Test checks available groups")
    public void checkAvailableGroups() {
        basicNativeSelect.is().groups(Collections.EMPTY_LIST);
    }

    @Test(description = "Test checks available options")
    public void checkAvailableOptions() {
        basicNativeSelect.assertThat().values(hasItem(AUDI)).values(hasItems(AUDI, VOLVO, SAAB, MERCEDES));
    }
}
