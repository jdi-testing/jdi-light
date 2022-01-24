package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Switch;
import io.github.com.enums.Colors;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.tools.Timer.waitCondition;
import static io.github.com.StaticSite.switchesPage;
import static io.github.com.pages.SwitchesPage.colorSwitches;
import static io.github.com.pages.SwitchesPage.flatSwitches;
import static io.github.com.pages.SwitchesPage.modelAsArraySwitches;
import static io.github.com.pages.SwitchesPage.modelArray;
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
    public void colorTest() {
        final Switch redSwitch = colorSwitches.get(1);
        redSwitch.is().inputColor(Colors.RED.value());
        redSwitch.uncheck();
        waitCondition(() -> redSwitch.getInputColor().equals(Colors.BLACK_TRANSPARENT_087.value()));
        redSwitch.is().inputColor(Colors.BLACK_TRANSPARENT_087.value());

        final Switch orangeDarkenSwitch = colorSwitches.get(6);
        orangeDarkenSwitch.is().inputColor(Colors.ORANGE_DARKEN_3.value());
        orangeDarkenSwitch.uncheck();
        waitCondition(() -> orangeDarkenSwitch.getInputColor().equals(Colors.BLACK_TRANSPARENT_087.value()));
        orangeDarkenSwitch.is().inputColor(Colors.BLACK_TRANSPARENT_087.value());

        final Switch redAccentSwitch = colorSwitches.get(12);
        redAccentSwitch.is().inputColor(Colors.RED_ACCENT_2.value());
        redAccentSwitch.uncheck();
        waitCondition(() -> redAccentSwitch.getInputColor().equals(Colors.BLACK_TRANSPARENT_087.value()));
        redAccentSwitch.is().inputColor(Colors.BLACK_TRANSPARENT_087.value());
    }

    @Test
    public void flatSwitch() {
        flatSwitches.forEach(s -> {
            s.isDisabled();
            s.check();
            s.is().labelContains("true");
            s.uncheck();
            s.is().labelContains("false");
        });
    }

    @Test
    public void insertSwitch() {
        flatSwitches.forEach(s -> {
            s.isDisabled();
            s.check();
            s.is().labelContains("true");
            s.uncheck();
            s.is().labelContains("false");
        });
    }

    @Test
    public void arraySwitch() {
        modelAsArraySwitches.forEach(Switch::isDisabled);
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
    public void statesSwitch() {
        statesSwitches.forEach(Switch::isDisabled);
        statesSwitches.get(1).is().checked();
        statesSwitches.get(2).is().unchecked();
        statesSwitches.get(3).is().checked();
        statesSwitches.get(3).is().disabled();
        statesSwitches.get(4).is().unchecked();
        statesSwitches.get(4).is().disabled();
        statesSwitches.get(5).is().checked();
        statesSwitches.get(5).is().inputProgressBar();
        statesSwitches.get(6).is().unchecked();
        statesSwitches.get(6).is().inputProgressBar();
    }

    @Test
    public void labelSwitch() {
        labelSwitches.forEach(Switch::isDisabled);
        labelSwitches.get(1).is().labelHTML();
    }
}
