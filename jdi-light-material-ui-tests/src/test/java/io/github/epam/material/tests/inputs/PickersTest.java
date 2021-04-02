package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.PickersFrame.pickers;
import static org.hamcrest.Matchers.hasToString;

public class PickersTest extends TestsInit {

    @Test
    public void defaultDateAndTimeTest() {
        openSection("Date / Time");
        basicCheck();
    }

    public void basicCheck() {
        pickers.is().displayed(1);
        pickers.is().text(1, hasToString("08/18/2014"));
    }
}
