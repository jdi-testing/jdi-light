package io.github.epam.html.tests.suspend.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.common.Alerts.getAlertText;
import static io.github.com.StaticSite.suspendHtml5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.durationMoreThan;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class SuspendHtmlPageButtonTest extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        suspendHtml5Page.open();
    }

    String text = "Big Red Button-Input";

    @Test
    public void isValidationTest() {
        redButton.is().displayed();
        redButton.is().enabled();
        redButton.is().text(is(text));
        redButton.is().text(containsString("Red Button"));
        redButton.is()
                .text(is(text))
                .cssClass(is("uui-button red"))
                .attr("type", is("button"))
                .tag(is("input"));
        blueButton.is().text(containsString("Blue Button".toUpperCase()));
        disabledButton.is().text(containsString("Disabled Button".toUpperCase()));
        disabledButtonInput.is().text(containsString("Disabled Button"));
        disabledButton.is().disabled();
    }

    @Test
    public void assertValidationTest() {
        redButton.assertThat().text(is(text));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void suspendButtonTest() {
        refresh();
        durationMoreThan(3,
                () -> suspendButton.click());
        assertEquals(getAlertText(), "Suspend button");
        acceptAlert();
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearFailedButtonTest() {
        refresh();
        try {
            durationMoreThan(3, () -> ghostButton.is().notAppear());
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutButtonTest() {
        ghostButton.is().hidden();
        durationMoreThan(2, () ->
                ghostButton.is().notAppear(2));
    }
}
