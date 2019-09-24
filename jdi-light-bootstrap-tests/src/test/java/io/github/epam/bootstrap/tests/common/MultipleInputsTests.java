package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multipleInputs;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class MultipleInputsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }
}
