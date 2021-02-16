package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.LinqUtils.safeException;
import static io.github.com.StaticSite.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.fail;

public class RadioTests extends TestsInit {

    @Test
    public void defaultRadioTest() {
        radioDefaultPage.open();

        radioFrame.firstRadio.is().enabled();
        radioFrame.secondRadio.is().enabled();
        radioFrame.thirdRadio.is().enabled();
        radioFrame.disabledRadio.is().disabled();

        radioFrame.firstRadio.is().unchecked();
        radioFrame.secondRadio.is().unchecked();
        radioFrame.thirdRadio.is().unchecked();
        radioFrame.disabledRadio.is().unchecked();

        radioFrame.firstRadio.toggle();
        radioFrame.firstRadio.is().checked();
        radioFrame.secondRadio.is().unchecked();
        radioFrame.thirdRadio.is().unchecked();
        radioFrame.disabledRadio.is().unchecked();
        radioFrame.textField.is().text(containsString("First"));

        radioFrame.secondRadio.toggle();
        radioFrame.firstRadio.is().unchecked();
        radioFrame.secondRadio.is().checked();
        radioFrame.thirdRadio.is().unchecked();
        radioFrame.disabledRadio.is().unchecked();
        radioFrame.textField.is().text(containsString("Second"));

        try {
            radioFrame.disabledRadio.toggle();
            fail("Disabled button shouldn't work, but it does");
        } catch (Exception ex) {
            assertThat(safeException(ex),
                    containsString("element click intercepted"));
        }
        radioFrame.firstRadio.is().unchecked();
        radioFrame.secondRadio.is().checked();
        radioFrame.thirdRadio.is().unchecked();
        radioFrame.disabledRadio.is().unchecked();
    }
}
