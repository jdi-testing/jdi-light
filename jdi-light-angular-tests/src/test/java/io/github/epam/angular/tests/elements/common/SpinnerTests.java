package io.github.epam.angular.tests.elements.common;

import com.epam.jdi.tools.func.JAction;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SpinnerSection.basicProgressSpinner;
import static io.github.com.pages.sections.SpinnerSection.showSpinner;
import static io.github.epam.angular.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.angular.tests.elements.BaseValidationsUtils.duration;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class SpinnerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
    }

    @Test
    public void disappear() {
        showSpinner.click();
        basicProgressSpinner.waitFor().disappear();
    }

    @Test
    public void baseValidationTest() {
        showSpinner.show();
        showSpinner.click();
        baseValidation(basicProgressSpinner);
    }

    @Test
    public void checkSpinnerHidden() {
        showSpinner.click();
        basicProgressSpinner.assertThat().hidden();
    }

    @Test
    public void checkSpinnerAppearAndThenDisappear() {
        showSpinner.click();
        basicProgressSpinner.is().displayed();
        basicProgressSpinner.waitFor().hidden();
    }

    @Test
    public void checkSpinnerDurationTest() {
        refresh();
        showSpinner.show();
        final int DURATION = 5;
        JAction action = () -> {
            basicProgressSpinner.base().timer().wait(() -> basicProgressSpinner.isDisplayed());
            basicProgressSpinner.base().timer().wait(() -> basicProgressSpinner.isHidden());
        };
        showSpinner.click();
        duration(DURATION, 900, action);
    }
}
