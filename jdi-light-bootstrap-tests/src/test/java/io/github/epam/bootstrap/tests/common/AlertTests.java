package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static com.epam.jdi.light.elements.common.WindowsManager.switchToWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.windowsCount;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

public class AlertTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String pageTitle = "Home Page";
    String simpleAlertTextBeforeLink = "Alert with";
    String simpleAlertTextAfterLink = ".";
    String simpleAlertLinkText = "index page link";
    String dismissibleAlertStrongText = "Dismissible alert!";
    String dismissibleAlertDescriptionText = "Hide alert clicking on \"x\".";

    @Test
    public void simpleAlertExistingTest() {
        simpleAlert.is().displayed();
        simpleAlert.is().enabled();
    }

    @Test
    public void dismissibleAlertExistingTest() {
        dismissibleAlert.is().displayed();
        dismissibleAlert.is().enabled();
    }

    @Test
    public void simpleAlertTextTest () {
        simpleAlert.is().text(containsString(simpleAlertTextBeforeLink));
        simpleAlert.is().text(containsString(simpleAlertTextAfterLink));
        simpleAlert.is().text(containsString(simpleAlertLinkText));
    }

    @Test
    public void dismissibleAlertTextTest () {
        dismissibleAlert.is().text(containsString(dismissibleAlertStrongText));
        dismissibleAlert.is().text(containsString(dismissibleAlertDescriptionText));
    }

    @Test
    public void simpleAlertIsValidationTest() {
        simpleAlert.is()
                .core()
                .css("font-size", is("14px"))
                .cssClass("alert alert-success")
                .attr("role", "alert")
                .tag(is("div"));
    }

    @Test
    public void dismissibleAlertIsValidationTest() {
        dismissibleAlert.is()
                .core()
                .css("font-size", is("14px"))
                .cssClass("alert alert-warning alert-dismissible fade show")
                .attr("role", "alert")
                .tag(is("div"));
    }

    @Test
    public void dismissibleAlertButtonIsValidationTest() {
        alertButton.is().displayed()
                .enabled()
                .core()
                .attr("type", "button")
                .attr("data-dismiss", "alert")
                .attr("aria-label", "Close")
                .tag(is("button"));
    }

    @Test (priority = 1)
    public void dismissibleAlertButtonClickTest() {
        alertButton.click();
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        dismissibleAlert.is().displayed();
    }

    @Test (priority = 2)
    public void clickableTest() {
        simpleAlert.click();
        assertEquals(windowsCount(), 2);
        switchToWindow(2);
        assertEquals(getTitle(), pageTitle);
    }
}
