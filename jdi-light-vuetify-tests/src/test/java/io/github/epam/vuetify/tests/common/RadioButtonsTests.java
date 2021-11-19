package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.elements.enums.Colors;
import com.epam.jdi.light.vuetify.elements.enums.RadioTestData;
import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.radioButtonsPage;
import static io.github.com.pages.RadioButtonsPage.*;
import static org.testng.Assert.assertEquals;

public class RadioButtonsTests extends TestsInit {


    @BeforeClass
    public void before() {
        radioButtonsPage.open();
    }

//    @Test
//    public void colorTest() {
//        jdiAssert(colorLeftRadioButtons.color(), Matchers.is(Colors.RED.value()));
//        colorLeftRadioButtons.select("indigo");
//        jdiAssert(colorLeftRadioButtons.color(), Matchers.is(Colors.INDIGO.value()));
//
//    }

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
