package io.github.epam.html.tests.elements.simple;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.base.Alerts.getAlertText;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.jdiTitle;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class TitleTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    String text = "JDI TESTING PLATFORM";

    @Test
    public void getTextTest() {
        assertEquals(jdiTitle.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(jdiTitle.getValue(), text);
    }

    @Test
    public void clickTest() {
        jdiTitle.click();
        assertEquals(getAlertText(), "JDI Title");
        acceptAlert();
    }

    @Test
    public void isValidationTest() {
        jdiTitle.is().enabled();
        jdiTitle.is().text(is(text));
        jdiTitle.is().text(equalTo(text));
        jdiTitle.is().text(equalToIgnoringCase("jdi TESTING platform"));
    }

    @Test
    public void assertValidationTest() {
        jdiTitle.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(jdiTitle);
    }
}
