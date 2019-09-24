package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;

import static io.github.com.StaticSite.bsPage;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Olga Ivanova on 19.09.2019
 * Email: olga_ivanova@epam.com
 */

public class InputGroupCustomFileInputWithButtonTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }
 //customFileInputWithButton1
    //customFileInputWithButton2
}
