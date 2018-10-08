package io.github.epam.html.tests.elements;

import io.github.epam.TestsInit;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.base.WindowsManager.alert;
import static io.github.com.StaticSite.htmlElementsPage;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.Preconditions.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        htmlElementsPage.shouldBeOpened();
    }
    String text = "Big Red Button-Input";

    @Test
    public void getTextTest() {
        assertEquals(redButton.getText(), text);
    }

    @Test
    public void getValueTest() {
        assertEquals(redButton.getValue(), text);
    }

    @Test
    public void clickTest() {
        redButton.click();
        assertEquals(alert().getText(), "Red button");
        alert().accept();

        blueButton.click();
        assertEquals(alert().getText(), "Blue button");
        alert().accept();

        disabledButton.click();
        try {
            alert();
            Assert.fail("Disabled button should not work, but work");
        } catch (NoAlertPresentException ex) { }
    }

    @Test
    public void isValidationTest() {
        redButton.is().text(is(text));
        redButton.is().text(containsString("Red Button"));
        blueButton.is().text(containsString("Blue Button".toUpperCase()));
        disabledButton.is().text(containsString("Disabled Button".toUpperCase()));
        disabledButtonInput.is().text(containsString("Disabled Button"));
    }

    @Test
    public void assertValidationTest() {
        redButton.assertThat().text(is(text));
    }

    @Test
    public void baseValidationTest() {
        baseValidation(redButton);
    }
}
