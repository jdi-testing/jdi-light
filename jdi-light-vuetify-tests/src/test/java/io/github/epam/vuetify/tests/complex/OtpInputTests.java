package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.otpInputsPage;
import static io.github.com.pages.OtpInputPage.disabledOtpInput;
import static io.github.com.pages.OtpInputPage.hiddenOtpInput;
import static io.github.com.pages.OtpInputPage.plainOtpInput;
import static io.github.com.pages.OtpInputPage.readOnlyOtpInput;

public class OtpInputTests extends TestsInit {

    @BeforeClass
    public void before() {
        otpInputsPage.open();
        waitCondition(() -> otpInputsPage.isOpened());
        otpInputsPage.checkOpened();
    }

    @Test(description = "Test checks entered values of plain otp")
    public void typeValuesOtpInputTest() {
        plainOtpInput.clear();
        plainOtpInput.typeValues(Arrays.asList("1", "2", "3", "4", "5"));
        plainOtpInput.has().text("12345");
    }

    @Test(description = "Test checks that otp input fields has dark and light themes")
    public void themeOtpInputTest() {
        hiddenOtpInput.has().darkTheme();
        disabledOtpInput.has().lightTheme();
    }

    @Test(description = "Test checks that otp input fields are disabled or enabled")
    public void disabledOtpInputTest() {
        disabledOtpInput.is().disabled();
        hiddenOtpInput.is().enabled();
    }

    @Test(description = "Test checks that otp input has expected length")
    public void lengthOtpInputTest() {
        hiddenOtpInput.has().length(5);
    }

    @Test(description = "Test checks that otp input is plain or not")
    public void plainOtpInputTest() {
        plainOtpInput.is().plain();
        hiddenOtpInput.is().notPlain();
    }

    @Test(description = "Test checks that OTP input is read-only")
    public void readOnlyOtpInputTest() {
        readOnlyOtpInput.is().readonly();
        hiddenOtpInput.is().notReadonly();
    }

    @Test(description = "Test checks that OTP input has expected type: password/text/number")
    public void typeOtpInputTest() {
        hiddenOtpInput.has().type("password");
        plainOtpInput.has().type("text");
        readOnlyOtpInput.has().type("number");
    }
}
