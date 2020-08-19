package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.SliderSection.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.*;

public class SliderUnitTests extends TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        matSliderBasic.setupValue(0.0);
        matSliderFormatting.setupValue(1.0);
        sliderConfigurableMin.setValue("0");
        sliderConfigurableMax.setValue("100");
        sliderConfigurableStep.setValue("1");
    }

    @Test
    public void isDisplayedTest() {
        assertTrue(matSliderBasic.isDisplayed());
        assertTrue(matSliderFormatting.isDisplayed());
        assertTrue(matSliderConfigurable.isDisplayed());
    }

    @Test
    public void isVisibleTest() {
        matSliderBasic.show();
        assertTrue(matSliderBasic.isVisible());
        matSliderFormatting.show();
        assertTrue(matSliderFormatting.isVisible());
        matSliderConfigurable.show();
        assertTrue(matSliderConfigurable.isVisible());
    }

    @Test
    public void getSlidersValueTest() {
        assertEquals(matSliderBasic.value(), 0.0);
        assertEquals(matSliderFormatting.value(), 1.0);
        assertEquals(matSliderConfigurable.value(), 0.0);
    }

    @Test
    public void getSlidersExtremeValuesTest() {
        assertEquals(matSliderBasic.min(), 0.0);
        assertEquals(matSliderFormatting.min(), 1.0);
        assertEquals(matSliderConfigurable.min(), 0.0);

        assertEquals(matSliderBasic.max(), 100.0);
        assertEquals(matSliderFormatting.max(), 100000.0);
        assertEquals(matSliderConfigurable.max(), 100.0);
    }

    @Test
    public void setDoubleValueToSliderTest() {
        matSliderBasic.setupValue(45.0);
        assertEquals(matSliderBasic.value(), 45.0);

        matSliderFormatting.setupValue(4353.8);
        assertEquals(matSliderFormatting.value(), 4353.8);

        matSliderConfigurable.setupValue(34.5);
        assertEquals(matSliderConfigurable.value(), 34.5);
    }

    @Test
    public void setIntValueToSliderTest() {
        matSliderBasic.setupValue(45);
        assertEquals(matSliderBasic.value(), 45.0);

        matSliderFormatting.setupValue(4353);
        assertEquals(matSliderFormatting.value(), 4353.0);

        matSliderConfigurable.setupValue(34);
        assertEquals(matSliderConfigurable.value(), 34.0);
    }

    @Test
    public void setOrientationTest() {
        matSliderConfigurable.show();
        assertEquals(matSliderConfigurable.orientation(), "horizontal");

        sliderConfigurableVertical.check();
        assertEquals(matSliderConfigurable.orientation(), "vertical");

        sliderConfigurableVertical.uncheck();
        assertEquals(matSliderConfigurable.orientation(), "horizontal");
    }

    @Test
    public void isEnabledTest() {
        assertTrue(matSliderBasic.isEnabled());
        assertTrue(matSliderFormatting.isEnabled());
        assertTrue(matSliderConfigurable.isEnabled());
    }

    @Test
    public void isDisabledTest() {
        sliderConfigurableDisabled.check();
        assertFalse(matSliderBasic.isDisabled());
        assertFalse(matSliderFormatting.isDisabled());
        assertTrue(matSliderConfigurable.isDisabled());
        sliderConfigurableDisabled.uncheck();
    }
}
