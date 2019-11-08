package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.acceptAlert;
import static com.epam.jdi.light.elements.common.Alerts.getAlertText;
import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.jdiTitle;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class LabelTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
    }
    private String text = "JDI TESTING PLATFORM";

    //TODO Performance issue
    @Test
    public void getTextTest() {
        assertEquals(jdiTitle.getText(), text);
    }

    //TODO Performance issue
    @Test
    public void getValueTest() {
        assertEquals(jdiTitle.getValue(), text);
    }

    //TODO Performance issue
    @Test
    public void clickTest() {
        jdiTitle.click();
        assertEquals(getAlertText(), "JDI Title");
        acceptAlert();
    }

    //TODO Performance issue
    @Test
    public void isValidationTest() {
        jdiTitle.is().enabled();
        jdiTitle.is().text(is(text));
        jdiTitle.is().text(equalTo(text));
        jdiTitle.is().text(equalToIgnoringCase("jdi TESTING platform"));
    }

    //TODO Performance issue
    @Test
    public void assertValidationTest() {
        jdiTitle.assertThat().text(is(text));
    }

    //TODO Performance issue
    @Test
    public void baseValidationTest() {
        baseValidation(jdiTitle);
    }
}
