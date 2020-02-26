package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.acceptConditions;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.testng.Assert.*;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class CheckboxTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        acceptConditions.check();
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(acceptConditions.labelText(), "Accept terms and conditions");
    }
    @Test
    public void getTextTest() {
        assertEquals(acceptConditions.getText(), "Accept terms and conditions");
    }

    @Test
    public void checkTest() {
        acceptConditions.check();
        assertTrue(acceptConditions.isSelected());
    }
    @Test
    public void uncheckTest() {
        acceptConditions.uncheck();
        assertFalse(acceptConditions.isSelected());
    }

    @Test
    public void clickTest() {
        assertTrue(acceptConditions.isSelected());
        acceptConditions.click();
        assertFalse(acceptConditions.isSelected());
    }

    @Test
    public void isValidationTest() {
        acceptConditions.is().selected();
        acceptConditions.click();
        acceptConditions.is().deselected();
        acceptConditions.is().enabled();
        acceptConditions.is().displayed();
    }

    @Test
    public void labelTest() {
        assertEquals(acceptConditions.label().getText(),
            "Accept terms and conditions");
        acceptConditions.label().is().text(containsString("terms and conditions"));
        acceptConditions.label().is().text(equalToIgnoringCase("accept terms and conditions"));
    }
    @Test
    public void assertValidationTest() {
        acceptConditions.assertThat().selected();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(acceptConditions);
    }
}
