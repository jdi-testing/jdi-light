package io.github.epam.vuetify.tests.complex;

import io.github.com.enums.RadioTestData;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.radioButtonsPage;
import static io.github.com.enums.Colors.GREEN;
import static io.github.com.enums.Colors.RED;
import static io.github.com.enums.Colors.YELLOW;
import static io.github.com.pages.RadioButtonsPage.colorLeftRadioButtons;
import static io.github.com.pages.RadioButtonsPage.directionRadioButtons;
import static io.github.com.pages.RadioButtonsPage.disabledRadioButtons;
import static io.github.com.pages.RadioButtonsPage.errorRadioButtons;
import static io.github.com.pages.RadioButtonsPage.labelRadioButtons;
import static io.github.com.pages.RadioButtonsPage.mandatoryRadioButtons;
import static io.github.com.pages.RadioButtonsPage.mandatoryText;
import static io.github.com.pages.RadioButtonsPage.successRadioButtons;

public class RadioButtonsTests extends TestsInit {

    @BeforeClass
    public void before() {
        radioButtonsPage.open();
        waitCondition(() -> radioButtonsPage.isOpened());
        radioButtonsPage.checkOpened();
    }

    @Test(description = "Test checks radio button selection")
    public void selectEnumRadioButtonsTest() {
        colorLeftRadioButtons.show();
        colorLeftRadioButtons.select(RadioTestData.indigo);
        colorLeftRadioButtons.is().selected(RadioTestData.indigo);
        colorLeftRadioButtons.select(RadioTestData.orange);
        colorLeftRadioButtons.is().selected(RadioTestData.orange);
        colorLeftRadioButtons.select(RadioTestData.red);
        colorLeftRadioButtons.is().selected(RadioTestData.red);
    }

    @Test(description = "Test checks radio button value")
    public void valueRadioButtonsTest() {
        directionRadioButtons.show();
        directionRadioButtons.has().value("Option 1");
        directionRadioButtons.has().value("Option 2");
    }

    @Test(description = "Test checks if radio buttons is mandatory")
    public void mandatoryRadioButtonsTest() {
        refresh();
        mandatoryRadioButtons.show();
        mandatoryRadioButtons.is().selected("Radio 1");
        mandatoryText.is().text("radio-1");
    }

    @Test(description = "Test checks radio button's text")
    public void radioButtonLabelTest() {
        labelRadioButtons.show();
        labelRadioButtons.has().text("Definitely Duckduckgo");
    }

    @Test(description = "Test checks radio button's theme")
    public void themeRadioButtonTest() {
        directionRadioButtons.show();
        directionRadioButtons.has().darkTheme();
        directionRadioButtons.radioButtons().get(0).has().darkTheme();
        mandatoryRadioButtons.show();
        mandatoryRadioButtons.has().lightTheme();
        mandatoryRadioButtons.radioButtons().get(0).has().lightTheme();
    }

    @Test(description = "Test checks radio button's color")
    public void colorRadioButtonTest() {
        colorLeftRadioButtons.show();
        colorLeftRadioButtons.radioButtons().get(0).has().color(RED.value());
        successRadioButtons.show();
        successRadioButtons.has().backgroundColor(YELLOW.value());
        successRadioButtons.has().labelColor(GREEN.value());
        successRadioButtons.radioButtons().get(0).has().labelColor(GREEN.value());
    }

    @Test(description = "Test checks if radio button is disabled or not")
    public void disabledRadioButtonTest() {
        disabledRadioButtons.show();
        disabledRadioButtons.radioButtons().get(0).is().disabled();
        successRadioButtons.show();
        successRadioButtons.radioButtons().get(0).is().enabled();
    }

    @Test(description = "Test checks if radio button is readonly or not")
    public void readonlyRadioButtonTest() {
        successRadioButtons.show();
        successRadioButtons.is().readonly();
        disabledRadioButtons.show();
        disabledRadioButtons.is().notReadonly();
    }

    @Test(description = "Test checks if radio button is dense or not")
    public void denseRadioButtonTest() {
        errorRadioButtons.show();
        errorRadioButtons.is().dense();
        disabledRadioButtons.show();
        disabledRadioButtons.is().notDense();
    }

    @Test(description = "Test checks if radio button is success or not")
    public void successRadioButtonTest() {
        successRadioButtons.show();
        successRadioButtons.radioButtons().get(0).is().success();
        errorRadioButtons.show();
        errorRadioButtons.radioButtons().get(0).is().notSuccess();
    }

    @Test(description = "Test checks if radio button is error or not")
    public void errorRadioButtonTest() {
        errorRadioButtons.show();
        errorRadioButtons.radioButtons().get(0).is().error();
        successRadioButtons.show();
        successRadioButtons.radioButtons().get(0).is().notError();
    }

    @Test(description = "Test checks if radio button has messages or not")
    public void messagesRadioButtonTest() {
        successRadioButtons.show();
        successRadioButtons.has().messagesCount(1);
        successRadioButtons.has().messageText("some hint");
        successRadioButtons.has().successMessages();
        successRadioButtons.has().noErrorMessages();
    }
}
