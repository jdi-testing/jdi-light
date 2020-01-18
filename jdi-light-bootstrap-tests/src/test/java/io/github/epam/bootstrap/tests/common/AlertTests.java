package io.github.epam.bootstrap.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.dismissibleAlert;
import static io.github.com.pages.BootstrapPage.simpleAlert;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.baseValidation;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class AlertTests extends TestsInit {

    final String text = "Alert with index page link.";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        simpleAlert.show();
    }
    @Test
    public void simpleAlertExistingTest() {
        simpleAlert.is().displayed().enabled();
    }
    @Test
    public void simpleAlertTextTest() {
        simpleAlert.is().text(text);
        simpleAlert.has().text(containsString("Alert with"));
    }

    @Test
    public void dismissibleAlertTextTest() {
        dismissibleAlert.is().displayed();
        dismissibleAlert.closeAlertButton.click();
        dismissibleAlert.is().hidden();
    }
    @Test
    public void baseValidationTest() {
        baseValidation(simpleAlert);
    }
}
