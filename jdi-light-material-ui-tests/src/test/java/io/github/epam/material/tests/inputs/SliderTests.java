package io.github.epam.material.tests.inputs;

import com.epam.jdi.light.material.elements.inputs.Slider;
import io.github.epam.TestsInit;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.slidersPage;
import static io.github.com.pages.inputs.SlidersPage.continuousSlider;
import static io.github.com.pages.inputs.SlidersPage.disabledContinuousSlider;
import static io.github.com.pages.inputs.SlidersPage.disabledDiscreteSlider;
import static io.github.com.pages.inputs.SlidersPage.discreteSlider;
import static io.github.com.pages.inputs.SlidersPage.inputSlider;
import static io.github.com.pages.inputs.SlidersPage.inputSliderField;
import static io.github.com.pages.inputs.SlidersPage.labelSlider;
import static io.github.com.pages.inputs.SlidersPage.rangeSlider;
import static io.github.com.pages.inputs.SlidersPage.restrictedDiscreteSlider;
import static io.github.com.pages.inputs.SlidersPage.verticalSlider;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class SliderTests extends TestsInit {
    private static final String HORIZONTAL = "horizontal";
    private static final String VERTICAL = "vertical";
    private static final String ENABLED = "enabled";
    private static final String DISABLED = "disabled";

    @BeforeMethod
    public void before() {
        slidersPage.open();
        slidersPage.isOpened();
    }

    @Test
    public void continuousSliderTest() {
        checkCondition(disabledContinuousSlider, DISABLED, HORIZONTAL, 30);

        checkCondition(continuousSlider, ENABLED, HORIZONTAL, 30);
        testSliderBasicLogic(continuousSlider, 15, 14, 15);
        continuousSlider.slideHorizontalTo(20);
        continuousSlider.has().value(20);
    }

    @Test
    public void discreteSlideTest() {
        disabledDiscreteSlider.is().disabled().and().discrete();

        discreteSlider.is().enabled().and().discrete();
        discreteSlider.has().value(30);
        testSliderBasicLogic(discreteSlider, 50, 40, 50);
    }

    @Test
    public void sliderWithRestrictionsTest() {
        checkCondition(restrictedDiscreteSlider, ENABLED, HORIZONTAL, 20);
        restrictedDiscreteSlider.assertThat().labelIsNotVisible();
        restrictedDiscreteSlider.slider().hover();
        restrictedDiscreteSlider.assertThat().labelIsVisible();
        restrictedDiscreteSlider.sliderLabel().has().text("2");
        testSliderBasicLogic(restrictedDiscreteSlider, 37,
                20, 37);
    }

    @Test
    public void labelSliderTest() {
        checkCondition(labelSlider, ENABLED, HORIZONTAL, 80);
        labelSlider.assertThat().labelIsVisible();
        labelSlider.sliderLabel().has().text("80");
        testSliderBasicLogic(labelSlider, 70, 60, 70);
    }

    @Test
    public void rangeSliderTest() {
        rangeSlider.is().enabled();
        rangeSlider.has().orientation(HORIZONTAL);
        checkRangeSlider(20, 37);
        rangeSlider.setValue(1, 19);
        rangeSlider.setValue(2, 95);
        checkRangeSlider(19, 95);
        rangeSlider.moveLeft(1);
        rangeSlider.moveLeft(2);
        checkRangeSlider(18, 94);
        rangeSlider.moveRight(1);
        rangeSlider.moveRight(2);
        checkRangeSlider(19, 95);
        rangeSlider.slideHorizontalTo(1, 10);
        rangeSlider.slideHorizontalTo(2, 80);
        checkRangeSlider(10, 80);
    }

    @Test
    public void inputSliderTest() {
        checkCondition(inputSlider, ENABLED, HORIZONTAL, 30);
        inputSlider.setValue(15);
        inputSlider.has().value(15);
        inputSliderField.clear();
        String stringValue = "70";
        inputSliderField.sendKeys(Keys.BACK_SPACE + "" + Keys.BACK_SPACE + stringValue + Keys.ENTER);
        inputSlider.has().value(70);
    }

    @Test
    public void verticalSliderTest() {
        checkCondition(verticalSlider, ENABLED, VERTICAL, 30);
        testSliderBasicLogic(verticalSlider, 40, 39, 41);
        verticalSlider.slideVerticalTo(80);
        verticalSlider.has().value(80);
    }

    private void checkRangeSlider(int left, int right) {
        rangeSlider.is()
                .value(1, left)
                .value(2, right);
    }

    private void testSliderBasicLogic(Slider slider, int setValue, int valueAfterDecrease,
                                      int valueAfterIncrease) {
        slider.setValue(setValue);
        slider.has().value(setValue);
        slider.decreaseValue();
        slider.has().value(valueAfterDecrease);
        slider.increaseValue();
        slider.has().value(valueAfterIncrease);
    }

    private void checkCondition(Slider slider, String accessibility, String orientation, int startedValue) {
        switch (accessibility) {
            case DISABLED:
                slider.is().disabled();
                break;
            case ENABLED:
                slider.is().enabled();
                break;
            default:
                logger.error("Condition %s not found", accessibility);
                break;
        }

        slider.has().orientation(orientation).and().value(startedValue);
    }
}

