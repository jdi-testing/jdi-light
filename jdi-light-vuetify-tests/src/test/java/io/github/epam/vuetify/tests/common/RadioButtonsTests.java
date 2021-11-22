package io.github.epam.vuetify.tests.common;

import io.github.com.enums.RadioTestData;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.radioButtonsPage;
import static io.github.com.pages.RadioButtonsPage.colorLeftRadioButtons;
import static io.github.com.pages.RadioButtonsPage.colorRightRadioButtons;
import static io.github.com.pages.RadioButtonsPage.directionRadioButtons;
import static io.github.com.pages.RadioButtonsPage.mandatoryRadioButtons;
import static io.github.com.pages.RadioButtonsPage.labelRadioButtons;
import static io.github.com.pages.RadioButtonsPage.mandatoryText;

public class RadioButtonsTests extends TestsInit {

    @BeforeClass
    public void before() {
        radioButtonsPage.open();
    }

    @Test
    public void selectTest() {
        colorLeftRadioButtons.select("indigo");
        colorLeftRadioButtons.is().selected("indigo");
        colorRightRadioButtons.select("success");
        colorRightRadioButtons.is().selected("success");
    }

    @Test
    public void getValueTest() {
        directionRadioButtons.has().value("Option 1");
        directionRadioButtons.has().value("Option 2");
    }

    @Test
    public void selectEnumTest() {
        colorLeftRadioButtons.select(RadioTestData.indigo);
        colorLeftRadioButtons.is().selected(RadioTestData.indigo);
        colorLeftRadioButtons.select(RadioTestData.orange);
        colorLeftRadioButtons.is().selected(RadioTestData.orange);
        colorLeftRadioButtons.select(RadioTestData.red);
        colorLeftRadioButtons.is().selected(RadioTestData.red);
    }

    @Test
    public void mandatoryTest() {
        mandatoryRadioButtons.select("Radio 2");
        mandatoryText.is().text("radio-2");
    }

    @Test
    public void labelTest() {
        labelRadioButtons.has().value("Of course it's Google");
        labelRadioButtons.has().text("Definitely Duckduckgo");
    }
}
