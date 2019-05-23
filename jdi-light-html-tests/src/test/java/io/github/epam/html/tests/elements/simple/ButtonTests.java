package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.base.Alerts.getAlertText;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.epam.jdi.light.settings.TimeoutSettings.TIMEOUT;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    String text = "Big Red Button-Input";

    @Test
    public void getTextTest() {
        assertEquals(redButton.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(redButton.getValue(), text);
    }

    @Test
    public void clickTest() {
        redButton.click();
        assertEquals(getAlertText(), "Red button");
        acceptAlert();

        blueButton.click();
        assertEquals(getAlertText(), "Blue button");
        acceptAlert();

        disabledButton.click();
        try {
            TIMEOUT.set(1);
            acceptAlert();
            fail("Disabled button should not work, but work");
        } catch (Exception ignore) { }
    }
    @Test
    public void isValidationTest() {
        redButton.is().displayed();
        redButton.is().enabled();
        redButton.is().text(is(text));
        redButton.is().text(containsString("Red Button"));
        assertThat(redButton.css("font-size"), is("14px"));
        redButton.assertThat()
            .text(is(text))
            .css("font-size", is("14px"))
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

    @Test
    public void baseValidationTest() {
        baseValidation(redButton);
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
    public void vanishButtonTest() {
        refresh();
        durationMoreThan(3, () ->
            ghostButton.is().disappear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutFailedButtonTest() {
        refresh();
        try {
            durationImmediately(() ->
                ghostButton.is().notAppear(2));
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearFailedButtonTest() {
        refresh();
        try {
            durationImmediately(() -> ghostButton.is().notAppear());
        } catch (Exception ex) {
            assertThat(ex.getMessage(), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearButtonTest() {
        ghostButton.is().hidden();
        TIMEOUT.set(3);
        durationMoreThan(3, () -> ghostButton.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutButtonTest() {
        ghostButton.is().hidden();
        durationMoreThan(2, () ->
            ghostButton.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void seleniumButtonTest() throws InterruptedException {
        refresh();
        Thread.sleep(4000); // comment to fail selenium test
        getDriver().findElement(By.id("suspend-button")).click();
        acceptAlert();
    }
}
