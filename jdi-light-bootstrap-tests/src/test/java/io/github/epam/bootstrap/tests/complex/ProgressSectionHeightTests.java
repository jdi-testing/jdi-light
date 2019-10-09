package io.github.epam.bootstrap.tests.complex;

import org.testng.annotations.BeforeMethod;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multipleInputs;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class ProgressSectionHeightTests {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    
}
