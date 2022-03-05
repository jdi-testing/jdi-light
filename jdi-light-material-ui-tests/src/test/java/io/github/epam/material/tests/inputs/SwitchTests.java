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

    @Test
    public void basicFunctionalityAndCssStyleSwitchTest() {
        basicSwitches.get(1).has().secondaryColor();
        basicSwitches.get(1).unchecked();
        basicSwitches.get(1).is().unchecked();
        basicSwitches.get(1).checked();
        basicSwitches.get(1).is().checked();

        basicSwitches.get(2).has().primaryColor();

        basicSwitches.get(3).checked();
        basicSwitches.get(3).has().secondaryColor();

        basicSwitches.get(4).is().disabled();
        basicSwitches.get(4).checked();
        basicSwitches.get(4).is().unchecked();

        basicSwitches.get(4).is().disabled();
        basicSwitches.get(5).unchecked();
        basicSwitches.get(5).is().checked();
    }

    @Test(dataProvider = "switchesWithFormGroupTestsDataProvider")
    public void switchesWithFormGroupTest(int index, String fullName) {
        formGroupTextForm.is().text("Be careful");
        switchWithLabelTestLogic(formGroupSwitches.get(index),fullName);
    }

    private void switchWithLabelTestLogic(Switch muiSwitch, String labelText){
        String firstName = Arrays.stream(labelText.split(" "))
                .collect(Collectors.toList())
                .get(0)
                .toLowerCase();
        muiSwitch.unchecked();
        muiSwitch.is().unchecked();
        muiSwitch.checked();
        muiSwitch.is().checked();
        formGroupTextForm.is().text(String.format("Be careful with %s", firstName));
        muiSwitch.has().label();
        muiSwitch.has().labelText(labelText);
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
