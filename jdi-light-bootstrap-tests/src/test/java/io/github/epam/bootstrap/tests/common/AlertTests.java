package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

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
    public void simpleAlertTextTest() {
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
        dismissibleAlert.dismissButton().is().displayed()
                .enabled()
                .core()
                .attr("type", "button")
                .attr("data-dismiss", "alert")
                .attr("aria-upload", "Close")
                .tag(is("button"));
    }

    @Test (priority = 1)
    public void dismissibleAlertButtonClickTest() {
        dismissibleAlert.dismissButton().click();
        dismissibleAlert.base().waitSec(1);
        dismissibleAlert.is().hidden();
    }

    @Test
    public void simpleAlertLinkClickableTest() {
        simpleAlert.click();
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
