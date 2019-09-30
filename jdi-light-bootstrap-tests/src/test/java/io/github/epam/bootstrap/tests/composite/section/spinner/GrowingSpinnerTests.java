package io.github.epam.bootstrap.tests.composite.section.spinner;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.growingSpinner;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class GrowingSpinnerTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void growingTest() {
        growingSpinner.primarySpinner.highlight();
//        float firstSnapshot = WebDriverFactory.jsExecute(
//                "var x = document.getElementsByClassName('spinner-grow')[0].children;" +
//                      "var y = x[0];" +
//                      "return y.getBoundingClientRect().width;"
//        );
//
//        float secondSnapshot
//        assertTrue(execResult);
    }

}
