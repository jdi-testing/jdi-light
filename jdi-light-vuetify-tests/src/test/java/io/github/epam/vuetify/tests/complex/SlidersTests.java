package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SliderTestsDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slidersPage;
import static io.github.com.enums.Colors.BLUE_ACCENT_5;
import static io.github.com.enums.Colors.ORANGE_DARKEN_3;
import static io.github.com.pages.SlidersPage.appendTextFieldInput;
import static io.github.com.pages.SlidersPage.appendTextFieldSlider;
import static io.github.com.pages.SlidersPage.colorsSlider;
import static io.github.com.pages.SlidersPage.disabledSlider;
import static io.github.com.pages.SlidersPage.disabledSliderControl;
import static io.github.com.pages.SlidersPage.discreteSlider;
import static io.github.com.pages.SlidersPage.iconsSlider;
import static io.github.com.pages.SlidersPage.readonlySlider;
import static io.github.com.pages.SlidersPage.stepSlider;
import static io.github.com.pages.SlidersPage.thumbSlider;
import static io.github.com.pages.SlidersPage.thumbSliderControl;
import static io.github.com.pages.SlidersPage.ticksSlider;
import static io.github.com.pages.SlidersPage.validationSlider;
import static io.github.com.pages.SlidersPage.verticalSlidersSlider;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class SlidersTests extends TestsInit {

    @BeforeMethod
    public void before() {
        slidersPage.open();
        waitCondition(() -> slidersPage.isOpened());
        slidersPage.checkOpened();
    }

    @Test(description = "Test checks slider's orientation")
    public void orientationSliderTest() {
        colorsSlider.get(1).show();
        colorsSlider.get(1).is().enabled()
                .and().is().horizontal();
        colorsSlider.get(1).slideHorizontalTo(100.0);
        colorsSlider.get(1).has().value(100);

        verticalSlidersSlider.show();
        verticalSlidersSlider.is().enabled()
                .and().is().vertical();
        verticalSlidersSlider.slideVerticalTo(100.0);
        verticalSlidersSlider.has().value(100);
    }

    @Test(description = "Test checks slider's color")
    public void colorSliderTest() {
        Slider colorsSlider1 = colorsSlider.get(1);
        colorsSlider1.show();
        colorsSlider1.has().trackColor(ORANGE_DARKEN_3.value());
        colorsSlider1.has().backgroundTrackColor(BLUE_ACCENT_5.value());
        colorsSlider1.has().thumbColor(ORANGE_DARKEN_3.value());
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
        discreteSlider.slideHorizontalTo(46.0);
        discreteSlider.has().value(50);
    }

    @Test(description = "Test checks slider's icons")
    public void iconsSliderTest() {
        Slider slider = iconsSlider.get(3);
        Icon minusIcon = slider.prependOuterIcon();
        Icon plusIcon = slider.appendOuterIcon();
        slider.show();
        slider.is().enabled()
                .and().is().horizontal()
                .and().has().value(0);
        plusIcon.click();
        slider.has().value(10);
        slider.slideHorizontalTo(50.0);
        slider.has().value(50);
        minusIcon.click();
        slider.has().value(40);
    }

    @Test(description = "Test checks if slider is readonly or not")
    public void readonlySliderTest() {
        readonlySlider.show();
        readonlySlider.is().readonly();
        stepSlider.show();
        stepSlider.is().notReadonly();
    }

    @Test(description = "Test checks slider's thumb : thumb-label (y/n/”always”), thumb-size (0-n)")
    public void thumbSliderTest() {
        Slider thumbSlider1 = thumbSlider.get(1);
        thumbSlider1.show();
        thumbSlider1.has().thumbLabel();
        thumbSlider1.thumbLabel().is().hidden();
        thumbSlider1.thumb().click();
        thumbSlider1.thumbLabel().is().displayed();
        thumbSlider1.thumbLabel().has().value("45");
        thumbSlider1.slideHorizontalTo(0.0);
        thumbSlider1.thumbLabel().has().value("0");
        thumbSlider1.has().thumbSize(16);
        stepSlider.show();
        stepSlider.has().noThumbLabel();
    }

    @Test(description = "Test checks slider's label")
    public void labelSliderTest() {
        disabledSlider.show();
        disabledSliderControl.has().label();
        thumbSlider.get(1).show();
        thumbSliderControl.get(1).has().noLabel();
    }

    @Test(description = "Test checks slider's ticks")
    public void ticksSliderShowTicksWhenUsingSliderTest() {
        Slider ticksSlider1 = ticksSlider.get(1);
        Slider ticksSlider2 = ticksSlider.get(2);
        Slider ticksSlider4 = ticksSlider.get(4);
        String[] fruits = {"Figs", "Lemon", "Pear", "Apple"};
        ticksSlider1.show();
        ticksSlider1.core().actions((a, from) -> a.clickAndHold(from));
        int totalTicks = ticksSlider1.ticks().size();
        IntStream.range(0, totalTicks).forEach(index -> ticksSlider1.ticks().get(index + 1).is().displayed());
        ticksSlider2.show();
        ticksSlider2.is().tickAlwaysShow();
        ticksSlider4.show();
        IntStream.range(0, fruits.length).forEach(index -> ticksSlider.get(4).is().tickLabel(index + 1,
                fruits[index]));
    }

    @Test(description = "Test checks slider's error message", dataProvider = "validationSliderTestData", dataProviderClass = SliderTestsDataProvider.class)
    public void validationSliderTest(int index, double value, String expectedMessage) {
        validationSlider.get(index).slideHorizontalTo(value);
        validationSlider.get(index).has().value(value);
        waitCondition(() -> validationSlider.get(index).hasErrorMessages());
        validationSlider.get(index).has().errorMessage(expectedMessage);
    }

    @Test(description = "Test shows how to work with slider with text input")
    public void appendTextFieldSliderTest() {
        Slider slider = appendTextFieldSlider.get(1);
        UIElement sliderInput = appendTextFieldInput.get(1);
        slider.show();
        slider.is().enabled()
                        .and().is().horizontal()
                        .and().has().value(64);
        slider.slideHorizontalTo(150.0);
        slider.has().value(150);
        sliderInput.has().value("150");
        clearInputField(sliderInput);
        sliderInput.input("255");
        sliderInput.has().value("255");
        slider.has().value(255);
        clearInputField(sliderInput);
        sliderInput.input("256"); // slider range upper boundary is 255
        sliderInput.has().value("255");
        slider.has().value(255);
    }

    private void clearInputField(UIElement inputField) {
        IntStream.range(1, 4).forEach(i -> inputField.sendKeys(BACK_SPACE));
    }
}
