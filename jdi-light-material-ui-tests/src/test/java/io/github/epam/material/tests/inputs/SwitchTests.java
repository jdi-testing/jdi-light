package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Switch;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static io.github.com.StaticSite.switchPage;
import static io.github.com.pages.inputs.SwitchPage.basicSwitches;
import static io.github.com.pages.inputs.SwitchPage.formGroupSwitches;
import static io.github.com.pages.inputs.SwitchPage.formGroupTextForm;

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
        switchWithLabelTestLogic(formGroupSwitches.get(1),"Gilad Gray");
        switchWithLabelTestLogic(formGroupSwitches.get(2),"Jason Killian");
        switchWithLabelTestLogic(formGroupSwitches.get(3),"Antoine Llorca");
    }

    private void basicSwitchTestLogic(Switch muiSwitch) {
        muiSwitch.is().displayed();
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
        if(muiSwitch.hasPrimaryColor()) {
            muiSwitch.has().primaryColor();
        } else if(muiSwitch.hasSecondaryColor()) {
            muiSwitch.has().secondaryColor();
        } else muiSwitch.has().undefinedColor();
    }

    private void switchWithLabelTestLogic(Switch muiSwitch, String labelText){
        String firstName = Arrays.stream(labelText.split(" "))
                .collect(Collectors.toList())
                .get(0)
                .toLowerCase();
        basicSwitchTestLogic(muiSwitch);
        muiSwitch.has().label();
        muiSwitch.has().labelText(labelText);
        if(muiSwitch.isTurnedOn()) {
            muiSwitch.turnOff();
        }
        muiSwitch.turnOn();
        formGroupTextForm.is().text(String.format("Be careful with %s", firstName));
    }

}
