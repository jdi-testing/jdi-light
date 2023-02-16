package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.google.common.collect.ImmutableList;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SliderTestsDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slidersPage;
import static io.github.com.enums.Colors.BLUE_ACCENT_5;
import static io.github.com.enums.Colors.ORANGE_DARKEN_3;
import static io.github.com.pages.SlidersPage.adjustableSlider;
import static io.github.com.pages.SlidersPage.appendTextField;
import static io.github.com.pages.SlidersPage.appendTextFieldSlider;
import static io.github.com.pages.SlidersPage.colorsSlider;
import static io.github.com.pages.SlidersPage.denseSwitch;
import static io.github.com.pages.SlidersPage.disabledSlider;
import static io.github.com.pages.SlidersPage.disabledSliderControl;
import static io.github.com.pages.SlidersPage.discreteSlider;
import static io.github.com.pages.SlidersPage.errorCountTextField;
import static io.github.com.pages.SlidersPage.heightTextField;
import static io.github.com.pages.SlidersPage.hideDetailsSwitch;
import static io.github.com.pages.SlidersPage.iconsSlider;
import static io.github.com.pages.SlidersPage.inverseLabelSlider;
import static io.github.com.pages.SlidersPage.loaderHeightTextField;
import static io.github.com.pages.SlidersPage.loadingSwitch;
import static io.github.com.pages.SlidersPage.readonlySlider;
import static io.github.com.pages.SlidersPage.stepSlider;
import static io.github.com.pages.SlidersPage.successMessageTextField;
import static io.github.com.pages.SlidersPage.themeSwitch;
import static io.github.com.pages.SlidersPage.thumbSlider;
import static io.github.com.pages.SlidersPage.ticksSlider;
import static io.github.com.pages.SlidersPage.validateOnBlurSwitch;
import static io.github.com.pages.SlidersPage.validationSlider;
import static io.github.com.pages.SlidersPage.verticalSlidersSlider;
import static org.openqa.selenium.Keys.ENTER;

public class SlidersTests extends TestsInit {

    @BeforeMethod
    public void before() {
        slidersPage.open();
        waitCondition(() -> slidersPage.isOpened());
        slidersPage.checkOpened();
    }

    @Test(description = "Test checks slider's orientation")
    public void orientationSliderTest() {
        Slider horizontalSlider = colorsSlider.get(1);
        horizontalSlider.show();
        horizontalSlider.is().enabled().and().horizontal();
        horizontalSlider.setValue(100);
        horizontalSlider.has().value(100);

        verticalSlidersSlider.show();
        verticalSlidersSlider.is().enabled().and().vertical();
        verticalSlidersSlider.setValue(100);
        verticalSlidersSlider.has().value(100);
    }

    @Test(description = "Test checks slider's color")
    public void colorSliderTest() {
        Slider colorsSlider1 = colorsSlider.get(1);
        colorsSlider1.show();
        colorsSlider1.has().trackFillColor(ORANGE_DARKEN_3.value()).
            and().trackColor(BLUE_ACCENT_5.value()).
            and().thumbColor(ORANGE_DARKEN_3.value());
        adjustableSlider.show();
        adjustableSlider.has().backgroundColor("rgba(255, 0, 0, 1)");
    }

    @Test(description = "Test checks if slider is disabled or not")
    public void disabledSliderTest() {
        disabledSlider.show();
        disabledSliderControl.has().label();
        disabledSlider.is().disabled();

        discreteSlider.show();
        discreteSlider.is().enabled();
    }

    @Test(description = "Test checks that slider is discrete")
    public void discreteSliderTest() {
        discreteSlider.show();
        discreteSlider.setValue(46);
        discreteSlider.has().value(50);
    }

    @Test(description = "Test checks slider's icons")
    public void iconsSliderTest() {
        Slider slider = iconsSlider.get(3);
        Icon minusIcon = slider.prependOuterIcon();
        Icon plusIcon = slider.appendOuterIcon();
        slider.show();

        slider.setValue(0);
        plusIcon.click();
        slider.has().value(10);
        minusIcon.click();
        slider.has().value(0);
    }

    @Test(description = "Test checks if slider is readonly or not")
    public void readonlySliderTest() {
        readonlySlider.show();
        readonlySlider.is().readonly();
        stepSlider.show();
        stepSlider.is().notReadonly();
    }

    @Test(description = "Test checks step slider", dataProvider = "stepSliderTestData", dataProviderClass = SliderTestsDataProvider.class)
    public void stepSliderTest(double approximateValue, double expectedValue) {
        stepSlider.show();
        stepSlider.setValue(approximateValue);
        stepSlider.is().value(expectedValue);
    }


    @Test(description = "Test checks slider's thumb : thumb-label (y/n/”always”), thumb-size (0-n)")
    public void thumbSliderTest() {
        Slider firstThumbSlider = thumbSlider.get(1);
        firstThumbSlider.show();
        firstThumbSlider.setValue(10);

        firstThumbSlider.has().thumbLabel().and().thumbSize(16);
        firstThumbSlider.thumbLabel().is().hidden();
        firstThumbSlider.thumb().click();
        firstThumbSlider.thumbLabel().is().displayed().and().has().value("10");

        stepSlider.show();
        stepSlider.has().noThumbLabel();
    }

    @Test(description = "Test checks slider's label")
    public void labelSliderTest() {
        disabledSlider.show();
        disabledSlider.has().label("Disabled");
        thumbSlider.get(1).show();
        thumbSlider.get(1).has().noLabel();
        inverseLabelSlider.show();
        inverseLabelSlider.has().inverseLabel().and().label("Inverse label");
    }

    @Test(description = "Test checks slider's ticks")
    public void ticksSliderShowTicksWhenUsingSliderTest() {
        String[] fruits = {"Figs", "Lemon", "Pear", "Apple"};
        Slider ticksSlider1 = ticksSlider.get(1);
        Slider ticksSlider4 = ticksSlider.get(4);

        colorsSlider.get(1).show();
        colorsSlider.get(1).has().noTicks();

        ticksSlider1.show();
        ticksSlider1.core().actions((a, from) -> a.clickAndHold(from));
        ticksSlider1.has().ticks();
        ticksSlider1.ticks().forEach(tick -> tick.is().displayed());
        ticksSlider.get(2).show();
        ticksSlider.get(2).is().tickAlwaysShow();
        ticksSlider.get(3).show();
        ticksSlider.get(3).has().ticksSize(4);
        IntStream.range(0, fruits.length).forEach(index -> ticksSlider4.is().tickLabel(index + 1,
                fruits[index]));
    }

    @Test(description = "Test checks slider's message: message(string)")
    public void messageSliderTest() {
        validationSlider.get(2).show();
        validationSlider.get(2).has().messageText("40 in stock");
    }
    @Test(description = "Test checks slider's error message", dataProvider = "validationSliderTestData", dataProviderClass = SliderTestsDataProvider.class)
    public void validationSliderTest(int index, double value, String expectedMessage) {
        Slider slider = validationSlider.get(index);
        slider.show();
        slider.setValue(value);
        slider.has().value(value);
        waitCondition(slider::hasErrorMessages);
        slider.has().errorMessage(expectedMessage);
    }

    @Test(description = "Test checks slider's error messages: error (y/n)," +
        "error-messages (string), rules")
    public void errorSliderTest() {
        List<String> errorMessages = ImmutableList.of("2 is too low", "3 is too low");
        errorCountTextField.setText("2");

        adjustableSlider.show();
        adjustableSlider.is().notError();
        adjustableSlider.setValue(2);
        adjustableSlider.is().error().and().has().errorMessagesCount(2).
            and().errorMessages(errorMessages);
    }
    @Test(description = "Test checks slider's success messages: success (y/n)," +
        " success-messages (string), rules")
    public void successSliderTest() {
        String message = "success message";
        successMessageTextField.setText(message);
        successMessageTextField.sendKeys(ENTER);

        adjustableSlider.show();
        adjustableSlider.setValue(10);
        adjustableSlider.is().notSuccess().and().has().errorMessage(message);
        adjustableSlider.setValue(60);
        adjustableSlider.is().success().and().has().successMessage(message);
        successMessageTextField.clear();
    }
    @Test(description = "Test checks slider's messages : hint(string), persistent-hint (y/n)")
    public void hintSliderTest() {
        adjustableSlider.show();
        adjustableSlider.has().messagesCount(0);
        adjustableSlider.thumb().click();
        waitCondition(() -> adjustableSlider.messages().size() > 0);
        adjustableSlider.has().messagesCount(1);

        Slider hintSlider = validationSlider.get(2);
        hintSlider.show();
        hintSlider.has().messagesCount(1);
        hintSlider.thumb().click();
        hintSlider.has().messagesCount(1);
    }
    @Test(description = "Test shows how to work with slider with text input")
    public void appendTextFieldSliderTest() {
        Slider slider = appendTextFieldSlider.get(1);
        TextField sliderInput = appendTextField.get(1);
        slider.show();
        slider.is().enabled();

        slider.setValue(150);
        slider.has().value(150);
        sliderInput.has().value("150");

        sliderInput.input("255");
        sliderInput.has().value("255");
        slider.has().value(255);

        sliderInput.input("256"); // slider range upper boundary is 255
        sliderInput.has().value("255");
        slider.has().value(255);
    }

    @Test(description = "Test checks slider's theme")
    public void themeSliderTest() {
        adjustableSlider.show();
        themeSwitch.check();
        adjustableSlider.has().darkTheme();
        themeSwitch.uncheck();
        adjustableSlider.has().lightTheme();
    }

    @Test(description = "Test checks slider's dense")
    public void denseSliderTest() {
        adjustableSlider.show();
        denseSwitch.check();
        adjustableSlider.is().dense();
        denseSwitch.uncheck();
        adjustableSlider.is().notDense();
    }

    @Test(description = "Test checks slider's height")
    public void heightSliderTest() {
        heightTextField.setText("16");
        adjustableSlider.show();
        adjustableSlider.has().height(16);
    }

    @Test(description = "Test checks if slider has details hidden or not : hide details(y/n)")
    public void hideDetailsSliderTest() {
        adjustableSlider.show();
        hideDetailsSwitch.check();
        adjustableSlider.has().detailsHidden();
        hideDetailsSwitch.uncheck();
        adjustableSlider.has().notDetailsHidden();
    }
    @Test(description = "Test checks slider's loader : loading(y/n/color), loader-height (0-n)")
    public void loadingSliderTest() {
        adjustableSlider.show();
        loadingSwitch.check();
        adjustableSlider.is().loading();
        loaderHeightTextField.setText("15");
        adjustableSlider.loader().has().height(15);
        loadingSwitch.uncheck();
    }

    @Test(description = "Test checks slider's min and max value")
    public void minMaxValueSliderTest() {
        adjustableSlider.show();
        adjustableSlider.has().minValue(0).and().has().maxValue(100);
    }
    @Test(description = "Test checks slider's validate-on-blur")
    public void validateOnBlurSliderTest() {
        adjustableSlider.show();
        validateOnBlurSwitch.check();
        adjustableSlider.has().messagesCount(0);
        adjustableSlider.setValue(10.0);
        adjustableSlider.thumb().click();
        adjustableSlider.clickOutsideOfSlider(); //validate-on-blur works only after click on slider and then click outside
        adjustableSlider.has().messagesCount(1);
    }
}
