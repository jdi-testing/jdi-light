package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.common.Exceptions;
import io.github.epam.TestsInit;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.common.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.common.Alerts.getAlertText;
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
    }
    @Test
    public void disableButtonTest() {
        try {
            disabledButton.click();
            fail("Disabled button should not work, but work");
        } catch (Exception ex) { assertThat(safeException(ex), containsString("Can't perform click. Element is disabled"));}
    }
    @Test
    public void doubleClickTest() {
        dblClickButton.doubleClick();
        assertEquals(getAlertText(), "Double Click");
        acceptAlert();
    }
    @Test
    public void rightClickTest() {
        rightClickButton.rightClick();
        assertEquals(getAlertText(), "Right Click");
        acceptAlert();
    }
    @Test
    public void isValidationTest() {
        redButton.is().displayed();
        redButton.is().enabled();
        redButton.is().text(is(text));
        redButton.is().text(containsString("Red Button"));
        assertThat(redButton.core().css("font-size"), is("14px"));
        redButton.assertThat().displayed()
            .and().text(is(text))
            .core()
            .css("font-size", is("14px"))
            .cssClass("uui-button red")
            .attr("type", "button")
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
            durationMoreThan(2, () ->
                suspendButton.is().notAppear(2));
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearFailedButtonTest() {
        refresh();
        try {
            durationImmediately(() -> ghostButton.is().notAppear());
        } catch (Exception ex) {
            assertThat(safeException(ex), containsString("but: was \"displayed\""));
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
