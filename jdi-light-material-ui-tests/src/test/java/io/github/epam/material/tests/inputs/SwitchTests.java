package io.github.epam.material.tests.inputs;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static io.github.com.pages.inputs.SwitchPage.*;
import static io.github.com.MaterialNavigator.openSection;
import static org.hamcrest.Matchers.not;

/**
 * To see an example of Switch web element please visit https://material-ui.com/components/switches/
 */

public class SwitchTests extends TestsInit {

    private static Timer timer = new Timer(1000L);

    @BeforeTest
    public void before() {
        openSection("Switch");
    }

    @Test
    public void basicSwitchesTest() {

        timer.wait(() -> switches.get(1).is().displayed());
        switches.get(1).is().classValue(containsString("MuiSwitch-colorSecondary"));
        switches.get(1).is().classValue(containsString("Mui-checked"));
        switches.get(1).click();
        switches.get(1).is().classValue(not(containsString("Mui-checked")));

        switches.get(2).is().classValue(containsString("MuiSwitch-colorPrimary"));
        switches.get(2).is().classValue(containsString("Mui-checked"));
        switches.get(2).click();
        switches.get(2).is().classValue(not(containsString("Mui-checked")));

        switches.get(3).is().classValue(containsString("MuiSwitch-colorSecondary"));
        switches.get(3).is().classValue(not(containsString("Mui-checked")));
        switches.get(3).click();
        switches.get(3).is().classValue(containsString("Mui-checked"));

        switches.get(4).is().classValue(containsString("MuiSwitch-colorSecondary"));
        switches.get(4).is().classValue(containsString("Mui-disabled"));

        switches.get(5).is().classValue(containsString("MuiSwitch-colorSecondary"));
        switches.get(5).is().classValue(containsString("Mui-disabled"));
        switches.get(5).is().classValue(containsString("Mui-checked"));

        switches.get(6).is().classValue(containsString("Mui-checked"));
        switches.get(6).click();
        switches.get(6).is().classValue(not(containsString("Mui-checked")));
    }

    @Test
    public void switchesWithFormGroupTest() {

        formGroupTextForm.is().text("Be careful");

        switches.get(7).is().classValue(containsString("Mui-checked"));
        switches.get(7).click();
        switches.get(7).is().classValue(not(containsString("Mui-checked")));
        switches.get(7).click();
        formGroupTextForm.is().text("Be careful with gilad");

        switches.get(8).is().classValue(not(containsString("Mui-checked")));
        switches.get(8).click();
        switches.get(8).is().classValue(containsString("Mui-checked"));
        formGroupTextForm.is().text("Be careful with jason");

        switches.get(9).is().classValue(containsString("Mui-checked"));
        switches.get(9).click();
        switches.get(9).is().classValue(not(containsString("Mui-checked")));
        switches.get(9).click();
        formGroupTextForm.is().text("Be careful with antoine");
    }
}
