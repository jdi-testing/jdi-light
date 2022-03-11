package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Switch;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
        switchPage.isOpened();
    }

    @Test(dataProvider = "basicSwitchesTestsDataProvider")
    public void basicSwitchesTest(int index) {
        basicSwitchTestLogic(basicSwitches.get(index));
    }

    @Test(dataProvider = "switchesWithFormGroupTestsDataProvider")
    public void switchesWithFormGroupTest(int index, String fullName) {
        formGroupTextForm.is().text("Be careful");
        switchWithLabelTestLogic(formGroupSwitches.get(index),fullName);
    }

    // TODO: This is not a test
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
        }
        if (muiSwitch.hasSecondaryColor()) {
            muiSwitch.has().secondaryColor();
        }
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

    @DataProvider(name = "basicSwitchesTestsDataProvider")
    public static Object[][] basicSwitchesTestsData() {
        return new Object[][] {
                {1},
                {2},
                {3},
                {4},
                {5},
                {6}
        };
    }

    @DataProvider(name = "switchesWithFormGroupTestsDataProvider")
    public static Object[][] switchesWithFormGroupTestsData() {
        return new Object[][] {
                {1, "Gilad Gray"},
                {2, "Jason Killian"},
                {3, "Antoine Llorca"}
        };
    }
}
