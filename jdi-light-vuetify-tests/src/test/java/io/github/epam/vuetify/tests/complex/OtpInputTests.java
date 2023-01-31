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

    @Test
    public void typeValuesOtpInputTest() {
        plainOtpInput.clear();
        plainOtpInput.typeValues(Arrays.asList("1", "2", "3", "4", "5"));
        plainOtpInput.has().text("12345");
    }

    @Test
    public void themeOtpInputTest() {
        hiddenOtpInput.has().darkTheme();
        disabledOtpInput.has().lightTheme();
    }

    @Test
    public void disabledOtpInputTest() {
        disabledOtpInput.is().disabled();
        hiddenOtpInput.is().enabled();
    }

    @Test
    public void lengthOtpInputTest() {
        hiddenOtpInput.has().length(5);
    }

    @Test
    public void plainOtpInputTest() {
        plainOtpInput.is().plain();
        hiddenOtpInput.is().notPlain();
    }

    @Test
    public void readOnlyOtpInputTest() {
        readOnlyOtpInput.is().readonly();
        hiddenOtpInput.is().notReadonly();
    }

    @Test
    public void typeOtpInputTest() {
        hiddenOtpInput.has().type("password");
        plainOtpInput.has().type("text");
        readOnlyOtpInput.has().type("number");
    }
}
