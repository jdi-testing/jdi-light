package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
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

public class PerformanceTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    //#region With Smart Locator
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void suspendButtonTest() {
        WebPage.reload();
        duration(3, () -> suspendButton.click());
        validateAlert("Suspend button");
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isDisplayedTest() {
        WebPage.reload();
        durationImmediately(() -> ghostButton.is().displayed());
        duration(3, () -> suspendButton.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishButtonTest() {
        WebPage.reload();
        durationImmediately(() -> suspendButton.is().disappear());
        duration(3, () -> ghostButton.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishRemoveButtonTest() {
        WebPage.reload();
        duration(3, () -> removeButton.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenButtonTest() {
        WebPage.reload();
        durationImmediately(() -> suspendButton.is().hidden());
        duration(3, () -> ghostButton.is().hidden());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenRemoveButtonTest() {
        WebPage.reload();
        duration(3, () -> removeButton.is().hidden());
    }
    @Test
    public void isNotAppearTimeoutFailedButtonTest() {
        WebPage.reload();
        durationMoreThan(2, () ->
            suspendButton.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void displayButtonTest() {
        WebPage.reload();
        assertFalse(suspendButton.isDisplayed());
        durationMoreThan(2, () ->
                suspendButton.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearFailedButtonTest() {
        WebPage.reload();
        try {
            durationImmediately(() ->
                ghostButton.is().notAppear());
            fail("Ghost button visible first 3 seconds, so notAppear should throw exception immediately");
        } catch (AssertionError ex) {
            assertThat(safeException(ex), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearButtonTest() {
        ghostButton.is().hidden();
        duration(4, () -> ghostButton.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutButtonTest() {
        ghostButton.is().hidden();
        duration(2, () ->
            ghostButton.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveFailedButtonTest() {
        WebPage.reload();
        try {
            durationImmediately(() ->
                    removeButton.is().notAppear());
            fail("Ghost button visible first 3 seconds, so notAppear should throw exception immediately");
        } catch (AssertionError ex) {
            assertThat(safeException(ex), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveButtonTest() {
        removeButton.is().hidden();
        duration(4, () -> removeButton.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveTimeoutButtonTest() {
        removeButton.is().hidden();
        duration(2, () ->
            removeButton.is().notAppear(2));
    }
    //#endregion

    //#region With Locator

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void suspendButtonUITest() {
        WebPage.reload();
        duration(3, () -> suspendButtonUI.click());
        validateAlert("Suspend button");
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isDisplayedUITest() {
        WebPage.reload();
        durationImmediately(() -> ghostButtonUI.is().displayed());
        duration(3, () -> suspendButtonUI.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishButtonUITest() {
        WebPage.reload();
        durationImmediately(() -> suspendButtonUI.is().disappear());
        duration(3, () -> ghostButtonUI.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishRemoveButtonUITest() {
        WebPage.reload();
        duration(3, () -> removeButtonUI.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenButtonUITest() {
        WebPage.reload();
        durationImmediately(() -> suspendButtonUI.is().hidden());
        duration(3, () -> ghostButtonUI.is().hidden());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenRemoveButtonUITest() {
        WebPage.reload();
        duration(3, () -> removeButtonUI.is().hidden());
    }
    @Test
    public void isNotAppearTimeoutFailedButtonUITest() {
        WebPage.reload();
        durationMoreThan(2, () ->
                suspendButtonUI.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void displayButtonUITest() {
        WebPage.reload();
        assertFalse(suspendButtonUI.isDisplayed());
        durationMoreThan(2, () ->
                suspendButtonUI.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearFailedButtonUITest() {
        WebPage.reload();
        try {
            durationImmediately(() ->
                    ghostButtonUI.is().notAppear());
            fail("Ghost button visible first 3 seconds, so notAppear should throw exception immediately");
        } catch (AssertionError ex) {
            assertThat(safeException(ex), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearButtonUITest() {
        ghostButtonUI.is().hidden();
        duration(4, () -> ghostButtonUI.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutButtonUITest() {
        ghostButtonUI.is().hidden();
        duration(2, () ->
                ghostButtonUI.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveFailedButtonUITest() {
        WebPage.reload();
        try {
            durationImmediately(() ->
                    removeButtonUI.is().notAppear());
            fail("Ghost button visible first 3 seconds, so notAppear should throw exception immediately");
        } catch (AssertionError ex) {
            assertThat(safeException(ex), containsString("but: was \"displayed\""));
        }
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveButtonUITest() {
        removeButtonUI.is().hidden();
        duration(4, () -> removeButtonUI.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveTimeoutButtonUITest() {
        removeButtonUI.is().hidden();
        duration(2, () ->
                removeButtonUI.is().notAppear(2));
    }
    //#endregion
}
