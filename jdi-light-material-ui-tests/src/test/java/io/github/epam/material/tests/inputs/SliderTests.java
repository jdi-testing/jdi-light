package io.github.epam.material.tests.inputs;

import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.slidersPage;
import static io.github.com.pages.inputs.SlidersPage.*;

/**
 * To see an example of Slider web element please visit
 * https://material-ui.com/components/slider/
 */

public class SliderTests extends TestsInit {
    @BeforeMethod
    public void before() {
        slidersPage.open();
    }

    @Test
    public void continuousSliderTest(){
        disabledContinuousSlider.is().disabled();
        disabledContinuousSlider.is().orientation("horizontal");
        disabledContinuousSlider.is().value(30);

        continuousSlider.is().enabled();
        continuousSlider.is().orientation("horizontal");
        continuousSlider.is().value(30);
        continuousSlider.setValue(15);
        continuousSlider.is().value(15);
        continuousSlider.moveLeft();
        continuousSlider.is().value(14);
        continuousSlider.moveRight();
        continuousSlider.is().value(15);
        continuousSlider.slideHorizontalTo(10);
        continuousSlider.is().value(10);
    }

    @Test
    public void discreteSlideTest(){
        disabledDiscreteSlider.is().disabled();
        disabledDiscreteSlider.is().orientation("horizontal");
        disabledDiscreteSlider.is().value(30);

        discreteSlider.is().enabled();
        discreteSlider.is().orientation("horizontal");
        discreteSlider.is().value(30);
        discreteSlider.setValue(50);
        discreteSlider.is().value(50);
        discreteSlider.moveLeft();
        discreteSlider.is().value(40);
        discreteSlider.moveRight();
        discreteSlider.is().value(50);
        discreteSlider.slideHorizontalTo(20);
        discreteSlider.is().value(20);
    }

    @Test
    public void sliderWithRestrictionsTest(){
        restrictedDiscreteSlider.is().enabled();
        restrictedDiscreteSlider.is().orientation("horizontal");
        restrictedDiscreteSlider.is().value(20);
        restrictedDiscreteSlider.setValue(37);
        restrictedDiscreteSlider.is().value(37);
        restrictedDiscreteSlider.moveLeft();
        restrictedDiscreteSlider.is().value(20);
        restrictedDiscreteSlider.moveRight();
        restrictedDiscreteSlider.is().value(37);
        restrictedDiscreteSlider.slideHorizontalTo(0);
        restrictedDiscreteSlider.is().value(0);
    }

    @Test
    public void labelSliderTest(){
        labelSlider.is().enabled();
        labelSlider.is().orientation("horizontal");
        labelSlider.is().value(80);
        labelSlider.setValue(70);
        labelSlider.is().value(70);
        labelSlider.moveLeft();
        labelSlider.is().value(60);
        labelSlider.moveRight();
        labelSlider.is().value(70);
        labelSlider.slideHorizontalTo(20);
        labelSlider.is().value(20);
    }

    @Test
    public void rangeSliderTest(){
        rangeSlider.is().enabled();
        rangeSlider.is().orientation("horizontal");
        checkRangeSlider(20, 37);
        rangeSlider.setValue(1, 19);
        rangeSlider.setValue(2, 95);
        checkRangeSlider(19, 95);
        rangeSlider.moveLeft(1);
        rangeSlider.moveLeft(2);
        checkRangeSlider(18,94);
        rangeSlider.moveRight(1);
        rangeSlider.moveRight(2);
        checkRangeSlider(19,95);
        rangeSlider.slideHorizontalTo(1, 10);
        rangeSlider.slideHorizontalTo(2, 80);
        checkRangeSlider(10, 80);
    }

    @Test
    public void inputSliderTest(){
        inputSlider.is().enabled();
        inputSlider.is().orientation("horizontal");
        inputSlider.is().value(30);
        inputSlider.setValue(15);
        inputSlider.is().value(15);
        inputSliderField.clear();
        String stringValue = "70";
        inputSliderField.sendKeys(Keys.BACK_SPACE + "" + Keys.BACK_SPACE + stringValue + Keys.ENTER);
        inputSlider.is().value(70);
        inputSlider.moveLeft();
        inputSlider.is().value(69);
        inputSlider.moveRight();
        inputSlider.is().value(70);
        inputSlider.slideHorizontalTo(10);
        inputSlider.is().value(10);
    }

    @Test
    public void verticalSliderTest(){
        verticalSlider.is().enabled();
        verticalSlider.is().orientation("vertical");
        verticalSlider.is().value(30);
        verticalSlider.setValue(40);
        verticalSlider.is().value(40);
        verticalSlider.slideVerticalTo(80);
        verticalSlider.is().value(80);
        verticalSlider.moveLeft();
        verticalSlider.is().value(79);
        verticalSlider.moveRight();
        verticalSlider.is().value(80);
    }

    private void checkRangeSlider(int left, int right){
        rangeSlider.is()
                .value(1, left)
                .value(2, right);
    }
}

