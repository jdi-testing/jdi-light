package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.sections.SelectSection.resetMatSelect;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.matchesPattern;

public class ResetMatSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        resetMatSelect.show();
    }

    @Test
    public void checkLabelValue() {
        resetMatSelect.label().has().value("State");
    }

    @Test
    public void checkResetOptionCanBeSelectedById() {
        resetMatSelect.select(1);
        resetMatSelect.is().selected(matchesPattern("\\W+"));
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByName() {
        resetMatSelect.select("Montana");
        resetMatSelect.is().selected("Montana");
    }

    @Test
    public void checkAvailableOptions() {
        resetMatSelect.assertThat().values(hasItem("New York")).values(hasItems("Ohio", "Iowa", "Utah", "Alaska"));
    }
}
