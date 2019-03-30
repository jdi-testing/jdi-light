package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.Alerts.*;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class AlertsTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.open();
    }

    @Test
    public void acceptAlertTest() {
        redButton.click();
        acceptAlert();
        blueButton.click();
        acceptAlert();
        ghostButton.click();
        acceptAlert();
    }
    @Test
    public void dismissAlertTest() {
        redButton.click();
        dismissAlert();
        blueButton.click();
        dismissAlert();
        ghostButton.click();
        dismissAlert();
    }
    @Test
    public void getAlertTextTest() {
        redButton.click();
        String text = getAlertText();
        assertEquals(text, "Red button");
        acceptAlert();
        blueButton.click();
        text = getAlertText();
        assertEquals(text, "Blue button");
        acceptAlert();
        ghostButton.click();
        text = getAlertText();
        assertEquals(text, "Ghost button");
        acceptAlert();
    }

    @Test
    public void inputAndAcceptAlertTest() {
        ghostButton.click();
        inputAndAcceptAlert("Some text");
    }

    @Test
    public void validateAlertTest() {
        redButton.click();
        validateAlert(is("Red button"));
        redButton.click();
        validateAlert(equalToIgnoringCase("red button"));
        redButton.click();
        validateAlert(containsString("Red"));
    }
}
