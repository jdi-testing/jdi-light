package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.buttonFrame;
import static io.github.com.StaticSite.inputButtonDefaultPage;
import static io.github.com.StaticSite.inputButtonDisabledPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.fail;

public class ButtonTests extends TestsInit {

    @Test
    public void defaultButtonTest() {
        inputButtonDefaultPage.open();

        buttonFrame.button.click();
        buttonFrame.button.is().enabled();
        buttonFrame.button.has().text(containsString("BUTTON"));
    }

    @Test
    public void disabledButtonTest() {
        inputButtonDisabledPage.shouldBeOpened();

        buttonFrame.button.is().disabled();
        try {
            buttonFrame.button.click();
            fail("Disabled button shouldn't work, but it does");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                    containsString("Can't perform click. Element is disabled"));
        }
    }

}
