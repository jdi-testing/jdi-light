package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Switch;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.switchPage;
import static io.github.com.pages.inputs.SwitchPage.basicSwitches;
import static io.github.com.pages.inputs.SwitchPage.formGroupSwitches;
import static io.github.com.pages.inputs.SwitchPage.formGroupTextForm;

public class SwitchTests extends TestsInit {

    @BeforeMethod
    public void before() {
        switchPage.open();
        switchPage.isOpened();
    }

    @Test
    public void basicFunctionalitySwitchTest() {
        Switch muiSwitch = basicSwitches.get(1);
        muiSwitch.show();
        muiSwitch.uncheck();
        muiSwitch.is().unchecked();
        muiSwitch.check();
        muiSwitch.is().checked();
    }

    @Test
    public void disabledSwitchTest() {
        Switch muiSwitch = basicSwitches.get(4);
        muiSwitch.show();
        muiSwitch.is().disabled();
        muiSwitch.check();
        muiSwitch.is().unchecked();
    }

    @Test()
    public void switchesWithFormGroupTest() {
        formGroupTextForm.is().text("Be careful");
        Switch muiSwitch = formGroupSwitches.get(1);
        muiSwitch.show();
        muiSwitch.uncheck();
        muiSwitch.is().unchecked();
        muiSwitch.check();
        muiSwitch.is().checked();
        formGroupTextForm.is().text("Be careful with gilad");
        muiSwitch.has().label();
        muiSwitch.has().labelText("Gilad Gray");
    }
}
