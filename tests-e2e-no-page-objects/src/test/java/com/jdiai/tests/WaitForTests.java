package com.jdiai.tests;

import com.jdiai.JDI;
import com.jdiai.JS;
import com.jdiai.TestInit;
import com.jdiai.testng.TestNGListener;
import com.jdiai.tools.Alerts;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.jdiai.JDI.$;
import static com.jdiai.JDI.openPage;
import static com.jdiai.asserts.Conditions.*;
import static com.jdiai.states.States.login;
import static com.jdiai.utils.TimeValidations.durationMoreThan;

@Listeners(TestNGListener.class)
public class WaitForTests implements TestInit {
    @Test
    public void disappearTest() {
        login();
        openPage("/html5.html");

        durationMoreThan(3, () -> {
            $("#ghost-button").waitFor(disappear);
            $("#ghost-button").shouldBe(hidden);
        });
    }

    @Test
    public void shouldBeVisibleTest() {
        login();
        openPage("/html5.html");
        JS suspendButton = $("#suspend-button");
        durationMoreThan(3,
            () -> suspendButton.shouldBe(visible));
        suspendButton.click();
        Alerts.validateAlertText("Suspend button");
    }

    @Test
    public void waitForTest() {
        login();
        openPage("/html5.html");
        JS suspendButton = $("#suspend-button");
        durationMoreThan(3,
            () -> JDI.waitFor(suspendButton, become(visible)));
        suspendButton.click();
        Alerts.validateAlertText("Suspend button");
    }

    @Test
    public void waitAndClickTest() {
        login();
        openPage("/html5.html");
        durationMoreThan(3, () -> $("#suspend-button").click());
        Alerts.validateAlertText("Suspend button");
    }

}
