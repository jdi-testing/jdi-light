package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Switch;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
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
        redSwitch.has().hasLabel();
        redSwitch.label().has().text("red");
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
        modelAsBooleanSwitches.get(1).has().hasLabel();
        modelAsBooleanSwitches.get(1).label().has().text(Matchers.containsString("true"));
        modelAsBooleanSwitches.get(1).uncheck();
        modelAsBooleanSwitches.get(2).has().hasLabel();
        modelAsBooleanSwitches.get(2).label().has().text(Matchers.containsString("false"));
    }

    @Test
    public void statesSwitchTest() {
        statesSwitches.get(3).has().hasNoLabel();
        statesSwitches.get(3).is().checked().and().disabled();
        statesSwitches.get(4).has().hasNoLabel();
        statesSwitches.get(4).is().unchecked().and().disabled();
        statesSwitches.get(6).has().hasNoLabel();
        statesSwitches.get(6).is().unchecked();
        statesSwitches.get(6).find("*[role = 'progressbar']").is().displayed();
    }

    @Test
    public void labelSwitchTest() {
        labelSwitches.has().hasLabel();
        labelSwitches.is().unchecked();
        progressSpinnerLabelSwitches.has().hasNoLabel();
        progressSpinnerLabelSwitches.is().notSpinning();
        labelSwitches.check();
        progressSpinnerLabelSwitches.is().spinning();
    }
}

