package io.github.epam.bootstrap.tests.common.spinner;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonSpinnerBorder;
import static io.github.com.pages.BootstrapPage.spinnerBorder;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class SpinnerBorderTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test()
    public void checkSpinnerClass() {
        spinnerBorder.assertThat().core().hasClass("spinner-border");
    }

    @Test(priority = 1)
    public void checkSpinnerAppearAndThenDisappear() {
        buttonSpinnerBorder.click();
        spinnerBorder.disappearAfter(4);
    }

    @Test(priority = 2)
    public void checkSpinnerAppear() {
        spinnerBorder.assertThat().hidden();
        buttonSpinnerBorder.click();
        spinnerBorder.assertThat().displayed();
    }

}
