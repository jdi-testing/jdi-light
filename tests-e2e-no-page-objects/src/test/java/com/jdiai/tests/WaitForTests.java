package com.jdiai.tests;

import com.jdiai.JDI;
import com.jdiai.JS;
import com.jdiai.TestInit;
import com.jdiai.testng.TestNGListener;
import com.jdiai.utils.TimeValidations;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.JDI.$;
import static com.jdiai.JDI.openPage;
import static com.jdiai.asserts.Conditions.*;
import static com.jdiai.asserts.Conditions.disappear;
import static com.jdiai.states.States.*;
import static com.jdiai.utils.TimeValidations.*;

@Listeners(TestNGListener.class)
public class WaitForTests implements TestInit {
    @Test
    public void loginTest() {
        login();
        openPage("/html5.html");

        durationMoreThan(3, () -> {
            $("#ghost-button").waitFor(disappear);
            $("#ghost-button").shouldBe(hidden);
        });
    }
    @Test
    public void loginTestJDI() {
        login();
        openPage("/html5.html");
        JS suspendButton = $("#suspend-button");
        durationMoreThan(3, () -> {
            JDI.waitFor(suspendButton, become(visible));
            suspendButton.shouldBe(visible);
        });
    }
}
