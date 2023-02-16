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
import static io.github.com.enums.Colors.RED;
import static io.github.com.enums.Colors.TRANSPARENT;
import static io.github.com.enums.Colors.YELLOW;
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

    @Test(description = "Test checks parameters of switch: color, text, functionality")
    public void functionalityAndCssStyleSwitchTest() {
        String red = "red";
        final Switch redSwitch = colorSwitches.get(1);
        redSwitch.show();
        redSwitch.is().checked();
        redSwitch.label().has().text(red);
        redSwitch.has().value(red);
        redSwitch.has().color(RED.value());
        redSwitch.has().detailsHidden();
        redSwitch.uncheck();
        redSwitch.is().unchecked();
    }

    @Test(description = "Test checks simple flat switches")
    public void flatSwitchesTest() {
        Switch flatSwitch = flatSwitches.get(1);
        Switch notFlatSwitch = variousAttributesSwitches.get(5);
        flatSwitch.show();
        flatSwitch.is().flat();
        notFlatSwitch.is().notFlat();
    }

    @Test(description = "Test checks that switches is inset or not")
    public void insetSwitchesTest() {
        Switch insetSwitch = insetSwitches.get(1);
        insetSwitch.show();
        insetSwitch.is().inset();
        colorSwitches.get(1).is().notInset();
    }

    @Test(description = "Test checks model as array of values switches works correctly")
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

    @Test(description = "Test checks model as boolean switches works correctly")
    public void modelAsBooleanSwitchesTest() {
        modelAsBooleanSwitches.get(1).show();
        modelAsBooleanSwitches.get(1).is().enabled();
        modelAsBooleanSwitches.get(1).label().has().text(Matchers.containsString("true"));
        modelAsBooleanSwitches.get(1).uncheck();
        modelAsBooleanSwitches.get(2).label().has().text(Matchers.containsString("false"));
    }

    @Test(description = "Test checks states of the switch: checked/unchecked/disabled")
    public void statesSwitchTest() {
        statesSwitches.get(3).show();
        statesSwitches.get(3).is().checked().and().disabled();
        statesSwitches.get(4).is().unchecked().and().disabled();
        statesSwitches.get(6).is().unchecked();
        statesSwitches.get(6).find("*[role = 'progressbar']").is().displayed();
    }

    @Test(description = "Test checks label the switch is correct")
    public void labelSwitchTest() {
        labelSwitches.show();
        labelSwitches.has().label();
        labelSwitches.label().has().text("Turn on the progress:");
        labelSwitches.is().unchecked();
        progressSpinnerLabelSwitches.has().hasNoLabel();
        progressSpinnerLabelSwitches.is().notSpinning();
        labelSwitches.check();
        progressSpinnerLabelSwitches.is().spinning();
    }

    @Test(description = "Test checks that switch has some icon append or not")
    public void iconAppendSwitchTest() {
        variousAttributesSwitches.get(1).show();
        variousAttributesSwitches.get(1).has().iconAppend();
        variousAttributesSwitches.get(3).has().notIconAppend();
    }

    @Test(description = "Test checks that switch has some icon prepend or not")
    public void iconPrependSwitchTest() {
        variousAttributesSwitches.get(1).show();
        variousAttributesSwitches.get(1).has().notIconPrepend();
        variousAttributesSwitches.get(3).has().iconPrepend();
    }

    @Test(description = "Test checks that switch has light or dark theme")
    public void themeSwitchTest() {
        variousAttributesSwitches.get(2).show();
        variousAttributesSwitches.get(2).has().darkTheme();
        variousAttributesSwitches.get(5).has().lightTheme();
    }

    @Test(description = "Test checks message of switch: message, success message and error message")
    public void switchMessagesTest() {
        String successMessage = "Success 1";
        variousAttributesSwitches.get(1).show();
        variousAttributesSwitches.get(1).has().message();
        variousAttributesSwitches.get(1).has().message(successMessage);
        variousAttributesSwitches.get(1).has().messages(Collections.singletonList(successMessage));
        variousAttributesSwitches.get(1).has().successMessage();
        variousAttributesSwitches.get(1).has().successMessage(successMessage);
        variousAttributesSwitches.get(1).has().successMessages(Collections.singletonList(successMessage));
        variousAttributesSwitches.get(1).has().notErrorMessage();
        variousAttributesSwitches.get(3).has().errorMessage();
        variousAttributesSwitches.get(3).has().errorMessage("First");
        variousAttributesSwitches.get(3).has().numberOfErrorMessages(2);
        variousAttributesSwitches.get(3).has().errorMessages(Arrays.asList("First", "Second"));
        variousAttributesSwitches.get(3).has().notSuccessMessage();
        variousAttributesSwitches.get(5).has().message();
        variousAttributesSwitches.get(5).has().messages(Collections.singletonList("Some hint"));
        variousAttributesSwitches.get(5).is().notDetailsHidden();
        flatSwitches.get(1).show();
        flatSwitches.get(1).has().notMessage();
    }

    @Test(description = "Test checks dense of the switch")
    public void denseSwitchTest() {
        variousAttributesSwitches.get(1).show();
        variousAttributesSwitches.get(1).is().dense();
        variousAttributesSwitches.get(5).is().notDense();
    }

    @Test(description = "Test checks that switch is 'readonly' and not")
    public void readonlySwitchTest() {
        variousAttributesSwitches.get(4).show();
        variousAttributesSwitches.get(4).is().readonly();
        variousAttributesSwitches.get(5).is().notReadonly();
    }

    @Test(description = "Test checks that switch has a ripple")
    public void rippleSwitchTest() {
        variousAttributesSwitches.get(1).show();
        variousAttributesSwitches.get(1).has().ripple();
    }

    @Test(description = "Test checks background colors of switches")
    public void backgroundColorSwitchesTest() {
        variousAttributesSwitches.get(1).show();
        variousAttributesSwitches.get(4).has().backgroundColor(TRANSPARENT.value());
        variousAttributesSwitches.get(4).has().slotsBackgroundColor(YELLOW.value());
    }
}

