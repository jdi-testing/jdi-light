package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.buttonFrame;
import static io.github.com.StaticSite.inputButtonDefaultPage;
import static io.github.com.StaticSite.inputButtonDisabledPage;
import static org.hamcrest.Matchers.containsString;

public class ButtonTests extends TestsInit {

    @Test
    public void defaultButtonTest() {
        inputButtonDefaultPage.open();

        buttonFrame.button.is().enabled();
        buttonFrame.button.click();
        buttonFrame.button.has().text(containsString("BUTTON"));
    }

    @Test(expectedExceptions = {RuntimeException.class})
    public void disabledButtonTest() {
        inputButtonDisabledPage.shouldBeOpened();

        buttonFrame.button.is().disabled();
    }

}
