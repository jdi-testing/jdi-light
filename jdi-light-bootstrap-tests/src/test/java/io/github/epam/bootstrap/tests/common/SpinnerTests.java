package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;

public class SpinnerTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        spinnerLoading.show();
        spinnerLoading.waitFor().hidden();
    }

    @Test
    public void checkSpinnerAppearAndThenDisappear() {
        startButton.click();
        spinnerLoading.is().displayed();
        spinnerLoading.waitFor().hidden();
    }

    @Test
    public void disappear() {
        startButton.click();
        spinnerLoading.waitFor().disappear();
    }

    @Test
    public void checkSpinnerHidden() {
        startButton.click();
        spinnerLoading.assertThat().hidden();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(spinnerRotate);
    }
}
