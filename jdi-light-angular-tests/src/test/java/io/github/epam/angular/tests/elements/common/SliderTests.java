package io.github.epam.angular.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;

public class SliderTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        sliderSection.matSliderBasic.setupValue(0.0);
        sliderSection.matSliderFormatting.setupValue(1.0);
        sliderSection.sliderConfigurableValue.setValue("0");
        sliderSection.sliderConfigurableMin.setValue("0");
        sliderSection.sliderConfigurableMax.setValue("100");
        sliderSection.sliderConfigurableStep.setValue("1");
    }

    @Test
    public void minTest() {
        sliderSection.matSliderBasic.show();
        sliderSection.matSliderBasic.is().minValue(0.0);

        sliderSection.matSliderFormatting.show();
        sliderSection.matSliderFormatting.is().minValue(1.0);

        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.is().minValue(0.0);
        sliderSection.sliderConfigurableMin.setValue("10");
        sliderSection.matSliderConfigurable.is().minValue(10.0);
    }

    @Test
    public void maxTest() {
        sliderSection.matSliderBasic.show();
        sliderSection.matSliderBasic.is().maxValue(100.0);

        sliderSection.matSliderFormatting.show();
        sliderSection.matSliderFormatting.is().maxValue(100000.0);

        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.is().maxValue(100.0);
        sliderSection.sliderConfigurableMax.setValue("1000");
        sliderSection.matSliderConfigurable.is().maxValue(1000.0);
    }

    @Test
    public void currentValueTest() {
        sliderSection.matSliderConfigurable.show();
        sliderSection.sliderConfigurableThumbLabel.check();
        sliderSection.sliderConfigurableValue.setValue("62");
        sliderSection.matSliderConfigurable.has().value(62.0);

        sliderSection.sliderConfigurableValue.setValue("100");
        sliderSection.matSliderConfigurable.has().value(100.0);

        sliderSection.sliderConfigurableValue.setValue("80.5");
        sliderSection.matSliderConfigurable.has().value(80.5);

        sliderSection.sliderConfigurableValue.setValue("0");
        sliderSection.matSliderConfigurable.has().value(0.0);
    }

    @Test
    public void stepValueTest() {
        sliderSection.matSliderConfigurable.show();
        sliderSection.sliderConfigurableStep.setValue("5");
        sliderSection.sliderConfigurableThumbLabel.check();

        sliderSection.sliderConfigurableValue.setValue("0");
        sliderSection.matSliderConfigurable.has().value(0.0);

        sliderSection.matSliderConfigurable.moveRight();
        sliderSection.matSliderConfigurable.has().value(5.0);

        sliderSection.matSliderConfigurable.moveRight();
        sliderSection.matSliderConfigurable.moveRight();
        sliderSection.matSliderConfigurable.moveRight();
        sliderSection.matSliderConfigurable.has().value(20.0);

        sliderSection.matSliderConfigurable.moveLeft();
        sliderSection.matSliderConfigurable.has().value(15.0);
    }

    @Test
    public void getValueTest() {
        sliderSection.matSliderBasic.show();
        sliderSection.matSliderBasic.has().value(0.0);
        sliderSection.matSliderFormatting.has().value(1.0);
        sliderSection.matSliderConfigurable.has().value(0.0);

        sliderSection.matSliderBasic.setupValue(30);
        sliderSection.matSliderBasic.has().value(30.0);

        sliderSection.matSliderFormatting.show();
        sliderSection.matSliderFormatting.setupValue(2000);
        sliderSection.matSliderFormatting.has().value(2000.0);

        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.setupValue(60);
        sliderSection.matSliderConfigurable.has().value(60.0);
    }

    @Test
    public void setupValueTest() {
        sliderSection.matSliderBasic.show();
        sliderSection.matSliderBasic.setupValue(15);
        sliderSection.matSliderBasic.has().value(15.0);

        sliderSection.matSliderFormatting.show();
        sliderSection.matSliderFormatting.setupValue(650);
        sliderSection.matSliderFormatting.has().value(650.0);

        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.setupValue(35.5);
        sliderSection.matSliderConfigurable.has().value(35.5);
    }

    @Test
    public void isValidationTest() {
        sliderSection.matSliderBasic.show();
        sliderSection.matSliderBasic.setupValue(65);
        sliderSection.matSliderBasic.is().enabled();
        sliderSection.matSliderBasic.is().displayed();
        sliderSection.matSliderBasic.has().value(greaterThanOrEqualTo(0.0));
        sliderSection.matSliderBasic.has().value(lessThanOrEqualTo(100.0));
        sliderSection.matSliderBasic.has().value(65.0);

        sliderSection.matSliderFormatting.show();
        sliderSection.matSliderFormatting.setupValue(8500);
        sliderSection.matSliderFormatting.is().enabled();
        sliderSection.matSliderFormatting.is().displayed();
        sliderSection.matSliderFormatting.has().value(greaterThanOrEqualTo(1.0));
        sliderSection.matSliderFormatting.has().value(lessThanOrEqualTo(100000.0));
        sliderSection.matSliderFormatting.has().value(equalTo(8500.0));

        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.setupValue(75);
        sliderSection.matSliderConfigurable.is().enabled();
        sliderSection.matSliderConfigurable.is().displayed();
        sliderSection.matSliderConfigurable.has().value(greaterThanOrEqualTo(0.0));
        sliderSection.matSliderConfigurable.has().value(lessThanOrEqualTo(100.0));
        sliderSection.matSliderConfigurable.has().value(equalTo(75.0));
    }

    @Test
    public void isDisabledTest() {
        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.is().enabled();
        sliderSection.matSliderConfigurable.is().displayed();

        sliderSection.sliderConfigurableDisabled.check();
        sliderSection.matSliderConfigurable.is().disabled();
        sliderSection.matSliderConfigurable.is().displayed();

        sliderSection.sliderConfigurableDisabled.uncheck();
        sliderSection.matSliderConfigurable.is().enabled();
        sliderSection.matSliderConfigurable.is().displayed();
    }

    @Test
    public void isInvertedTest() {
        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.is().inverted(false);
        sliderSection.matSliderConfigurable.is().displayed();

        sliderSection.sliderConfigurableInvert.check();
        sliderSection.matSliderConfigurable.is().inverted(true);
        sliderSection.matSliderConfigurable.is().displayed();

        sliderSection.sliderConfigurableInvert.uncheck();
        sliderSection.matSliderConfigurable.is().inverted(false);
        sliderSection.matSliderConfigurable.is().displayed();
    }

    @Test
    public void showThumbLabelTest() {
        sliderSection.matSliderConfigurable.show();
        sliderSection.sliderConfigurableThumbLabel.check();
        sliderSection.matSliderConfigurable.slide(20);
        sliderSection.matSliderConfigurable.is().thumbLabelDisplayed(true);

        sliderSection.sliderConfigurableThumbLabel.uncheck();
        sliderSection.matSliderConfigurable.is().thumbLabelDisplayed(false);

        sliderSection.matSliderConfigurable.slide(50);
        sliderSection.matSliderConfigurable.is().thumbLabelDisplayed(false);
    }

    @Test
    public void checkOrientationTest() {
        sliderSection.matSliderConfigurable.show();
        sliderSection.matSliderConfigurable.is().orientation("horizontal");
        sliderSection.matSliderConfigurable.is().displayed();

        sliderSection.sliderConfigurableVertical.check();
        sliderSection.matSliderConfigurable.is().orientation("vertical");
        sliderSection.matSliderConfigurable.is().displayed();

        sliderSection.sliderConfigurableVertical.uncheck();
        sliderSection.matSliderConfigurable.is().orientation("horizontal");
        sliderSection.matSliderConfigurable.is().displayed();
    }
}
