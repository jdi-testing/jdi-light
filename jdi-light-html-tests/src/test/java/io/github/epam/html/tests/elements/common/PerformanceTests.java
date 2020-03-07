package io.github.epam.html.tests.elements.common;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.common.Exceptions.safeException;
import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.durationImmediately;
import static io.github.epam.html.tests.elements.BaseValidations.durationMoreThan;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.*;
import static org.testng.Assert.fail;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class PerformanceTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        refresh();
    }

    //#region With Smart Locator
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void suspendButtonTest() {
        durationMoreThan(3, () -> suspendButton.click());
        validateAlert("Suspend button");
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isDisplayedTest() {
        durationImmediately(() -> ghostButton.is().displayed());
        durationMoreThan(3, () -> suspendButton.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishButtonTest() {
        durationImmediately(() -> suspendButton.is().disappear());
        durationMoreThan(3, () -> ghostButton.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishGhostButtonTest() {
        durationMoreThan(3, () -> ghostButton.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishRemoveButtonTest() {
        durationMoreThan(3, () -> removeButton.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenButtonTest() {
        durationImmediately(() -> suspendButton.is().hidden());
        durationMoreThan(3, () -> ghostButton.is().hidden());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenRemoveButtonTest() {
        durationMoreThan(3, () -> removeButton.is().hidden());
    }
    @Test
    public void isNotAppearTimeoutFailedButtonTest() {
        durationMoreThan(2, () ->
            suspendButton.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void displayButtonTest() {
        assertFalse(suspendButton.isDisplayed());
        durationMoreThan(3, () ->
            suspendButton.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearFailedButtonTest() {
        try {
            durationMoreThan(1, () ->
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
        durationMoreThan(4, () -> ghostButton.is().notAppear());
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
    public void isNotAppearRemoveFailedButtonTest() {
        try {
            durationMoreThan(1, () ->
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
        durationMoreThan(4, () -> removeButton.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveTimeoutButtonTest() {
        removeButton.is().hidden();
        durationMoreThan(2, () ->
            removeButton.is().notAppear(2));
    }
    //#endregion

    //#region With Locator

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void suspendButtonUITest() {
        durationMoreThan(3, () -> suspendButtonUI.click());
        validateAlert("Suspend button");
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isDisplayedUITest() {
        durationImmediately(() -> ghostButtonUI.is().displayed());
        durationMoreThan(3, () -> suspendButtonUI.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishButtonUITest() {
        durationImmediately(() -> suspendButtonUI.is().disappear());
        durationMoreThan(3, () -> ghostButtonUI.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishRemoveButtonUITest() {
        durationMoreThan(3, () -> removeButtonUI.is().disappear());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenButtonUITest() {
        durationImmediately(() -> suspendButtonUI.is().hidden());
        durationMoreThan(3, () -> ghostButtonUI.is().hidden());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void vanishHiddenRemoveButtonUITest() {
        durationMoreThan(3, () -> removeButtonUI.is().hidden());
    }
    @Test
    public void isNotAppearTimeoutFailedButtonUITest() {
        durationMoreThan(2, () ->
                suspendButtonUI.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void displayButtonUITest() {
        assertFalse(suspendButtonUI.isDisplayed());
        durationMoreThan(3, () ->
                suspendButtonUI.is().displayed());
    }
    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearFailedButtonUITest() {
        try {
            durationMoreThan(1, () ->
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
        durationMoreThan(4, () -> ghostButtonUI.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearTimeoutButtonUITest() {
        ghostButtonUI.is().hidden();
        durationMoreThan(2, () ->
                ghostButtonUI.is().notAppear(2));
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveFailedButtonUITest() {
        try {
            durationMoreThan(1, () ->
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
        durationMoreThan(4, () -> removeButtonUI.is().notAppear());
    }

    //if test fails then run `mvn clean install` in module JDI Light
    @Test
    public void isNotAppearRemoveTimeoutButtonUITest() {
        removeButtonUI.is().hidden();
        durationMoreThan(2, () ->
            removeButtonUI.is().notAppear(2));
    }
    //#endregion
    private void refresh() {
        WebPage.reload();
        redButton.waitFor().displayed();
    }
}
