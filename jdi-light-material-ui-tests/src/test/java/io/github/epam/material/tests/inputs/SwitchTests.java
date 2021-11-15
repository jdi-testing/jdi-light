package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Switch;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.switchPage;
import static io.github.com.pages.inputs.SwitchPage.basicSwitches;
import static io.github.com.pages.inputs.SwitchPage.formGroupTextForm;
import static io.github.com.pages.inputs.SwitchPage.switches;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class SwitchTests extends TestsInit {

    @BeforeMethod
    public void before() {
        switchPage.open();
    }

    @Test
    public void basicSwitchesTest() {
        basicSwitchTestLogic(basicSwitches.get(1));
        basicSwitchTestLogic(basicSwitches.get(2));
        basicSwitchTestLogic(basicSwitches.get(3));
        basicSwitchTestLogic(basicSwitches.get(4));
        basicSwitchTestLogic(basicSwitches.get(5));
        basicSwitchTestLogic(basicSwitches.get(6));
    }

    @Test
    public void switchesWithFormGroupTest() {

        formGroupTextForm.is().text("Be careful");

        switches.get(7).is().classValue(containsString("Mui-checked"));
        switches.get(7).uncheck();
        switches.get(7).is().classValue(not(containsString("Mui-checked")));
        switches.get(7).check();
        formGroupTextForm.is().text("Be careful with gilad");

        switches.get(8).is().classValue(not(containsString("Mui-checked")));
        switches.get(8).check();
        switches.get(8).is().classValue(containsString("Mui-checked"));
        formGroupTextForm.is().text("Be careful with jason");

        switches.get(9).is().classValue(containsString("Mui-checked"));
        switches.get(9).uncheck();
        switches.get(9).is().classValue(not(containsString("Mui-checked")));
        switches.get(9).check();
        formGroupTextForm.is().text("Be careful with antoine");
    }

    private void basicSwitchTestLogic(Switch muiSwitch) {
        muiSwitch.is().displayed();
        if(muiSwitch.hasPrimaryColor()) {
            muiSwitch.has().primaryColor();
        } else if(muiSwitch.hasSecondaryColor()) {
            muiSwitch.has().secondaryColor();
        } else muiSwitch.has().undefinedColor();
        if (muiSwitch.isDisabled()) {
            muiSwitch.is().disabled();
            if (muiSwitch.isTurnedOff()) {
                muiSwitch.is().turnedOff();
                muiSwitch.turnOn();
                muiSwitch.is().turnedOff();
            } else {
                muiSwitch.is().turnedOn();
                muiSwitch.turnOff();
                muiSwitch.is().turnedOn();
            }
        } else {
            muiSwitch.is().enabled();
            if (muiSwitch.isTurnedOff()) {
                muiSwitch.is().turnedOff();
                muiSwitch.turnOn();
                muiSwitch.is().turnedOn();
            } else {
                muiSwitch.is().turnedOn();
                muiSwitch.turnOff();
                muiSwitch.is().turnedOff();
            }
        }
    }
}
