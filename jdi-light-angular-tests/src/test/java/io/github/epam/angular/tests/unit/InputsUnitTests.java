package io.github.epam.angular.tests.unit;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.inputPage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.InputPage.inputAutoSize;
import static io.github.com.pages.InputPage.inputBasicFood;
import static io.github.com.pages.InputPage.inputBasicLeaveAComment;
import static io.github.com.pages.InputPage.inputEmailErrorStateMatcher;
import static io.github.com.pages.InputPage.inputErrorMail;
import static io.github.com.pages.InputPage.inputTelephone;
import static io.github.com.pages.InputPage.inputWithAriaLabel;
import static io.github.com.pages.InputPage.inputWithClearButton;
import static io.github.com.pages.InputPage.inputWithMessageHint;
import static io.github.com.pages.InputPage.inputWithReadonly;
import static io.github.com.pages.InputPage.inputsForm;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsUnitTests  extends TestsInit {

    @BeforeMethod
    public void before() {
        inputPage.open();
        waitCondition(() -> inputPage.isOpened());
        inputPage.checkOpened();
    }

    @Test
    public void isDisplayed() {
        assertTrue(inputBasicFood.isDisplayed());
        assertTrue(inputBasicLeaveAComment.isDisplayed());
        assertTrue(inputEmailErrorStateMatcher.isDisplayed());
        assertTrue(inputAutoSize.isDisplayed());
        assertTrue(inputWithClearButton.isDisplayed());
        assertTrue(inputErrorMail.isDisplayed());
        assertTrue(inputsForm.isDisplayed());
        assertTrue(inputWithMessageHint.isDisplayed());
        assertTrue(inputTelephone.isDisplayed());
        assertTrue(inputWithAriaLabel.isDisplayed());
        assertTrue(inputWithReadonly.isDisplayed());
    }

    @Test
    public void isVisible() {
        inputBasicFood.show();
        assertTrue(inputBasicFood.isVisible());
        assertTrue(inputBasicLeaveAComment.isVisible());

        inputEmailErrorStateMatcher.show();
        assertTrue(inputEmailErrorStateMatcher.isVisible());

        inputAutoSize.show();
        assertTrue(inputAutoSize.isVisible());

        inputWithClearButton.show();
        assertTrue(inputWithClearButton.isVisible());

        inputErrorMail.show();
        assertTrue(inputErrorMail.isVisible());

        inputsForm.show();
        assertTrue(inputsForm.isVisible());

        inputWithMessageHint.show();
        assertTrue(inputWithMessageHint.isVisible());

        inputTelephone.show();
        assertTrue(inputTelephone.isVisible());

        inputWithAriaLabel.show();
        assertTrue(inputWithAriaLabel.isVisible());

        inputWithReadonly.show();
        assertTrue(inputWithReadonly.isVisible());
    }

    @Test
    public void hasTypedText() {
        inputBasicFood.input("test");
        assertEquals(inputBasicFood.getValue(), "test");
        inputBasicLeaveAComment.input("test");
        assertEquals(inputBasicLeaveAComment.getValue(), "test");
        inputEmailErrorStateMatcher.input("test");
        assertEquals(inputEmailErrorStateMatcher.getValue(), "test");
        inputAutoSize.input("test");
        assertEquals(inputAutoSize.getValue(), "test");
        inputWithClearButton.input("test");
        assertEquals(inputWithClearButton.getValue(), "test");
        inputErrorMail.input("test");
        assertEquals(inputErrorMail.getValue(), "test");
        inputWithMessageHint.input("test");
        assertEquals(inputWithMessageHint.getValue(), "test");
        inputTelephone.input("test");
        assertEquals(inputTelephone.getValue(), "test");
        inputWithAriaLabel.input("test");
        assertEquals(inputWithAriaLabel.getValue(), "test");

        inputsForm.fill(DEFAULT_USER);
        assertEquals(inputsForm.firstName.getValue(), DEFAULT_USER.firstName);
        assertEquals(inputsForm.lastName.getValue(), DEFAULT_USER.lastName);
        assertEquals(inputsForm.address.getValue(), DEFAULT_USER.address);
        assertEquals(inputsForm.address2.getValue(), DEFAULT_USER.address2);
        assertEquals(inputsForm.city.getValue(), DEFAULT_USER.city);
        assertEquals(inputsForm.state.getValue(), DEFAULT_USER.state);
        assertEquals(inputsForm.postalCode.getValue(), DEFAULT_USER.postalCode);
    }
}
