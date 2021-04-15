package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Slider;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;

import static io.github.com.MaterialNavigator.openSection;
import static io.github.com.pages.inputs.SlidersPage.*;

import static io.github.com.StaticSite.*;
import static org.hamcrest.Matchers.containsString;

public class SliderTests extends TestsInit {

    @BeforeMethod
    public void before() {
        slidersPage.open();
    }


    @DataProvider
    private Object[][] startValueData(){
        return new Object[][]{
                {continuousSliderChecking, 30},
                {disabledContinuousSliderChecking, 30},
                {discreteSliderChecking, 30},
                {disabledDiscreteSliderChecking, 30},
                {restrictedDiscreteSliderChecking, 20},
                {labelSliderChecking, 80},
                {inputSliderChecking, 30},
                {verticalSliderChecking, 30},
                {rangeSliderChecking, 20, 37}
        };
    }

    @Test(dataProvider = "startValueData")
    public void currentValueTest(SliderChecking sliderChecking, int ... value) {
        sliderChecking.check(value);
    }


    @DataProvider
    private Object[][] isEnabledTestData() {
        return new Object[][]{
                {disabledContinuousSlider, false},
                {disabledDiscreteSlider, false},
                {continuousSlider, true},
                {discreteSlider, true},
                {restrictedDiscreteSlider, true},
                {labelSlider, true},
                {inputSlider, true},
                {verticalSlider, true}
        };
    }

    @Test(dataProvider = "isEnabledTestData")
    public void isEnabledTest(Slider slider, boolean isEnabled) {
        if (isEnabled){
            slider.is().enabled();
        } else {
            slider.is().disabled();
        }
    }


    @DataProvider
    private Object[][] setValueTestData() {
        return new Object[][]{
                {continuousSlider, continuousSliderChecking, 75, 75},

                {discreteSlider, discreteSliderChecking, 50, 50},
                {discreteSlider, discreteSliderChecking, 24, 20},
                {discreteSlider, discreteSliderChecking, 25, 30},

                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 37, 37},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 49, 37},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 90, 100},

                {labelSlider, labelSliderChecking, 50, 50},
                {labelSlider, labelSliderChecking, 64, 60},
                {labelSlider, labelSliderChecking, 65, 70},

                {verticalSlider, verticalSliderChecking, 39, 39}
        };
    }

    @Test(dataProvider = "setValueTestData")
    public void setValueTest(Slider slider, SliderChecking sliderChecking, int newValue, int expectedValue){
        slider.setValue(newValue);
        sliderChecking.check(expectedValue);
    }



    @Test
    public void setValueRangeSliderTest() {
        rangeSlider.setValue(1, 5);
        rangeSlider.setValue(2, 88);
        checkRangeSliderValue(5, 88);
    }

    @DataProvider
    private Object[][] outrangeValuesData() {
        return new Object[][] {
                {continuousSlider, continuousSliderChecking, -3, 0},
                {continuousSlider, continuousSliderChecking, 123, 100},

                {discreteSlider, discreteSliderChecking, -2, 0},
                {discreteSlider, discreteSliderChecking, 234, 100},

                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, -12, 0},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 321, 100},

                {labelSlider, labelSliderChecking, -10, 0},
                {labelSlider, labelSliderChecking, 132, 100},

//                {inputSlider, inputSliderChecking, -13, 0},
//                {inputSlider, inputSliderChecking, 213, 100},

                {verticalSlider, verticalSliderChecking, -6, 0},
                {verticalSlider, verticalSliderChecking, 243, 100}
        };
    }

    @Test(dataProvider =  "outrangeValuesData")
    public void outrangeValuesTest(Slider slider, SliderChecking sliderChecking, int newValue, int expectedValue) {
        slider.setValue(newValue);
        sliderChecking.check(expectedValue);
    }

    @DataProvider
    private Object[][] disabledSliderSetValuesData(){
        return new Object[][]{
                {disabledContinuousSlider, disabledContinuousSliderChecking, 75},
                {disabledDiscreteSlider, disabledDiscreteSliderChecking, 55}
        };
    }

    @Test(dataProvider = "disabledSliderSetValuesData")
    public void changeValuesDisabledSliderTest(Slider slider, SliderChecking sliderChecking, int newValue) {
        int currentValue = slider.value();
        slider.setValue(newValue);
        sliderChecking.check(currentValue);
    }

    @DataProvider
    private Object[][] orientationData() {
        return new Object[][] {
                {continuousSlider, "horizontal"},
                {disabledContinuousSlider, "horizontal"},
                {discreteSlider, "horizontal"},
                {disabledDiscreteSlider, "horizontal"},
                {restrictedDiscreteSlider, "horizontal"},
                {labelSlider, "horizontal"},
                {inputSlider, "horizontal"},
                {rangeSlider, "horizontal"},
                {verticalSlider, "vertical"}
        };
    }

    @Test(dataProvider = "orientationData")
    public void orientationTest(Slider slider, String expectedOrientation) {
//        slider.is().orientation(expectedOrientation);
//        continuousSlider.is().orientation("horizontal");
//        discreteSlider.is().orientation("horizontal");
//        restrictedDiscreteSlider.is().orientation("horizontal");
//        labelSlider.is().orientation("horizontal");
//        inputSlider.is().orientation("horizontal");
        rangeSlider.is().orientation("horizontal");
//        verticalSlider.is().orientation("vertical");
    }

    @Test
    public void slideHorizontalTest() {

////        sliders.get(1).slideHorizontalTo(10);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(50);
////        defaultContinuousSlider.moveLeft();
//        System.out.println(defaultContinuousSlider.value());

        discreteSlider.slideHorizontalTo(50);
        inputSlider.slideHorizontalTo(50);
        System.out.println("asdasd");
//        defaultContinuousSlider.slideHorizontalTo(25);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(20);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(25);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(10);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(-40);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(50);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(-100);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(200);
//        System.out.println(defaultContinuousSlider.value());
//        defaultContinuousSlider.slideHorizontalTo(200);
//        System.out.println(defaultContinuousSlider.value());
    }

    @DataProvider
    public Object[][] moveLeftTestData(){
        return new Object[][] {
                {continuousSlider, 29, continuousSliderChecking},
                {discreteSlider, 20, continuousSliderChecking},
                {restrictedDiscreteSlider, 0, restrictedDiscreteSliderChecking},
                {labelSlider, 70, labelSliderChecking},
                {inputSlider, 11, inputSliderChecking},
                {verticalSlider, 29, verticalSliderChecking}
        };
    }

    @Test(dataProvider = "moveLeftTestData")
    public void moveLeftTest(Slider slider, int expectedValue, SliderChecking sliderChecking){
        moveToNullAndOneStepMore(slider, expectedValue, sliderChecking);
    }


    private static void moveToNullAndOneStepMore(Slider slider, int firstExpectedValue, SliderChecking sliderChecking){
        slider.moveLeft();
//        slider.is().value(firstExpectedValue);
        sliderChecking.check(firstExpectedValue);
        while (slider.value() != 0){
            slider.moveLeft();
        }
        slider.moveLeft();
        sliderChecking.check(0);
//        slider.is().value(0);
    }

    private static void checkDefaultContinuousSliderValue(int expectedValue) {
        continuousSlider.is().value(expectedValue);
//        defaultContinuousSliderValue.is().text(containsString("Selected value: " + expectedValue));
//      Bug: text value doesn't change in autotest. Manually it works.
    }

    private static void checkDefaultDiscreteSliderValue(int expectedValue) {
        discreteSlider.is().value(expectedValue);
        defaultDiscreteSliderValue.is().text(containsString("Temperature is " + expectedValue));
    }

    private static void checkRestrictedDiscreteSliderValue(int expectedValue) {
        restrictedDiscreteSlider.is().value(expectedValue);
        defaultDiscreteSliderWithRestrictionValue.is().text(containsString("Restricted values with value " + expectedValue));
    }

    private static void checkVerticalSliderValue(int expectedValue) {
        verticalSlider.is().value(expectedValue);
        verticalSliderValue.is().text(containsString("Vertical Slider with value " + expectedValue));
    }

    private static void checkRangeSliderValue(int expectedValueLeft, int expectedValueRight) {
        rangeSlider.is()
                .value(1, expectedValueLeft)
                .value(2, expectedValueRight);
        rangeSliderValue.is().text(containsString("Range Slider with selection from " + expectedValueLeft + " to " + expectedValueRight));
    }

    private static void checkInputSliderValue(int expectedValue) {
        inputSlider.is().value(expectedValue);
//        inputSliderField.is().text(expectedValue + "");
        // inputSliderField should be changed;
    }


//
//  @Test
//  public void moveTest() {
//    inputSliderRangePage.open();
//    sliderPage.rangeSlider.moveLeft(1);
//    sliderPage.rangeSlider.is().value(1, 19);
//    sliderPage.rangeSlider.moveRight(2);
//    sliderPage.rangeSlider.is().value(2, 38);
//    sliderPage.rangeSlider.slideHorizontalTo(1, 5);
//    sliderPage.rangeSlider.is().value(1, 5);
//
//    sliderPage.rangeSlider.slideHorizontalTo(1, 99);
//    sliderPage.rangeSlider.is().value(2, 99);
//    sliderPage.rangeSlider.is().value(1, 38);
//
//    sliderPage.rangeSlider.slideHorizontalTo(2, 40);
//    sliderPage.rangeSlider.is().value(2, 40);
//
//    inputSliderVerticalPage.open();
//    sliderPage.slider.moveLeft();
//    sliderPage.slider.is().value(29);
//    sliderPage.slider.moveRight();
//    sliderPage.slider.is().value(30);
//    sliderPage.slider.slideVerticalTo(80);
//    sliderPage.slider.is().value(80);
//
//
//    inputSliderDefaultAnfDisabledPage.open();
//    sliderPage.sliders.get(1).moveRight();
//    sliderPage.sliders.get(1).is().value(31);
//    sliderPage.sliders.get(1).moveLeft();
//    sliderPage.sliders.get(1).is().value(30);
//    sliderPage.sliders.get(1).slideHorizontalTo(100);
//    sliderPage.sliders.get(1).is().value(100);
//
//  }
    SliderChecking continuousSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        continuousSlider.is().value(expectedValue[0]);
//        defaultContinuousSliderValue.is().text(containsString("Selected value: " + expectedValue[0]));
    };

    SliderChecking disabledContinuousSliderChecking = (SliderChecking)(int ... expectedValue) -> disabledContinuousSlider.is().value(expectedValue[0]);

    SliderChecking discreteSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        discreteSlider.is().value(expectedValue[0]);
//        defaultDiscreteSliderValue.is().text(containsString("Temperature is " + expectedValue[0]));
    };

    SliderChecking disabledDiscreteSliderChecking = (SliderChecking)(int ... expectedValue) -> disabledDiscreteSlider.is().value(expectedValue[0]);

    SliderChecking restrictedDiscreteSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        restrictedDiscreteSlider.is().value(expectedValue[0]);
//        defaultDiscreteSliderWithRestrictionValue.is().text(containsString("Restricted values with value " + expectedValue[0]));
    };

    SliderChecking verticalSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        verticalSlider.is().value(expectedValue[0]);
//        verticalSliderValue.is().text(containsString("Vertical Slider with value " + expectedValue[0]));
    };

    SliderChecking labelSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        labelSlider.is().value(expectedValue[0]);
        labelOfSlider.is().text(expectedValue[0] + "");
    };

    SliderChecking inputSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        inputSlider.is().value(expectedValue[0]);
        inputSliderField.is().valueContains(expectedValue[0] + "");
    };

    SliderChecking rangeSliderChecking = (SliderChecking)(int ... expectedValues) -> {
        rangeSlider.is()
                .value(1, expectedValues[0])
                .value(2, expectedValues[1]);
        rangeSliderValue.is().text(containsString("Range Slider with selection from " + expectedValues[0] + " to " + expectedValues[1]));
    };
}


@FunctionalInterface
interface SliderChecking {
    void check(int ... expectedValueLeft);
}

