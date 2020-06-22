package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.AngularPage.sliderSection;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class SliderUnitTests extends TestsInit {
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
    public void isDisplayedTest() {
        assertTrue(sliderSection.matSliderBasic.isDisplayed());
        assertTrue(sliderSection.matSliderFormatting.isDisplayed());
        assertTrue(sliderSection.matSliderConfigurable.isDisplayed());
    }

    @Test
    public void isVisibleTest() {
        sliderSection.matSliderBasic.show();
        assertTrue(sliderSection.matSliderBasic.isVisible());
        sliderSection.matSliderFormatting.show();
        assertTrue(sliderSection.matSliderFormatting.isVisible());
        sliderSection.matSliderConfigurable.show();
        assertTrue(sliderSection.matSliderConfigurable.isVisible());
    }

    @Test
    public void getSlidersValueTest() {
        assertEquals(sliderSection.matSliderBasic.value(), 0.0);
        assertEquals(sliderSection.matSliderFormatting.value(), 1.0);
        assertEquals(sliderSection.matSliderConfigurable.value(), 0.0);
    }

    @Test
    public void getSlidersExtremeValuesTest() {
        assertEquals(sliderSection.matSliderBasic.min(), 0.0);
        assertEquals(sliderSection.matSliderFormatting.min(), 1.0);
        assertEquals(sliderSection.matSliderConfigurable.min(), 0.0);

        assertEquals(sliderSection.matSliderBasic.max(), 100.0);
        assertEquals(sliderSection.matSliderFormatting.max(), 100000.0);
        assertEquals(sliderSection.matSliderConfigurable.max(), 100.0);
    }

    @Test
    public void setDoubleValueToSliderTest() {
        sliderSection.matSliderBasic.setupValue(45.0);
        assertEquals(sliderSection.matSliderBasic.value(), 45.0);

        sliderSection.matSliderFormatting.setupValue(4353.8);
        assertEquals(sliderSection.matSliderFormatting.value(), 4353.8);

        sliderSection.matSliderConfigurable.setupValue(34.5);
        assertEquals(sliderSection.matSliderConfigurable.value(), 34.5);
    }

    @Test
    public void setIntValueToSliderTest() {
        sliderSection.matSliderBasic.setupValue(45);
        assertEquals(sliderSection.matSliderBasic.value(), 45.0);

        sliderSection.matSliderFormatting.setupValue(4353);
        assertEquals(sliderSection.matSliderFormatting.value(), 4353.0);

        sliderSection.matSliderConfigurable.setupValue(34);
        assertEquals(sliderSection.matSliderConfigurable.value(), 34.0);
    }

    @Test
    public void setOrientationTest() {
        sliderSection.matSliderConfigurable.show();
        assertEquals(sliderSection.matSliderConfigurable.orientation(), "horizontal");

        sliderSection.sliderConfigurableVertical.check();
        assertEquals(sliderSection.matSliderConfigurable.orientation(), "vertical");

        sliderSection.sliderConfigurableVertical.uncheck();
        assertEquals(sliderSection.matSliderConfigurable.orientation(), "horizontal");
    }

    @Test
    public void isEnabledTest() {
        assertTrue(sliderSection.matSliderBasic.isEnabled());
        assertTrue(sliderSection.matSliderFormatting.isEnabled());
        assertTrue(sliderSection.matSliderConfigurable.isEnabled());
    }

    @Test
    public void isDisabledTest() {
        sliderSection.sliderConfigurableDisabled.check();
        assertFalse(sliderSection.matSliderBasic.isDisabled());
        assertFalse(sliderSection.matSliderFormatting.isDisabled());
        assertTrue(sliderSection.matSliderConfigurable.isDisabled());
        sliderSection.sliderConfigurableDisabled.uncheck();
    }
}
