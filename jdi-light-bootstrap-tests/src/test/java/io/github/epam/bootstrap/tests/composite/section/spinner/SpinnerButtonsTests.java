package io.github.epam.bootstrap.tests.composite.section.spinner;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class SpinnerButtonsTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }



    @Test(priority = 1)
    public void checkSpinnerAppearAndThenDisappear() {
       // buttonWithSpinner.click();
        //buttonWithSpinner.spinner().disappearAfter(5);

    }



}
