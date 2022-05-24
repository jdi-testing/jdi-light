package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import io.github.epam.TestsInit;
import io.github.epam.vuetify.tests.data.SliderTestsDataProvider;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
import static org.testng.Assert.assertTrue;

public class SlidersTests extends TestsInit {

    @BeforeClass
    public void before() {
        slidersPage.open();
        waitCondition(() -> slidersPage.isOpened());
        slidersPage.checkOpened();
    }

    @Test
    public void colorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(1).slideHorizontalTo(value);
            colorsSlider.get(1).has().value(value);
        });
    }

    @Test
    public void trackColorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(2).slideHorizontalTo(value);
            colorsSlider.get(2).has().value(value);
        });
    }

    @Test
    public void thumbColorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(3).slideHorizontalTo(value);
            colorsSlider.get(3).has().value(value);
            colorsSlider.get(3).has().thumbLabelValue(value);
        });
    }

    @Test
    public void disabledSliderTest() {
        disabledSlider.is().disabled();
        disabledSlider.has().value(30);
        disabledSlider.slideHorizontalTo(50);
        disabledSlider.has().value(30);
    }

    @Test
    public void discreteSliderTest() {
        discreteSlider.has().value(0);
        discreteSlider.slideHorizontalTo(10);
        discreteSlider.has().value(10);
        discreteSlider.slideHorizontalTo(14);
        discreteSlider.has().value(10);
        discreteSlider.slideHorizontalTo(16);
        discreteSlider.has().value(20);
    }

    @Test
    public void iconsSliderTest() {
        iconsSlider.get(3).has().value(0);
        iconsSliderInputIcon.get(4).click();
        iconsSlider.get(3).has().value(10);
        iconsSlider.get(3).slideHorizontalTo(50);
        iconsSlider.get(3).has().value(50);
        iconsSliderInputIcon.get(3).click();
        iconsSlider.get(3).has().value(40);
    }

    @Test
    public void inverseLabelSliderTest() {
        inverseLabel.finds(" .v-input__slot > *").get(1).is().cssClass("v-slider");
        inverseLabel.finds(" .v-input__slot > *").get(2).is().cssClass("v-label");
    }

    @Test
    public void minAndMaxSliderTest() {
        minAndMaxSlider.slideHorizontalTo(90);
        minAndMaxSlider.has().value(90);
        minAndMaxSlider.slideHorizontalTo(-50);
        minAndMaxSlider.has().value(-50);

        minAndMaxInput.sendKeys(Keys.CONTROL + "a" + Keys.DELETE + Keys.CONTROL + "a" + Keys.DELETE);
        minAndMaxInput.sendKeys("85");
        minAndMaxSlider.has().value(85);
    }

    @Test
    public void readonlySliderTest() {
        readonlySlider.is().readonly();
        int currentValue = Integer.parseInt(readonlySlider.value());
        readonlySlider.slideHorizontalTo(currentValue + 1);
        readonlySlider.has().value(currentValue);
    }

    @Test
    public void stepSliderTest() {
        stepSlider.slideHorizontalTo(0);
        stepSlider.has().value(0);
        stepSlider.slideHorizontalTo(24);
        stepSlider.has().value(20);
        stepSlider.slideHorizontalTo(26);
        stepSlider.has().value(30);
    }

    @Test
    public void showThumbWhenUsingSliderTest() {
        thumbSlider.get(1).is().thumbLabelNotDisplayed();
        thumbSlider.get(1).thumb().click();
        thumbSlider.get(1).is().thumbLabelDisplayed();
        thumbSlider.get(1).is().thumbLabelValue(Integer.parseInt(thumbSlider.get(1).value()));
        thumbSlider.get(1).slideHorizontalTo(0);
        thumbSlider.get(1).is().thumbLabelValue(0);
    }

    @Test
    public void alwaysShowThumbLabelsTest() {
        IntStream.range(2, 5).forEach(index ->
        {
            thumbSlider.get(index).is().thumbLabelDisplayed();
            thumbSlider.get(index).slideHorizontalTo(0);
        });
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
    public void validationSliderTest(int index, int value, String expectedHint) {
        validationSlider.get(index).slideHorizontalTo(value);
        validationSlider.get(index).has().value(value);
        validationHint.get(index).is().hintLabel(expectedHint);
    }

    @Test
    public void verticalSlidersSliderTest() {
        verticalSlidersSlider.is().vertical();
        Arrays.asList(85, 0, 100).forEach(value -> {
            verticalSlidersSlider.slideVerticalTo(value);
            verticalSlidersSlider.has().value(value);
        });
    }

    @Test
    public void appendAndPrependSliderTest() {
        appendAndPrependText.has().value(appendAndPrependSlider.value());

        appendAndPrependSlider.has().value(40);
        appendAndPrependInputIcon.get(1).click();
        appendAndPrependSlider.has().value(40);
        appendAndPrependText.has().value(Integer.toString(40));

        appendAndPrependSlider.slideHorizontalTo(60);
        appendAndPrependText.has().value(Integer.toString(60));

        appendAndPrependInputIcon.get(1).click();
        appendAndPrependSlider.has().value(59);
        appendAndPrependText.has().value(Integer.toString(59));

        appendAndPrependSlider.slideHorizontalTo(217);
        appendAndPrependInputIcon.get(2).click();
        appendAndPrependSlider.has().value(218);
        appendAndPrependText.has().value(Integer.toString(218));

        appendAndPrependInputIcon.get(2).click();
        appendAndPrependSlider.has().value(218);
        appendAndPrependText.has().value(Integer.toString(218));

        assertTrue(appendAndPrependFlashPoint.isNotDisplayed());
        appendAndPrependPlayButton.click();
        waitCondition(()->appendAndPrependFlashPoint.isDisplayed());
        assertTrue(appendAndPrependFlashPoint.isDisplayed());
    }

    @Test
    public void appendTextFieldSliderTest() {
        ArrayList<Integer> inputValues = new ArrayList<>(Arrays.asList(150, 255));
        for (int index = 1; index <= 3; index++) {
            Slider currentSlider = appendTextFieldSlider.get(index);
            UIElement currentAppendedInputField = appendTextFieldInput.get(index);

            for (Integer value : inputValues) {
                currentSlider.slideHorizontalTo(value);
                currentAppendedInputField.has().text(value.toString());
                clearInputField(currentAppendedInputField);

                currentAppendedInputField.input(value.toString());
                currentSlider.has().value(value);
                clearInputField(currentAppendedInputField);
            }

            currentAppendedInputField.input("256"); // slider range upper boundary is 255
            currentSlider.has().value(255);
        }
    }

    // a bit of a hack to clear text fields used in a previous method
    private void clearInputField(UIElement inputField) {
        IntStream.range(1, 4).forEach(i -> inputField.sendKeys(BACK_SPACE));
    }
}
