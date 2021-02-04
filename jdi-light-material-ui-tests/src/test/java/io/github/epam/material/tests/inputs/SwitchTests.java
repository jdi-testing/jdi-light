package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.inputSwitchDefaultPage;
import static io.github.com.StaticSite.inputSwitchDisabledAndCheckedPage;
import static io.github.com.StaticSite.inputSwitchDisabledPage;
import static io.github.com.StaticSite.switchFrame;

public class SwitchTests extends TestsInit {

    @Test
    public void defaultSwitchTest() {
        inputSwitchDefaultPage.shouldBeOpened();

        switchFrame.aSwitch.is().enabled();
        switchFrame.aSwitch.is().unchecked();
        switchFrame.aSwitch.toggle();
        switchFrame.aSwitch.is().checked();

        switchFrame.aSwitch.toggle();
        switchFrame.aSwitch.isUnchecked();
    }

    @Test
    public void disabledSwitchTest() {
        inputSwitchDisabledPage.shouldBeOpened();

        switchFrame.aSwitch.is().disabled();
        switchFrame.aSwitch.is().unchecked();
        switchFrame.aSwitch.toggle();
        switchFrame.aSwitch.is().unchecked();
    }

    @Test
    public void disabledAndCheckedSwitchTest() {
        inputSwitchDisabledAndCheckedPage.shouldBeOpened();

        switchFrame.aSwitch.is().disabled();

        switchFrame.aSwitch.is().checked();
        switchFrame.aSwitch.toggle();
        switchFrame.aSwitch.is().checked();
    }
}
