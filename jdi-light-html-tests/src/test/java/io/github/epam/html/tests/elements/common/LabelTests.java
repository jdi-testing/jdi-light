package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

import static com.epam.jdi.light.elements.common.Alerts.*;
import static io.github.com.StaticSite.*;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.*;
import static io.github.epam.html.tests.site.steps.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class LabelTests implements TestsInit {

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
