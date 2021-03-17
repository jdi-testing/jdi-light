package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SliderSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;

public class SliderTests extends TestsInit {

    @BeforeMethod
    public void before() {
        skip(); // not stable in CI. Sometimes setValue("anything") keeps focus on the field and nothing changes
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        matSliderBasic.setupValue(0.0);
        matSliderFormatting.setupValue(1.0);
        sliderConfigurableValue.setValue("0");
        sliderConfigurableMin.setValue("0");
        sliderConfigurableMax.setValue("100");
        sliderConfigurableStep.setValue("1");
    }

    @Test
    public void minTest() {
        matSliderBasic.show();
        matSliderBasic.is().minValue(0.0);

        matSliderFormatting.show();
        matSliderFormatting.is().minValue(1.0);

        matSliderConfigurable.show();
        matSliderConfigurable.is().minValue(0.0);
        sliderConfigurableMin.setValue("10");
        matSliderConfigurable.is().minValue(10.0);
    }

    @Test
    public void maxTest() {
        matSliderBasic.show();
        matSliderBasic.is().maxValue(100.0);

        matSliderFormatting.show();
        matSliderFormatting.is().maxValue(100000.0);

        matSliderConfigurable.show();
        matSliderConfigurable.is().maxValue(100.0);
        sliderConfigurableMax.setValue("1000");
        matSliderConfigurable.is().maxValue(1000.0);
    }

    @Test
    public void currentValueTest() {
        matSliderConfigurable.show();
        sliderConfigurableThumbLabel.check();
        sliderConfigurableValue.setValue("62");
        matSliderConfigurable.has().value(62.0);

        sliderConfigurableValue.setValue("100");
        matSliderConfigurable.has().value(100.0);

        sliderConfigurableValue.setValue("80.5");
        matSliderConfigurable.has().value(80.5);

        sliderConfigurableValue.setValue("0");
        matSliderConfigurable.has().value(0.0);
    }

    @Test
    public void stepValueTest() {
        matSliderConfigurable.show();
        sliderConfigurableStep.setValue("5");
        sliderConfigurableThumbLabel.check();

        sliderConfigurableValue.setValue("0");
        matSliderConfigurable.has().value(0.0);

        matSliderConfigurable.moveRight();
        matSliderConfigurable.has().value(5.0);

        matSliderConfigurable.moveRight();
        matSliderConfigurable.moveRight();
        matSliderConfigurable.moveRight();
        matSliderConfigurable.has().value(20.0);

        matSliderConfigurable.moveLeft();
        matSliderConfigurable.has().value(15.0);
    }

    @Test
    public void sliderBasicGetValueTest() {
        matSliderBasic.show();
        matSliderBasic.has().value(0.0);
        matSliderBasic.setupValue(30);
        matSliderBasic.has().value(30.0);
    }

    @Test
    public void sliderFormattingGetValueTest() {
        matSliderFormatting.has().value(1.0);
        matSliderFormatting.show();
        matSliderFormatting.setupValue(2000);
        matSliderFormatting.has().value(2000.0);
    }

    @Test
    public void sliderConfigurableGetValueTest() {
        matSliderConfigurable.has().value(0.0);
        matSliderConfigurable.show();
        matSliderConfigurable.setupValue(60);
        matSliderConfigurable.has().value(60.0);
    }

    @Test
    public void sliderBasicSetupValueTest() {
        matSliderBasic.show();
        matSliderBasic.setupValue(15);
        matSliderBasic.has().value(15.0);
    }

    @Test
    public void sliderFormattingSetupValueTest() {
        matSliderFormatting.show();
        matSliderFormatting.setupValue(650);
        matSliderFormatting.has().value(650.0);
    }

    @Test
    public void sliderConfigurableSetupValueTest() {
        matSliderConfigurable.show();
        matSliderConfigurable.setupValue(35.5);
        matSliderConfigurable.has().value(35.5);
    }

    @Test
    public void sliderBasicValidationTest() {
        matSliderBasic.show();
        matSliderBasic.setupValue(65);
        matSliderBasic.is().enabled();
        matSliderBasic.is().displayed();
        matSliderBasic.has().value(greaterThanOrEqualTo(0.0));
        matSliderBasic.has().value(lessThanOrEqualTo(100.0));
        matSliderBasic.has().value(65.0);
    }

    @Test
    public void sliderFormattingValidationTest() {
        matSliderFormatting.show();
        matSliderFormatting.setupValue(8500);
        matSliderFormatting.is().enabled();
        matSliderFormatting.is().displayed();
        matSliderFormatting.has().value(greaterThanOrEqualTo(1.0));
        matSliderFormatting.has().value(lessThanOrEqualTo(100000.0));
        matSliderFormatting.has().value(equalTo(8500.0));
    }

    @Test
    public void sliderConfigurableValidationTest() {
        matSliderConfigurable.show();
        matSliderConfigurable.setupValue(75);
        matSliderConfigurable.is().enabled();
        matSliderConfigurable.is().displayed();
        matSliderConfigurable.has().value(greaterThanOrEqualTo(0.0));
        matSliderConfigurable.has().value(lessThanOrEqualTo(100.0));
        matSliderConfigurable.has().value(equalTo(75.0));
        matSliderConfigurable.setupValue(0);
    }

    @Test
    public void isDisabledTest() {
        matSliderConfigurable.show();
        matSliderConfigurable.is().enabled();
        matSliderConfigurable.is().displayed();

        sliderConfigurableDisabled.check();
        matSliderConfigurable.is().disabled();
        matSliderConfigurable.is().displayed();

        sliderConfigurableDisabled.uncheck();
        matSliderConfigurable.is().enabled();
        matSliderConfigurable.is().displayed();
    }

    @Test
    public void isInvertedTest() {
        matSliderConfigurable.show();
        matSliderConfigurable.is().inverted(false);
        matSliderConfigurable.is().displayed();

        sliderConfigurableInvert.check();
        matSliderConfigurable.is().inverted(true);
        matSliderConfigurable.is().displayed();

        sliderConfigurableInvert.uncheck();
        matSliderConfigurable.is().inverted(false);
        matSliderConfigurable.is().displayed();
    }

    @Test
    public void showThumbLabelTest() {
        matSliderConfigurable.show();
        sliderConfigurableThumbLabel.check();
        matSliderConfigurable.slide(20);
        matSliderConfigurable.is().thumbLabelDisplayed(true);

        sliderConfigurableThumbLabel.uncheck();
        matSliderConfigurable.is().thumbLabelDisplayed(false);

        matSliderConfigurable.slide(50);
        matSliderConfigurable.is().thumbLabelDisplayed(false);
    }

    @Test
    public void checkOrientationTest() {
        matSliderConfigurable.show();
        matSliderConfigurable.is().orientation("horizontal");
        matSliderConfigurable.is().displayed();

        sliderConfigurableVertical.check();
        matSliderConfigurable.is().orientation("vertical");
        matSliderConfigurable.is().displayed();

        sliderConfigurableVertical.uncheck();
        matSliderConfigurable.is().orientation("horizontal");
        matSliderConfigurable.is().displayed();
    }
}
