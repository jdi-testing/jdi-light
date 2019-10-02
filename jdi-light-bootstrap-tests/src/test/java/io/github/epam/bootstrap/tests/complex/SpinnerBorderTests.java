package io.github.epam.bootstrap.tests.complex;

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

    @Test(priority = 3)
    public void checkExistSpinner() {
        buttonSpinnerBorder.click();
       // assertTrue(spinnerBorder.core().isDisplayed());
      spinnerBorder.disappearAfter(5);
       //buttonSpinnerBorder.click();
      //  assertTrue(spinnerBorder.core().isDisplayed());
      //  assertFalse(spinnerBorder.core().isDisplayed());




       // spinnerBorder.waitFor();
    }
}
