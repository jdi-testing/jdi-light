package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.multipleInputs;
import static io.github.epam.states.States.shouldBeLoggedIn;

public class MultipleInputsTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        multipleInputs.show();
        multipleInputs.clear();
    }

    @Test
    public void setComplexTextTest() {
        multipleInputs.setName("Roman", "Iovlev");
        multipleInputs.has().text("Roman;Iovlev");
        multipleInputs.clear();
        multipleInputs.is().displayed();
    }
}
