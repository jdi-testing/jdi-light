package org.jdiai.tests.jsdriver;

import org.jdiai.tools.JSTalk;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.jdiai.jswrap.JSWrapper.element;
import static org.jdiai.tests.jsdriver.states.States.*;

public class JSTests extends TestInit {

    @BeforeMethod
    public void before() {
        atHomePage();
        login();
    }

    @Test
    public void doActionTest() {
        JSTalk.$("#epam-logo").isClickable();
    }
}
