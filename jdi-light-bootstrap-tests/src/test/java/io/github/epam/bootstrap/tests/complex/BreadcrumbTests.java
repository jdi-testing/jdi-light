package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;

import static io.github.com.StaticSite.bsPage;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class BreadcrumbTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }



}
