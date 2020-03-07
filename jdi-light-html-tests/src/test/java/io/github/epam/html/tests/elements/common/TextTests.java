package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.*;

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

public class TextTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    String text = "Powerful Framework for UI Tests Automation. Suitable for any UI project: Web(Html5, Angular, React...), Mobile(Android IOs), Desktop(Win app) etc.";

    //TODO Performance issue
    @Test
    public void getTextTest() {
        assertEquals(jdiText.getText(), text);
    }

    //TODO Performance issue
    @Test
    public void getValueTest() {
        assertEquals(jdiText.getValue(), text);
    }

    //TODO Performance issue
    @Test
    public void isValidationTest() {
        jdiText.is().enabled();
        jdiText.is().text(is(text));
        jdiText.is().text(containsString("Powerful Framework for UI"));
    }

    //TODO Performance issue
    @Test
    public void assertValidationTest() {
        jdiText.assertThat().text(is(text));
    }

    //TODO Performance issue
    @Test
    public void baseValidationTest() {
        baseValidation(jdiText);
    }
}
