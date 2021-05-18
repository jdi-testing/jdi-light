package io.github.epam.material.tests.inputs;

import static io.github.com.MaterialNavigator.openSection;

import io.github.com.pages.utils.SliderChecking;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.pages.inputs.SlidersPage.*;


public class SliderTests extends TestsInit {
    @BeforeMethod
    public void before() {
        openSection("Slider");
    }

    @Test
    public void continuousSliderTest(){
        disabledContinuousSlider.is().disabled();
        disabledContinuousSlider.is().orientation("horizontal");
        disabledContinuousSliderChecking.checkValue(30);

        continuousSlider.is().enabled();
        continuousSlider.is().orientation("horizontal");
        continuousSliderChecking.checkValue(30);
        continuousSlider.setValue(15);
        continuousSliderChecking.checkValue(15);
        continuousSlider.moveLeft();
        continuousSliderChecking.checkValue(14);
        continuousSlider.moveRight();
        continuousSliderChecking.checkValue(15);
        continuousSlider.slideHorizontalTo(10);
        continuousSliderChecking.checkValue(10);
    }

    @Test
    public void discreteSlideTest(){
        disabledDiscreteSlider.is().disabled();
        disabledDiscreteSlider.is().orientation("horizontal");
        disabledDiscreteSliderChecking.checkValue(30);

        discreteSlider.is().enabled();
        discreteSlider.is().orientation("horizontal");
        discreteSliderChecking.checkValue(30);
        discreteSlider.setValue(50);
        discreteSliderChecking.checkValue(50);
        discreteSlider.moveLeft();
        discreteSliderChecking.checkValue(40);
        discreteSlider.moveRight();
        discreteSliderChecking.checkValue(50);
        discreteSlider.slideHorizontalTo(20);
        discreteSliderChecking.checkValue(20);
    }

    @Test
    public void sliderWithRestrictionsTest(){
        restrictedDiscreteSlider.is().enabled();
        restrictedDiscreteSlider.is().orientation("horizontal");
        restrictedDiscreteSliderChecking.checkValue(20);
        restrictedDiscreteSlider.setValue(37);
        restrictedDiscreteSliderChecking.checkValue(37);
        restrictedDiscreteSlider.moveLeft();
        restrictedDiscreteSliderChecking.checkValue(20);
        restrictedDiscreteSlider.moveRight();
        restrictedDiscreteSliderChecking.checkValue(37);
        restrictedDiscreteSlider.slideHorizontalTo(0);
        restrictedDiscreteSliderChecking.checkValue(0);
    }

    @Test
    public void labelSliderTest(){
        labelSlider.is().enabled();
        labelSlider.is().orientation("horizontal");
        labelSliderChecking.checkValue(80);
        labelSlider.setValue(70);
        labelSliderChecking.checkValue(70);
        labelSlider.moveLeft();
        labelSliderChecking.checkValue(60);
        labelSlider.moveRight();
        labelSliderChecking.checkValue(70);
        labelSlider.slideHorizontalTo(20);
        labelSliderChecking.checkValue(20);
    }

    @Test
    public void rangeSliderTest(){
        rangeSlider.is().enabled();
        rangeSlider.is().orientation("horizontal");
        rangeSliderChecking.checkValue(20, 37);
        rangeSlider.setValue(1, 19);
        rangeSlider.setValue(2, 95);
        rangeSliderChecking.checkValue(19, 95);
        rangeSlider.moveLeft(1);
        rangeSlider.moveLeft(2);
        rangeSliderChecking.checkValue(18, 94);
        rangeSlider.moveRight(1);
        rangeSlider.moveRight(2);
        rangeSliderChecking.checkValue(19, 95);
        rangeSlider.slideHorizontalTo(1, 10);
        rangeSlider.slideHorizontalTo(2, 80);
        rangeSliderChecking.checkValue(10, 80);
    }

    @Test
    public void inputSliderTest(){
        inputSlider.is().enabled();
        inputSlider.is().orientation("horizontal");
        inputSliderChecking.checkValue(30);
        inputSlider.setValue(15);
        inputSliderChecking.checkValue(15);
        inputSliderField.clear();
        String stringValue = "70";
        inputSliderField.sendKeys(Keys.BACK_SPACE + "" + Keys.BACK_SPACE + stringValue + Keys.ENTER);
        inputSliderChecking.checkValue(70);
        inputSlider.moveLeft();
        inputSliderChecking.checkValue(69);
        inputSlider.moveRight();
        inputSliderChecking.checkValue(70);
        inputSlider.slideHorizontalTo(10);
        inputSliderChecking.checkValue(10);
    }

    @Test
    public void verticalSliderTest(){
        verticalSlider.is().enabled();
        verticalSlider.is().orientation("vertical");
        verticalSliderChecking.checkValue(30);
        verticalSlider.setValue(40);
        verticalSliderChecking.checkValue(40);
        verticalSlider.slideVerticalTo(80);
        verticalSliderChecking.checkValue(80);
        verticalSlider.moveLeft();
        verticalSliderChecking.checkValue(79);
        verticalSlider.moveRight();
        verticalSliderChecking.checkValue(80);

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
//        labelOfSlider.is().text(expectedValue[0] + "");
    };

    SliderChecking inputSliderChecking = (SliderChecking)(int ... expectedValue) -> {
        inputSlider.is().value(expectedValue[0]);
//        Assert.assertEquals(inputSliderField.getAttribute("value"), expectedValue[0] + "");
    };

    SliderChecking rangeSliderChecking = (SliderChecking)(int ... expectedValues) -> {
        rangeSlider.is()
                .value(1, expectedValues[0])
                .value(2, expectedValues[1]);
//        rangeSliderValue.is().text(containsString("Range Slider with selection from " + expectedValues[0] + " to " + expectedValues[1]));
    };
}

