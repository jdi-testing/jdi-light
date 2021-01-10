package org.jdiai.tests.jsdriver;

import org.jdiai.Direction;
import org.jdiai.JS;
import org.openqa.selenium.Point;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.jdiai.tests.jsdriver.states.States.atHomePage;
import static org.jdiai.tests.jsdriver.states.States.login;
import static org.jdiai.tools.JSTalk.$;

public class JSTests extends TestInit {

    @BeforeMethod
    public void before() {
        atHomePage();
        login();
    }

    @Test
    public void doActionTest() {
        JS jdiTitle = $(".text-center a");
        Point jdiTitleCenter = jdiTitle.getLocation();
        JS contactForm = $(".sidebar-menu>[index='2']");
        Point contactFormCenter = contactForm.getLocation();
        Direction expected = new Direction(jdiTitleCenter, contactFormCenter);
        jdiTitle.validateRelativePosition(contactForm, expected);
        $("#epam-logo").isClickable();
    }
}
