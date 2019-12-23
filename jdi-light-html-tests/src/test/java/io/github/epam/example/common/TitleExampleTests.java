package io.github.epam.example.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.common.Alerts.getAlertText;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.jdiTitle;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;

public class TitleExampleTests implements TestsInit {

    String titleText = "JDI TESTING PLATFORM";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }

    @Test
    public void textTest() {
        jdiTitle.is().text(titleText);
    }

    @Test
    public void valueTest() {
        jdiTitle.is().value(titleText);
    }

    @Test
    public void clickTest() {
        jdiTitle.click();
        assertEquals(getAlertText(), "JDI Title");
        acceptAlert();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(jdiTitle);
    }
}
