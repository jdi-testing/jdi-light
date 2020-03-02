package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.hamcrest.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.common.Keyboard.keyPress;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class ButtonTests implements TestsInit {

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
        validateAlert("Red button");

        blueButton.click();
        validateAlert("Blue button");
    }
    @Test
    public void disableButtonTest() {
        try {
            disabledButton.click();
            fail("Disabled button should not work, but work");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                containsString("Can't perform click. Element is disabled"));
        }
    }
    @Test
    public void doubleClickTest() {
        dblClickButton.doubleClick();
        validateAlert("Double Click");
    }
    @Test
    public void rightClickTest() {
        rightClickButton.rightClick();
        validateAlert("Right Click");
        keyPress("Escape");
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
        WebPage.reload();
        durationMoreThan(3, () -> suspendButton.click());
        validateAlert(is("Suspend button"));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishButtonTest() {
        WebPage.reload();
        durationMoreThan(3, () ->
                ghostButton.is().disappear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutFailedButtonTest() {
        WebPage.reload();
        durationMoreThan(2, () ->
                suspendButton.is().notAppear(2));
    }

    @Test
    public void displayButtonTest() {
        WebPage.reload();
        assertFalse(suspendButton.isDisplayed());
        durationMoreThan(2, () ->
                suspendButton.is().displayed());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearButtonTest() {
        assertFalse( ghostButton.isVisible());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutButtonTest() {
        ghostButton.is().hidden();
        durationMoreThan(2, () ->
                ghostButton.is().notAppear(2));
    }

}
