package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.elements.inputs.Slider;
import com.epam.jdi.light.material.elements.inputs.SliderRange;
import static io.github.com.MaterialNavigator.openSection;
import io.github.epam.TestsInit;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.github.com.pages.inputs.SlidersPage.*;


public class SliderTests extends TestsInit {

    @BeforeMethod
    public void before() {
        openSection("Slider");
    }

    @Test(dataProvider = "startValueData")
    public void currentValueTest(SliderChecking sliderChecking, int ... value) {
        sliderChecking.checkValue(value);
    }

    @Test(dataProvider = "isEnabledTestData")
    public void isEnabledTest(Slider slider, boolean isEnabled) {
        if (isEnabled){
            slider.is().enabled();
        } else {
            slider.is().disabled();
        }
    }

    @Test(dataProvider = "setValueTestData")
    public void setValueTest(Slider slider, SliderChecking sliderChecking, int newValue, int expectedValue){
        slider.setValue(newValue);
        sliderChecking.checkValue(expectedValue);
    }

    @Test(dataProvider = "setInputSliderData")
    public void setInputSliderTest(String input, int newValue, int expectedValue){
        if (input.equals("slider")){
            inputSlider.setValue(newValue);
        } else {
            inputSliderField.clear();
            String stringValue = newValue + "";
            inputSliderField.sendKeys(Keys.BACK_SPACE + "" + Keys.BACK_SPACE + stringValue + Keys.ENTER);
        }
        inputSliderChecking.checkValue(expectedValue);
    }

    @Test(dataProvider = "setValueRangeSliderData")
    public void setValueRangeSliderTest(int firstIndex, int leftValue, int secondIndex, int rightValue) {
        rangeSlider.setValue(firstIndex, leftValue);
        rangeSlider.setValue(secondIndex, rightValue);
        rangeSliderChecking.checkValue(Math.min(leftValue, rightValue), Math.max(leftValue, rightValue));
    }

    @Test(dataProvider = "rangeSliderOnOneValueData")
    public void rangeSliderOnOneValueTest(int index, int newValue){
        int sharedValue = 15;
        rangeSlider.setValue(1, sharedValue);
        rangeSlider.setValue(2, sharedValue);
        rangeSlider.setValue(index, newValue);
        rangeSliderChecking.checkValue(Math.min(newValue, sharedValue), Math.max(newValue, sharedValue));
    }

    @Test(dataProvider =  "outrangeValuesData")
    public void outrangeValuesTest(Slider slider, SliderChecking sliderChecking, int newValue, int expectedValue) {
        slider.setValue(newValue);
        sliderChecking.checkValue(expectedValue);
    }

    @Test(dataProvider = "outrangeValuesRangeSliderData")
    public void outrangeValuesRangeSliderTest(int firstIndex, int firstValue, int secondIndex, int secondValue, int firstExpectedValue, int secondExpectedValue){
        rangeSlider.setValue(firstIndex, firstValue);
        rangeSlider.setValue(secondIndex, secondValue);
        rangeSliderChecking.checkValue(firstExpectedValue, secondExpectedValue);
    }

    @Test(dataProvider = "disabledSliderSetValuesData")
    public void changeValuesDisabledSliderTest(Slider slider, SliderChecking sliderChecking, int newValue) {
        int currentValue = slider.value();
        slider.setValue(newValue);
        sliderChecking.checkValue(currentValue);
    }

    @Test(dataProvider = "orientationData")
    public void orientationTest(UIBaseElement slider, String expectedOrientation) {
        if (slider instanceof Slider){
            Slider thisSlider = (Slider)slider;
            thisSlider.is().orientation(expectedOrientation);
        } else {
            SliderRange thisSlider = (SliderRange)slider;
            thisSlider.is().orientation(expectedOrientation);
        }
    }

    @Test(dataProvider = "slideHorizontalData")
    public void slideHorizontalTest(Slider slider, SliderChecking sliderChecking, int newValue, int expectedValue) {
        slider.slideHorizontalTo(newValue);
        sliderChecking.checkValue(expectedValue);
    }

    @Test(dataProvider = "slideHorizontalRangeData")
    public void slideHorizontalRangeTest(int index, int newValue, int expectedValue){
        int notChangingValue = rangeSlider.value(index % 2 + 1);
        rangeSlider.slideHorizontalTo(index, newValue);
        rangeSliderChecking.checkValue(Math.min(notChangingValue, expectedValue), Math.max(notChangingValue, expectedValue));
    }

    @Test(dataProvider = "slideVerticalData")
    public void slideVerticalTest(int newValue, int expectedValue) {
        verticalSlider.slideVerticalTo(newValue);
        verticalSliderChecking.checkValue(expectedValue);
    }

    @Test(dataProvider = "moveLeftTestData")
    public void moveLeftTest(Slider slider, int expectedValue, SliderChecking sliderChecking, int startValue){
        slider.moveLeft();
        sliderChecking.checkValue(expectedValue);
        slider.setValue(startValue);
        slider.moveLeft();
        sliderChecking.checkValue(startValue);
    }

    @Test(dataProvider = "moveRightTestData")
    public void moveRightTest(Slider slider, int expectedValue, SliderChecking sliderChecking, int endValue){
        slider.moveRight();
        sliderChecking.checkValue(expectedValue);
        slider.setValue(endValue);
        slider.moveRight();
        sliderChecking.checkValue(endValue);
    }

    @Test(dataProvider = "disabledMoveTestData", expectedExceptions = ElementClickInterceptedException.class)
    public void disabledMoveTest(Slider slider, String direction){
        if (direction.equals("left")){
            slider.moveLeft();
        } else {
            slider.moveRight();
        }
    }

    @Test(dataProvider = "moveRangeSlider")
    public void moveRangeTest(int index, int startValue, int expectedValue, String direction){
        int notChangingValue = rangeSlider.value(index % 2 + 1);
        rangeSlider.setValue(index, startValue);
        if (direction.equals("left")){
            rangeSlider.moveLeft(index);
        } else {
            rangeSlider.moveRight(index);
        }
        rangeSliderChecking.checkValue(Math.min(notChangingValue, expectedValue), Math.max(notChangingValue, expectedValue));
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

                {verticalSlider, verticalSliderChecking, 39, 39},

                {disabledContinuousSlider, disabledContinuousSliderChecking, 77, 30},

                {disabledDiscreteSlider, disabledDiscreteSliderChecking, 70, 30}
        };
    }

    @DataProvider
    private Object[][] setInputSliderData(){
        return new Object[][]{
                {"slider", 50, 50},
                {"slider", 0, 0},
                {"slider", 100, 100},
                {"slider", -5, 0},
                {"slider", 123, 100},

                {"field", 50, 50},
                {"field", 0, 0},
                {"field", 100, 100},
                {"field", -5, 0},
                {"field", 123, 100}
        };
    }

    @DataProvider
    private Object[][] setValueRangeSliderData(){
        return new Object[][]{
                {1, 30, 2, 83},
                {1, 57, 1, 83},
                {1, 99, 1, 1},
                {1, 0, 2, 100}
        };
    }

    @DataProvider
    private Object[][] rangeSliderOnOneValueData(){
        return new Object[][] {
                {1, 88},
                {2, 88}
        };
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

                {verticalSlider, verticalSliderChecking, -6, 0},
                {verticalSlider, verticalSliderChecking, 243, 100}
        };
    }

    @DataProvider
    private Object[][] outrangeValuesRangeSliderData(){
        return new Object[][]{
                {1, -5, 2, 100, 0, 100},
                {1, -10, 2, -5, 0, 0},
                {1, 123, 1, 145, 100, 100},
        };
    }

    @DataProvider
    private Object[][] disabledSliderSetValuesData(){
        return new Object[][]{
                {disabledContinuousSlider, disabledContinuousSliderChecking, 75},
                {disabledDiscreteSlider, disabledDiscreteSliderChecking, 55}
        };
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
                {verticalSlider, "vertical"},
                {rangeSlider, "horizontal"}
        };
    }

    @DataProvider
    private Object[][] slideHorizontalData(){
        return new Object[][]{
                {continuousSlider, continuousSliderChecking, 0, 0},
                {continuousSlider, continuousSliderChecking, 45, 45},
                {continuousSlider, continuousSliderChecking, 100, 100},
                {continuousSlider, continuousSliderChecking, -3, 0},
                {continuousSlider, continuousSliderChecking, 123, 100},

                {discreteSlider, discreteSliderChecking, 10, 10},
                {discreteSlider, discreteSliderChecking, 40, 40},
                {discreteSlider, discreteSliderChecking, 100, 100},
                {discreteSlider, discreteSliderChecking, -10, 10},
                {discreteSlider, discreteSliderChecking, 120, 110},
                {discreteSlider, discreteSliderChecking, 44, 40},
                {discreteSlider, discreteSliderChecking, 47, 50},

                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 0, 0},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 37, 37},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 100, 100},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, -3, 0},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 120, 100},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 44, 37},
                {restrictedDiscreteSlider, restrictedDiscreteSliderChecking, 90, 100},

                {labelSlider, labelSliderChecking, 0, 0},
                {labelSlider, labelSliderChecking, 40, 40},
                {labelSlider, labelSliderChecking, 100, 100},
                {labelSlider, labelSliderChecking, -10, 0},
                {labelSlider, labelSliderChecking, 120, 100},
                {labelSlider, labelSliderChecking, 44, 40},
                {labelSlider, labelSliderChecking, 47, 50},

                {inputSlider, inputSliderChecking, 0, 0},
                {inputSlider, inputSliderChecking, 45, 45},
                {inputSlider, inputSliderChecking, 100, 100},
                {inputSlider, inputSliderChecking, -3, 0},
                {inputSlider, inputSliderChecking, 123, 100},

                {disabledContinuousSlider, disabledContinuousSliderChecking, 45, 30},

                {disabledDiscreteSlider, disabledDiscreteSliderChecking, 50, 30}
        };
    }

    @DataProvider
    private Object[][] slideHorizontalRangeData(){
        return new Object[][]{
                {1, 0, 0},
                {1, 10, 10},
                {1, -5, 0},
                {1, 55, 55},
                {2, 100, 100},
                {2, 77, 77},
                {2, 110, 100},
                {2, 10, 10}
        };
    }

    @DataProvider
    private Object[][] slideVerticalData(){
        return new Object[][]{
                {0, 0},
                {45, 45},
                {100, 100},
                {-3, 0},
                {123, 100}
        };
    }

    @DataProvider
    private Object[][] moveLeftTestData(){
        return new Object[][] {
                {continuousSlider, 29, continuousSliderChecking, 0},
                {discreteSlider, 20, discreteSliderChecking, 10},
                {restrictedDiscreteSlider, 0, restrictedDiscreteSliderChecking, 0},
                {labelSlider, 70, labelSliderChecking, 0},
                {inputSlider, 29, inputSliderChecking, 0},
                {verticalSlider, 29, verticalSliderChecking, 0}
        };
    }

    @DataProvider
    private Object[][] moveRightTestData(){
        return new Object[][] {
                {continuousSlider, 31, continuousSliderChecking, 100},
                {discreteSlider, 40, discreteSliderChecking, 110},
                {restrictedDiscreteSlider, 37, restrictedDiscreteSliderChecking, 100},
                {labelSlider, 90, labelSliderChecking, 100},
                {inputSlider, 31, inputSliderChecking, 100},
                {verticalSlider, 31, verticalSliderChecking, 100}
        };
    }

    @DataProvider
    private Object[][] disabledMoveTestData(){
        return new Object[][]{
                {disabledContinuousSlider, "left"},
                {disabledContinuousSlider, "right"},
                {disabledDiscreteSlider, "left"},
                {disabledDiscreteSlider, "right"}
        };
    }

    @DataProvider
    private Object[][] moveRangeSlider(){
        return new Object[][]{
                {1, 20, 19, "left"},
                {1, 20, 21, "right"},
                {1, 0, 0, "left"},
                {2, 70, 69, "left"},
                {2, 70, 71, "right"},
                {2, 100, 100, "right"}
        };
    }


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

    SliderChecking verticalSliderChecking = (int ... expectedValue) -> {
        verticalSlider.is().value(expectedValue[0]);
//        verticalSliderValue.is().text(containsString("Vertical Slider with value " + expectedValue[0]));
    };

    SliderChecking labelSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        labelSlider.is().value(expectedValue[0]);
        labelOfSlider.is().text(expectedValue[0] + "");
    };

    SliderChecking inputSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        inputSlider.is().value(expectedValue[0]);
        Assert.assertEquals(inputSliderField.getAttribute("value"), expectedValue[0] + "");
    };

    SliderChecking rangeSliderChecking = (SliderChecking)(int ... expectedValues) -> {
        rangeSlider.is()
                .value(1, expectedValues[0])
                .value(2, expectedValues[1]);
//        rangeSliderValue.is().text(containsString("Range Slider with selection from " + expectedValues[0] + " to " + expectedValues[1]));
    };
}


@FunctionalInterface
interface SliderChecking {
    void checkValue(int ... expectedValueLeft);
}

