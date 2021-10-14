package io.github.epam.vuetify.tests.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static io.github.com.StaticSite.slidersPage;
import static io.github.com.pages.SlidersPage.appendAndPrependInputIcon;
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
import static io.github.com.pages.SlidersPage.readonlySlider;
import static io.github.com.pages.SlidersPage.stepSlider;
import static io.github.com.pages.SlidersPage.thumbSlider;
import static io.github.com.pages.SlidersPage.ticksSlider;
import static io.github.com.pages.SlidersPage.validationSlider;
import static io.github.com.pages.SlidersPage.verticalSlidersSlider;
import static org.openqa.selenium.Keys.BACK_SPACE;

public class SlidersTests extends TestsInit {

    @BeforeClass
    public void before() {
        slidersPage.open();
        slidersPage.checkOpened();
    }

    @Test
    public void colorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(1).slideHorizontalTo(value);
            colorsSlider.get(1).is().value(value);
        });
        colorsSlider.get(1).is().fillColor("orange");
        colorsSlider.get(1).is().backgroundColor("primary");
        colorsSlider.get(1).is().thumbColor("orange");
    }

    @Test
    public void trackColorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(2).slideHorizontalTo(value);
            colorsSlider.get(2).is().value(value);
        });
        colorsSlider.get(2).is().fillColor("primary");
        colorsSlider.get(2).is().backgroundColor("green");
        colorsSlider.get(2).is().thumbColor("primary");
    }

    @Test
    public void thumbColorSliderTest() {
        Arrays.asList(85, 0, 100).forEach(value -> {
            colorsSlider.get(3).slideHorizontalTo(value);
            colorsSlider.get(3).is().value(value);
            colorsSlider.get(3).is().thumbLabelValue(value);
        });
        colorsSlider.get(3).is().fillColor("primary");
        colorsSlider.get(3).is().backgroundColor("primary");
        colorsSlider.get(3).is().thumbColor("red");
        colorsSlider.get(3).is().thumbLabelColor("red");
    }

    @Test
    public void disabledSliderTest() {
        disabledSlider.is().disabled();
        disabledSlider.is().value(30);
        disabledSlider.slideHorizontalTo(50);
        disabledSlider.is().value(30);
    }

    @Test
    public void discreteSliderTest() {
        discreteSlider.is().value(0);
        discreteSlider.slideHorizontalTo(10);
        discreteSlider.is().value(10);
        discreteSlider.slideHorizontalTo(14);
        discreteSlider.is().value(10);
        discreteSlider.slideHorizontalTo(16);
        discreteSlider.is().value(20);
    }

    @Test
    public void iconsSliderTest() {
        iconsSlider.get(3).is().value(0);
        iconsSliderInputIcon.get(4).click();
        iconsSlider.get(3).is().value(10);
        iconsSlider.get(3).slideHorizontalTo(50);
        iconsSlider.get(3).is().value(50);
        iconsSliderInputIcon.get(3).click();
        iconsSlider.get(3).is().value(40);
    }

    @Test
    public void inverseLabelSliderTest() {
        inverseLabel.finds(" .v-input__slot > *").get(1).is().cssClass("v-slider");
        inverseLabel.finds(" .v-input__slot > *").get(2).is().cssClass("v-label");
    }

    @Test
    public void minAndMaxSliderTest() {
        minAndMaxSlider.slideHorizontalTo(90);
        minAndMaxSlider.is().value(90);
        minAndMaxSlider.slideHorizontalTo(-50);
        minAndMaxSlider.is().value(-50);
    }

    @Test
    public void readonlySliderTest() {
        readonlySlider.is().readonly();
        int currentValue = Integer.parseInt(readonlySlider.getValue());
        readonlySlider.slideHorizontalTo(currentValue + 1);
        readonlySlider.is().value(currentValue);
    }

    @Test
    public void stepSliderTest() {
        stepSlider.slideHorizontalTo(0);
        stepSlider.is().value(0);
        stepSlider.slideHorizontalTo(24);
        stepSlider.is().value(20);
        stepSlider.slideHorizontalTo(26);
        stepSlider.is().value(30);
    }

    @Test
    public void showThumbWhenUsingSliderTest() {
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
        ticksSlider.get(4).is().trickAlwaysShow();
        ticksSlider.get(4).is().trickLabel(1, "Figs");
        ticksSlider.get(4).is().trickLabel(2, "Lemon");
        ticksSlider.get(4).is().trickLabel(3, "Pear");
        ticksSlider.get(4).is().trickLabel(4, "Apple");
    }

    @Test
    public void validationSliderTest() {
        Map<Integer, String> data = new HashMap<Integer, String>() {{
            put(50, "error");
            put(20, "primary");
        }};
        validationSlider.forEach(slider -> data.forEach((value, color) -> {
            slider.slideHorizontalTo(value);
            slider.is().value(value);
            slider.is().fillColor(color);
            slider.is().backgroundColor(color);
            slider.is().thumbColor(color);
        }));
    }

    @Test
    public void verticalSlidersSliderTest() {
        verticalSlidersSlider.is().vertical();
        Arrays.asList(85, 0, 100).forEach(value -> {
            verticalSlidersSlider.slideVerticalTo(value);
            verticalSlidersSlider.is().value(value);
        });
    }

    @Test
    public void appendAndPrependSliderTest() {
        appendAndPrependText.is().value(appendAndPrependSlider.getValue());

        appendAndPrependSlider.is().value(40);
        appendAndPrependInputIcon.get(1).click();
        appendAndPrependSlider.is().value(40);
        appendAndPrependText.is().value(Integer.toString(40));

        appendAndPrependSlider.slideHorizontalTo(60);
        appendAndPrependText.is().value(Integer.toString(60));

        appendAndPrependInputIcon.get(1).click();
        appendAndPrependSlider.is().value(59);
        appendAndPrependText.is().value(Integer.toString(59));

        appendAndPrependSlider.slideHorizontalTo(217);
        appendAndPrependInputIcon.get(2).click();
        appendAndPrependSlider.is().value(218);
        appendAndPrependText.is().value(Integer.toString(218));

        appendAndPrependInputIcon.get(2).click();
        appendAndPrependSlider.is().value(218);
        appendAndPrependText.is().value(Integer.toString(218));
    }

    @Test
    public void appendTextFieldSliderTest() {
        ArrayList<Integer> data = new ArrayList<>(Arrays.asList(150, 255));
        IntStream.range(1, 4).forEach(index -> {
            data.forEach(value -> {
                appendTextFieldSlider.get(index).slideHorizontalTo(value);
                appendTextFieldInput.get(index).is().value(Integer.toString(value));
                IntStream.range(1, 4).forEach(i -> appendTextFieldInput.get(index).sendKeys(BACK_SPACE));
                appendTextFieldInput.get(index).input(value.toString());
                appendTextFieldSlider.get(index).is().value(value);
            });
            IntStream.range(1, 4).forEach(i -> appendTextFieldInput.get(index).sendKeys(BACK_SPACE));
            appendTextFieldInput.get(index).input("256");
            appendTextFieldSlider.get(index).is().value(255);
            IntStream.range(1, 4).forEach(i -> appendTextFieldInput.get(index).sendKeys(BACK_SPACE));
        });
    }
}
