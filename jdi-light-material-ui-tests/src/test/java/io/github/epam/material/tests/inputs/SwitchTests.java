package io.github.epam.material.tests.inputs;

import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.switchPage;
import static org.hamcrest.Matchers.containsString;
import static io.github.com.pages.inputs.SwitchPage.*;
import static org.hamcrest.Matchers.not;

/**
 * To see an example of Switch web element please visit https://material-ui.com/components/switches/
 */

public class SwitchTests extends TestsInit {

    private static Timer timer = new Timer(1000L);

    @BeforeMethod
    public void before() {
        switchPage.open();
    }

    @Test
    public void basicSwitchesTest() {

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
