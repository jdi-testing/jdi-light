package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Switch;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.switchesPage;
import static io.github.com.pages.SwitchesPage.colorSwitches;
import static io.github.com.pages.SwitchesPage.modelAsArraySwitches;
import static io.github.com.pages.SwitchesPage.modelArray;
import static io.github.com.pages.SwitchesPage.modelAsBooleanSwitches;
import static io.github.com.pages.SwitchesPage.progressSpinnerLabelSwitches;
import static io.github.com.pages.SwitchesPage.statesSwitches;
import static io.github.com.pages.SwitchesPage.labelSwitches;

public class SwitchTests extends TestsInit {

    @BeforeClass
    public void before() {
        switchesPage.open();
        waitCondition(() -> switchesPage.isOpened());
        switchesPage.checkOpened();
    }

    @Test
    public void functionalityAndCssStyleSwitchTest() {
        final Switch redSwitch = colorSwitches.get(1);
        redSwitch.show();
        redSwitch.is().checked();
        redSwitch.is().inputColor(Colors.RED.value());
        redSwitch.label().is().text("red");
        redSwitch.uncheck();
        redSwitch.is().unchecked();
    }

    @Test
    public void arraySwitchTest() {
        modelAsArraySwitches.get(1).is().checked();
        modelAsArraySwitches.get(2).is().unchecked();
        modelArray.is().text("[ \"John\" ]");
        modelAsArraySwitches.get(2).check();
        modelArray.is().text("[ \"John\", \"Jacob\" ]");
        modelAsArraySwitches.get(1).uncheck();
        modelAsArraySwitches.get(2).uncheck();
        modelArray.is().text("[]");
    }

    @Test
    public void modelAsBooleanSwitchesTest() {
        modelAsBooleanSwitches.get(1).is().enabled();
        modelAsBooleanSwitches.get(1).is().labelContains("true");
        modelAsBooleanSwitches.get(1).uncheck();
        modelAsBooleanSwitches.get(1).is().labelContains("false");
    }

    @Test
    public void statesSwitchTest() {
        statesSwitches.get(3).is().checked();
        statesSwitches.get(3).is().disabled();
        statesSwitches.get(4).is().unchecked();
        statesSwitches.get(4).is().disabled();
        statesSwitches.get(6).is().unchecked();
        statesSwitches.get(6).find(".v-input--switch__thumb div[role = 'progressbar']").is().displayed();
        ;
    }

    @Test
    public void labelSwitchTest() {
        labelSwitches.is().unchecked();
        progressSpinnerLabelSwitches.is().notSpinning();
        labelSwitches.check();
        progressSpinnerLabelSwitches.is().spinning();
    }
}

