package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.common.Switch;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.switchesPage;
import static io.github.com.pages.SwitchesPage.colorSwitches;
import static io.github.com.pages.SwitchesPage.flatSwitches;
import static io.github.com.pages.SwitchesPage.insetSwitches;
import static io.github.com.pages.SwitchesPage.labelSwitches;
import static io.github.com.pages.SwitchesPage.modelArray;
import static io.github.com.pages.SwitchesPage.modelAsArraySwitches;
import static io.github.com.pages.SwitchesPage.modelAsBooleanSwitches;
import static io.github.com.pages.SwitchesPage.progressSpinnerLabelSwitches;
import static io.github.com.pages.SwitchesPage.statesSwitches;
import static io.github.com.pages.SwitchesPage.variousAttributesSwitches;

public class SwitchesTests extends TestsInit {

    @BeforeClass
    public void before() {
        switchesPage.open();
        waitCondition(() -> switchesPage.isOpened());
        switchesPage.checkOpened();
    }

    @Test
    public void functionalityAndCssStyleSwitchTest() {
        final Switch redSwitch = colorSwitches.get(1);
        String red = "red";
        redSwitch.show();
        redSwitch.is().checked();
        redSwitch.has().label();
        redSwitch.label().has().text(red);
        redSwitch.has().value(red);
        redSwitch.has().color("rgba(244, 67, 54, 1)");
        redSwitch.has().detailsHidden();
        redSwitch.uncheck();
        redSwitch.is().unchecked();
    }

    @Test
    public void flatSwitchesTest() {
        Switch flatSwitch = flatSwitches.get(1);
        flatSwitch.show();
        flatSwitch.is().flat();
        flatSwitch.is().notInset();
        flatSwitch.is().lightTheme();
        flatSwitch.has().notMessages();
    }

    @Test
    public void insetSwitchesTest() {
        Switch insetSwitch = insetSwitches.get(1);
        insetSwitch.show();
        insetSwitch.is().inset();
    }

    @Test
    public void arraySwitchTest() {
        modelAsArraySwitches.get(1).show();
        modelAsArraySwitches.get(1).is().checked();
        modelAsArraySwitches.get(2).is().unchecked();
        modelArray.has().text("[ \"John\" ]");
        modelAsArraySwitches.get(2).check();
        modelArray.has().text("[ \"John\", \"Jacob\" ]");
        modelAsArraySwitches.get(1).uncheck();
        modelAsArraySwitches.get(2).uncheck();
        modelArray.is().text("[]");
    }

    @Test
    public void modelAsBooleanSwitchesTest() {
        modelAsBooleanSwitches.get(1).show();
        modelAsBooleanSwitches.get(1).is().enabled();
        modelAsBooleanSwitches.get(1).has().label();
        modelAsBooleanSwitches.get(1).label().has().text(Matchers.containsString("true"));
        modelAsBooleanSwitches.get(1).uncheck();
        modelAsBooleanSwitches.get(2).has().label();
        modelAsBooleanSwitches.get(2).label().has().text(Matchers.containsString("false"));
    }

    @Test
    public void statesSwitchTest() {
        statesSwitches.get(3).show();
        statesSwitches.get(3).has().notLabel();
        statesSwitches.get(3).is().checked().and().disabled();
        statesSwitches.get(4).has().notLabel();
        statesSwitches.get(4).is().unchecked().and().disabled();
        statesSwitches.get(6).has().notLabel();
        statesSwitches.get(6).is().unchecked();
        statesSwitches.get(6).find("*[role = 'progressbar']").is().displayed();
    }

    @Test
    public void labelSwitchTest() {
        labelSwitches.show();
        labelSwitches.has().label();
        labelSwitches.has().labelText("Turn on the progress:");
        labelSwitches.is().unchecked();
        progressSpinnerLabelSwitches.has().hasNoLabel();
        progressSpinnerLabelSwitches.is().notSpinning();
        labelSwitches.check();
        progressSpinnerLabelSwitches.is().spinning();
    }

    @Test
    public void variousAttributesSwitchesTest() {
        variousAttributesSwitches.get(1).show();
        variousAttributesSwitches.get(1).has().iconAppend();
        variousAttributesSwitches.get(1).has().notIconPrepend();
        variousAttributesSwitches.get(1).is().dense();
        variousAttributesSwitches.get(1).has().messages();
        variousAttributesSwitches.get(1).has().successMessages();
        variousAttributesSwitches.get(1).has().successMessages(Collections.singletonList("Success 1"));
        variousAttributesSwitches.get(1).has().notErrorMessages();
        variousAttributesSwitches.get(2).has().darkTheme();
        variousAttributesSwitches.get(3).has().iconPrepend();
        variousAttributesSwitches.get(3).has().notIconAppend();
        variousAttributesSwitches.get(3).has().errorMessages();
        variousAttributesSwitches.get(3).has().numberOfErrorMessages(2);
        variousAttributesSwitches.get(3).has().errorMessages(Arrays.asList("First", "Second"));
        variousAttributesSwitches.get(3).has().notSuccessMessages();
        variousAttributesSwitches.get(4).is().readonly();
        variousAttributesSwitches.get(4).has().backgroundColor("rgba(0, 0, 0, 0)");
        variousAttributesSwitches.get(4).has().slotsBackgroundColor("rgba(255, 235, 59, 1)");
        variousAttributesSwitches.get(5).is().notReadonly();
        variousAttributesSwitches.get(5).has().ripple();
        variousAttributesSwitches.get(5).is().notDense();
        variousAttributesSwitches.get(5).is().detailsNotHidden();
        variousAttributesSwitches.get(5).is().notFlat();
        variousAttributesSwitches.get(5).has().messages();
        variousAttributesSwitches.get(5).has().messages(Collections.singletonList("Some hint"));
    }
}

