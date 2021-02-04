package io.github.epam.angular.tests.elements.complex.select;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.epam.jdi.light.settings.JDISettings.ELEMENT;
import static io.github.com.pages.sections.SelectSection.resetNativeSelect;
import static org.hamcrest.Matchers.*;

public class ResetNativeSelectTests extends TestsSelectBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        resetNativeSelect.show();
    }

    @Test
    public void checkLabelValue() {
        resetNativeSelect.label().has().value("Select your car");
    }

    @Test
    public void checkResetOptionCanBeSelectedById() {
        resetNativeSelect.select(ELEMENT.startIndex);
        resetNativeSelect.is().selected(matchesPattern("\\W*"));
    }

    @Test
    public void checkEnabledOptionCanBeSelectedByName() {
        resetNativeSelect.select(AUDI);
        resetNativeSelect.is().selected(AUDI);
    }

    @Test
    public void checkListDisabledOptions() {
        resetNativeSelect.has().listDisabled();
    }

    @Test
    public void checkListEnabledOptions() {
        resetNativeSelect.has().listEnabled(Arrays.asList("", VOLVO, SAAB, MERCEDES, AUDI));
    }

    @Test
    public void checkAvailableOptions() {
        resetNativeSelect.assertThat().values(hasItem(MERCEDES)).values(hasItems(SAAB, AUDI, VOLVO));
    }
}
