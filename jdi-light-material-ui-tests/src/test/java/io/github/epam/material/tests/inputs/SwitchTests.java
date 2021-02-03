package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.inputSwitchDefaultPage;
import static io.github.com.StaticSite.inputSwitchDisabledAndCheckedPage;
import static io.github.com.StaticSite.inputSwitchDisabledPage;
import static io.github.com.StaticSite.materialPageFrame;

public class SwitchTests extends TestsInit {

    @Test
    public void defaultSwitchTest() {
        inputSwitchDefaultPage.shouldBeOpened();

        materialPageFrame.aSwitch.is().enabled();
        materialPageFrame.aSwitch.is().unchecked();
        materialPageFrame.aSwitch.toggle();
        materialPageFrame.aSwitch.is().checked();

        materialPageFrame.aSwitch.toggle();
        materialPageFrame.aSwitch.isUnchecked();
    }

    @Test
    public void disabledSwitchTest() {
        inputSwitchDisabledPage.shouldBeOpened();

        materialPageFrame.aSwitch.is().disabled();

        materialPageFrame.aSwitch.is().unchecked();
        materialPageFrame.aSwitch.toggle();
        materialPageFrame.aSwitch.is().unchecked();
    }

    @Test
    public void disabledAndCheckedSwitchTest() {
        inputSwitchDisabledAndCheckedPage.shouldBeOpened();

        materialPageFrame.aSwitch.is().disabled();

        materialPageFrame.aSwitch.is().checked();
        materialPageFrame.aSwitch.toggle();
        materialPageFrame.aSwitch.is().checked();
    }
}
