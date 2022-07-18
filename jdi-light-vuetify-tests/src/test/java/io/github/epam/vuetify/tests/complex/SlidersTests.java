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
import static io.github.com.pages.SlidersPage.appendAndPrependFlashPoint;
import static io.github.com.pages.SlidersPage.appendAndPrependInputIcon;
import static io.github.com.pages.SlidersPage.appendAndPrependPlayButton;
import static io.github.com.pages.SlidersPage.appendAndPrependSlider;
import static io.github.com.pages.SlidersPage.appendAndPrependText;
import static io.github.com.pages.SlidersPage.appendTextFieldInput;
import static io.github.com.pages.SlidersPage.appendTextFieldSlider;
import static io.github.com.pages.SlidersPage.colorsSlider;
import static io.github.com.pages.SlidersPage.disabledSlider;
import static io.github.com.pages.SlidersPage.discreteSlider;
import static io.github.com.pages.SlidersPage.iconsSlider;
import static io.github.com.pages.SlidersPage.iconsSliderInputIcon;
import static io.github.com.pages.SlidersPage.inverseLabel;
import static io.github.com.pages.SlidersPage.minAndMaxSlider;
import static io.github.com.pages.SlidersPage.minAndMaxInput;
import static io.github.com.pages.SlidersPage.readonlySlider;
import static io.github.com.pages.SlidersPage.stepSlider;
import static io.github.com.pages.SlidersPage.thumbSlider;
import static io.github.com.pages.SlidersPage.ticksSlider;
import static io.github.com.pages.SlidersPage.validationSlider;
import static io.github.com.pages.SlidersPage.validationHint;
import static io.github.com.pages.SlidersPage.verticalSlidersSlider;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class SlidersTests extends TestsInit {

    @BeforeMethod
    public void before() {
        slidersPage.open();
        waitCondition(() -> slidersPage.isOpened());
        slidersPage.checkOpened();
    }

    @Test
    public void colorSliderTest() {
        colorsSlider.get(1).show();
        colorsSlider.get(1).is().enabled()
                .and().is().horizontal()
                .and().has().value("25");

        colorsSlider.get(1).slideHorizontalTo("100");
        colorsSlider.get(1).has().value("100");
    }

    @Test
    public void trackColorSliderTest() {
        colorsSlider.get(2).show();
        colorsSlider.get(2).is().enabled()
                .and().is().horizontal()
                .and().has().value("75");
        colorsSlider.get(2).track().is().displayed();

        colorsSlider.get(2).slideHorizontalTo("0");
        colorsSlider.get(2).has().value("0");
        colorsSlider.get(2).track().is().hidden();
    }

    @Test
    public void thumbColorSliderTest() {
        colorsSlider.get(3).show();
        colorsSlider.get(3).is().enabled()
                .and().is().horizontal()
                .and().has().value("50");
        colorsSlider.get(3).thumbLabel().is().displayed()
                .and().has().value("50");

        colorsSlider.get(3).slideHorizontalTo("100");
        colorsSlider.get(3).has().value("100");
        colorsSlider.get(3).thumbLabel().has().value("100");
    }

    @Test
    public void disabledSliderTest() {
        disabledSlider.show();
        disabledSlider.is().disabled()
                .and().is().horizontal()
                .and().has().value("30");
    }

    @Test
    public void discreteSliderTest() {
        discreteSlider.show();
        discreteSlider.is().enabled()
                .and().is().horizontal()
                .and().has().value("0");
        discreteSlider.thumbLabel().is().hidden();

        waitCondition(() -> discreteSlider.thumbLabel().isDisplayed());
        discreteSlider.slideHorizontalTo("10");
        discreteSlider.has().value("10");
        discreteSlider.thumbLabel().has().value("10");

        waitCondition(() -> discreteSlider.thumbLabel().isDisplayed());
        discreteSlider.slideHorizontalTo("14");
        discreteSlider.has().value("10");
        discreteSlider.thumbLabel().has().value("10");

        waitCondition(() -> discreteSlider.thumbLabel().isDisplayed());
        discreteSlider.slideHorizontalTo("16");
        discreteSlider.has().value("20");
        discreteSlider.thumbLabel().has().value("20");
    }

    @Test
    public void iconsSliderTest() {
        Slider slider = iconsSlider.get(3);
        Icon minusIcon = iconsSliderInputIcon.get(3);
        Icon plusIcon = iconsSliderInputIcon.get(4);

        slider.show();
        slider.is().enabled()
                .and().is().horizontal()
                .and().has().value("0");

        plusIcon.click();
        slider.has().value("10");

        slider.slideHorizontalTo("50");
        slider.has().value("50");

        minusIcon.click();
        slider.has().value("40");
    }

    @Test
    public void inverseLabelSliderTest() {
        inverseLabel.finds(" .v-input__slot > *").get(1).is().cssClass("v-slider");
        inverseLabel.finds(" .v-input__slot > *").get(2).is().cssClass("v-label");
    }

    @Test
    public void minAndMaxSliderTest() {
        minAndMaxSlider.show();
        minAndMaxSlider.is().enabled()
                .and().is().horizontal()
                .and().has().value("40");
        minAndMaxInput.textInputField().has().text("40");

        minAndMaxSlider.slideHorizontalTo("90");
        minAndMaxSlider.has().value("90");
        minAndMaxInput.textInputField().has().text("90");

        minAndMaxInput.clear();
        minAndMaxInput.textInputField().has().text("0");

        minAndMaxInput.input("-50");
        minAndMaxInput.textInputField().has().text("-50");
    }

    @Test
    public void readonlySliderTest() {
        readonlySlider.show();
        readonlySlider.is().readonly()
                .and().has().value("30");

        readonlySlider.slideHorizontalTo("40");
        readonlySlider.has().value("30");
    }

    @Test
    public void stepSliderTest() {
        stepSlider.show();
        stepSlider.is().enabled()
                .and().is().horizontal()
                .and().has().value("10");

        stepSlider.slideHorizontalTo("0");
        stepSlider.has().value("0");

        stepSlider.slideHorizontalTo("24");
        stepSlider.has().value("20");

        stepSlider.slideHorizontalTo("26");
        stepSlider.has().value("30");
    }

    @Test
    public void showThumbWhenUsingSliderTest() {
        thumbSlider.get(1).show();
        thumbSlider.get(1).thumbLabel().is().hidden();

        thumbSlider.get(1).thumb().click();
        thumbSlider.get(1).thumbLabel().is().displayed();
        thumbSlider.get(1).thumbLabel().has().value("45");

        thumbSlider.get(1).slideHorizontalTo("0");
        thumbSlider.get(1).thumbLabel().has().value("0");
    }

    @Test
    public void alwaysShowThumbLabelsTest() {
        thumbSlider.get(2).is().thumbLabelDisplayed();
        thumbSlider.get(2).slideHorizontalTo("0");
    }

    @Test
    public void ticksSliderShowTicksWhenUsingSliderTest() {
        ticksSlider.get(1).core().actions((a, from) -> a.clickAndHold(from));
        int totalTicks = ticksSlider.get(1).ticks().size();
        IntStream.range(0, totalTicks).forEach(index -> ticksSlider.get(1).ticks().get(index + 1).is().displayed());
    }

    @Test
    public void ticksSliderAlwaysShowTicksTest() {
        ticksSlider.get(2).is().tickAlwaysShow();
    }

    @Test
    public void ticksSliderTickSizeTest() {
        ticksSlider.get(3).is().tickAlwaysShow();
        ticksSlider.get(3).is().ticksSize(4, 4);
    }

    @Test
    public void ticksSliderTickLabelsTest() {
        String[] fruits = {"Figs", "Lemon", "Pear", "Apple"};
        ticksSlider.get(4).is().tickAlwaysShow();
        IntStream.range(0, fruits.length).forEach(index -> ticksSlider.get(4).is().tickLabel(index + 1, fruits[index]));
    }

    @Test(dataProvider = "validationSliderTestData", dataProviderClass = SliderTestsDataProvider.class)
    public void validationSliderTest(int index, String value, String expectedHint) {
        validationSlider.get(index).slideHorizontalTo(value);
        validationSlider.get(index).has().value(value);
        validationHint.get(index).is().hintLabel(expectedHint);
    }

    @Test
    public void verticalSlidersSliderTest() {
        verticalSlidersSlider.show();
        verticalSlidersSlider.is().enabled()
                .and().is().vertical()
                .and().has().value("10");

        verticalSlidersSlider.slideVerticalTo("100");
        verticalSlidersSlider.has().value("100");
    }

    @Test
    public void appendAndPrependSliderTest() {
        appendAndPrependText.has().value(appendAndPrependSlider.value());

        appendAndPrependSlider.has().value("40");
        appendAndPrependInputIcon.get(1).click();
        appendAndPrependSlider.has().value("40");
        appendAndPrependText.has().value("40");

        appendAndPrependSlider.slideHorizontalTo("60");
        appendAndPrependText.has().value("60");

        appendAndPrependInputIcon.get(1).click();
        appendAndPrependSlider.has().value("59");
        appendAndPrependText.has().value("59");

        appendAndPrependSlider.slideHorizontalTo("217");
        appendAndPrependInputIcon.get(2).click();
        appendAndPrependSlider.has().value("218");
        appendAndPrependText.has().value("218");

        appendAndPrependInputIcon.get(2).click();
        appendAndPrependSlider.has().value("218");
        appendAndPrependText.has().value("218");

        appendAndPrependFlashPoint.is().notVisible();
        appendAndPrependPlayButton.click();
        appendAndPrependFlashPoint.show();
        appendAndPrependFlashPoint.is().visible();
    }

    @Test
    public void appendTextFieldSliderTest() {
        Slider slider = appendTextFieldSlider.get(1);
        UIElement sliderInput = appendTextFieldInput.get(1);

        slider.show();
        slider.is().enabled()
                        .and().is().horizontal()
                        .and().has().value("64");

        slider.slideHorizontalTo("150");
        slider.has().value("150");
        sliderInput.has().value("150");
        clearInputField(sliderInput);

        sliderInput.input("255");
        sliderInput.has().value("255");
        slider.has().value("255");
        clearInputField(sliderInput);

        sliderInput.input("256"); // slider range upper boundary is 255
        sliderInput.has().value("255");
        slider.has().value("255");
    }

    // a bit of a hack to clear text fields used in a previous method
    private void clearInputField(UIElement inputField) {
        IntStream.range(1, 4).forEach(i -> inputField.sendKeys(BACK_SPACE));
    }
}
