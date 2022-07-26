package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Slider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.slidersPage;
import static io.github.com.pages.SlidersPage.appendAndPrependInputIcon;
import static io.github.com.pages.SlidersPage.appendAndPrependSlider;
import static io.github.com.pages.SlidersPage.appendAndPrependSliderControl;
import static io.github.com.pages.SlidersPage.appendAndPrependText;
import static io.github.com.pages.SlidersPage.appendTextFieldInput;
import static io.github.com.pages.SlidersPage.appendTextFieldSlider;
import static io.github.com.pages.SlidersPage.colorsSlider;
import static io.github.com.pages.SlidersPage.colorsSliderControl;
import static io.github.com.pages.SlidersPage.disabledSlider;
import static io.github.com.pages.SlidersPage.disabledSliderControl;
import static io.github.com.pages.SlidersPage.discreteSlider;
import static io.github.com.pages.SlidersPage.discreteSliderControl;
import static io.github.com.pages.SlidersPage.iconsSlider;
import static io.github.com.pages.SlidersPage.iconsSliderControl;
import static io.github.com.pages.SlidersPage.iconsSliderInputIcon;
import static io.github.com.pages.SlidersPage.inverseLabel;
import static io.github.com.pages.SlidersPage.inverseSliderControl;
import static io.github.com.pages.SlidersPage.minAndMaxSlider;
import static io.github.com.pages.SlidersPage.minAndMaxSliderControl;
import static io.github.com.pages.SlidersPage.readonlySlider;
import static io.github.com.pages.SlidersPage.stepSlider;
import static io.github.com.pages.SlidersPage.stepSliderControl;
import static io.github.com.pages.SlidersPage.thumbSlider;
import static io.github.com.pages.SlidersPage.thumbSliderControl;
import static io.github.com.pages.SlidersPage.ticksSlider;
import static io.github.com.pages.SlidersPage.ticksSliderControl;
import static io.github.com.pages.SlidersPage.validationSlider;
import static io.github.com.pages.SlidersPage.verticalSlidersSlider;
import static org.openqa.selenium.Keys.BACK_SPACE;

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
        colorsSlider.get(1).has().fillColor("orange");
        colorsSliderControl.get(1).has().hasLabel();
        colorsSlider.get(1).has().backgroundColor("primary");
        colorsSlider.get(1).has().thumbColor("orange");
    }

    @Test
    public void trackColorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(2).slideHorizontalTo(value);
            colorsSlider.get(2).has().value(value);
        });
        colorsSlider.get(2).has().fillColor("primary");
        colorsSliderControl.get(2).has().hasLabel();
        colorsSlider.get(2).has().backgroundColor("green");
        colorsSlider.get(2).has().thumbColor("primary");
    }

    @Test
    public void thumbColorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(3).slideHorizontalTo(value);
            colorsSlider.get(3).has().value(value);
            colorsSlider.get(3).has().thumbLabelValue(value);
        });
        colorsSlider.get(3).has().fillColor("primary");
        colorsSlider.get(3).has().backgroundColor("primary");
        colorsSlider.get(3).has().thumbColor("red");
        colorsSlider.get(3).has().thumbLabelColor("red");
    }

    @Test
    public void disabledSliderTest() {
        disabledSliderControl.has().hasLabel();
        disabledSlider.is().disabled();
        disabledSlider.has().value(30);
        disabledSlider.slideHorizontalTo(50);
        disabledSlider.has().value(30);
    }

    @Test
    public void discreteSliderTest() {
        discreteSliderControl.has().hasNoLabel();
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
        iconsSliderControl.get(3).has().hasNoLabel();
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
        inverseSliderControl.has().hasLabel();
    }

    @Test
    public void minAndMaxSliderTest() {
        minAndMaxSliderControl.has().hasNoLabel();
        minAndMaxSlider.slideHorizontalTo(90);
        minAndMaxSlider.has().value(90);
        minAndMaxSlider.slideHorizontalTo(-50);
        minAndMaxSlider.has().value(-50);
    }

    @Test
    public void readonlySliderTest() {
        readonlySlider.is().readonly();
        int currentValue = Integer.parseInt(readonlySlider.getValue());
        readonlySlider.slideHorizontalTo(currentValue + 1);
        readonlySlider.has().value(currentValue);
    }

    @Test
    public void stepSliderTest() {
        stepSliderControl.has().hasNoLabel();
        stepSlider.slideHorizontalTo(0);
        stepSlider.has().value(0);
        stepSlider.slideHorizontalTo(24);
        stepSlider.has().value(20);
        stepSlider.slideHorizontalTo(26);
        stepSlider.has().value(30);
    }

    @Test
    public void showThumbWhenUsingSliderTest() {
        thumbSliderControl.get(1).has().hasNoLabel();
        thumbSlider.get(1).is().thumbLabelNotDisplayed();
        thumbSlider.get(1).getThumb().click();
        thumbSlider.get(1).is().thumbLabelDisplayed();
        thumbSlider.get(1).is().thumbLabelValue(Integer.parseInt(thumbSlider.get(1).getValue()));
        thumbSlider.get(1).slideHorizontalTo(0);
        thumbSlider.get(1).is().thumbLabelValue(0);
    }

    @Test
    public void alwaysShowThumbLabelsTest() {
        IntStream.range(2, 5).forEach(index ->
        {
            thumbSlider.get(index).is().thumbLabelDisplayed();
            thumbSlider.get(index).getThumb().click();
            thumbSlider.get(index).is().thumbLabelDisplayed();
            thumbSlider.get(index).slideHorizontalTo(0);
        });
    }

    @Test
    public void ticksSliderShowTicksWhenUsingSliderTest() {
        ticksSlider.get(1).is().trickNotAlwaysShow();
    }

    @Test
    public void ticksSliderAlwaysShowTicksTest() {
        ticksSlider.get(2).is().trickAlwaysShow();
    }

    @Test
    public void ticksSliderTickSizeTest() {
        ticksSlider.get(3).is().trickAlwaysShow();
        ticksSlider.get(3).is().tricksSize(4, 4);
    }

    @Test
    public void ticksSliderTickLabelsTest() {
        ticksSliderControl.get(4).has().hasNoLabel();
        ticksSlider.get(4).is().trickAlwaysShow();
        ticksSlider.get(4).is().trickLabel(1, "Figs");
        ticksSlider.get(4).is().trickLabel(2, "Lemon");
        ticksSlider.get(4).is().trickLabel(3, "Pear");
        ticksSlider.get(4).is().trickLabel(4, "Apple");
    }

    @DataProvider(name = "validationSliderTestData")
    public Object[][] validationSliderTestData() {
        return new Object[][]{
                {50, "error"},
                {20, "primary"},
        };
    }

    @Test(dataProvider = "validationSliderTestData")
    public void validationSliderTest(int value, String expectedColor) {
        for (Slider slider : validationSlider) {
            slider.slideHorizontalTo(value);
            slider.has().value(value);
            slider.has().fillColor(expectedColor);
            slider.has().backgroundColor(expectedColor);
            slider.has().thumbColor(expectedColor);
        }
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
        appendAndPrependText.has().value(appendAndPrependSlider.getValue());

        appendAndPrependSliderControl.has().hasNoLabel();
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
