package org.jdiai.tests.jsdriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.jdiai.tests.jsdriver.states.States.atHomePage;
import static org.jdiai.tests.jsdriver.states.States.login;

public class JSTests extends TestInit {

    @BeforeMethod
    public void before() {
        atHomePage();
        login();
    }

    @Test
    public void doActionTest() {
    }
}
