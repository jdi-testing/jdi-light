package io.github.epam.vuetify.tests.common;

import com.epam.jdi.light.vuetify.asserts.SliderAssert;
import com.epam.jdi.light.vuetify.asserts.SubheaderAssert;
import com.epam.jdi.light.vuetify.elements.common.Slider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static io.github.com.StaticSite.slidersPage;
import static io.github.com.pages.SlidersPage.colorsSlider;
import static io.github.com.pages.SlidersPage.disabledSlider;
import static io.github.com.pages.SlidersPage.discreteSlider;
import static io.github.com.pages.SlidersPage.iconsSlider;
import static io.github.com.pages.SlidersPage.iconsSliderInputIcon;
import static io.github.com.pages.SlidersPage.inverseLabel;
import static io.github.com.pages.SlidersPage.minAndMaxSlider;
import static io.github.com.pages.SlidersPage.readonlySlider;
import static io.github.com.pages.SlidersPage.stepSliderSlider;
import static io.github.com.pages.SlidersPage.thumbSliderSlider;

public class SlidersTests extends TestsInit {

    @BeforeClass
    public void before() {
        slidersPage.open();
        slidersPage.checkOpened();
    }

    @Test
    public void colorSliderTest() {
        colorsSlider.get(1).slideHorizontalTo(90);
        colorsSlider.get(1).is().value(90);
        colorsSlider.get(1).is().fillColor("orange");
        colorsSlider.get(1).is().backgroundColor("primary");
        colorsSlider.get(1).is().thumbColor("orange");
    }

    @Test
    public void trackColorSliderTest() {
        colorsSlider.get(2).slideHorizontalTo(90);
        colorsSlider.get(2).is().value(90);
        colorsSlider.get(2).is().fillColor("primary");
        colorsSlider.get(2).is().backgroundColor("green");
        colorsSlider.get(2).is().thumbColor("primary");
    }

    @Test
    public void thumbColorSliderTest() {
        colorsSlider.get(3).slideHorizontalTo(90);
        colorsSlider.get(3).is().value(90);
        colorsSlider.get(3).is().fillColor("primary");
        colorsSlider.get(3).is().backgroundColor("primary");
        colorsSlider.get(3).is().thumbColor("red");
        colorsSlider.get(3).is().thumbLabelColor("red");
        colorsSlider.get(3).is().thumbLabelValue(90);
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
        discreteSlider.slideHorizontalTo(15);
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
        stepSliderSlider.is().value(10);
        stepSliderSlider.slideHorizontalTo(0);
        stepSliderSlider.is().value(0);
        stepSliderSlider.slideHorizontalTo(24);
        stepSliderSlider.is().value(20);
        stepSliderSlider.slideHorizontalTo(25);
        stepSliderSlider.is().value(30);
    }

    @Test
    public void showThumbWhenUsingSliderTest() {
        thumbSliderSlider.get(1).is().thumbLabelNotDisplayed();
        thumbSliderSlider.get(1).getThumb().click();
        thumbSliderSlider.get(1).is().thumbLabelDisplayed();
        thumbSliderSlider.get(1).is().thumbLabelValue(Integer.parseInt(thumbSliderSlider.get(1).getValue()));

        thumbSliderSlider.get(1).slideHorizontalTo(0);
        thumbSliderSlider.get(1).is().thumbLabelValue(0);
        thumbSliderSlider.get(2).doubleClick();
        thumbSliderSlider.get(3).doubleClick(); // костыль
        thumbSliderSlider.get(1).is().thumbLabelNotDisplayed();
    }

    @Test
    public void alwaysShowThumbLabelsTest() {
        IntStream.range(2, 5).forEach(index ->
        {
            thumbSliderSlider.get(index).is().thumbLabelDisplayed();
            thumbSliderSlider.get(index).getThumb().click();
            thumbSliderSlider.get(index).is().thumbLabelDisplayed();
            thumbSliderSlider.get(index).slideHorizontalTo(0);
            thumbSliderSlider.get(1).doubleClick();
            thumbSliderSlider.get(1).doubleClick(); // костыль
            thumbSliderSlider.get(index).is().thumbLabelDisplayed();
        });
    }

}
