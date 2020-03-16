package io.github.epam.bootstrap.tests.common;

import com.epam.jdi.light.elements.composite.WebPage;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.*;
import static io.github.com.pages.BootstrapPage.*;
import static io.github.epam.bootstrap.tests.BaseValidationsUtils.*;
import static io.github.epam.states.States.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class RangeTests implements TestsInit {
    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
        defaultRange.show();
        defaultRange.setupValue(50);
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(defaultRange.labelText(), "Default range 0-100");
    }

    @Test
    public void getValueTest() {
        assertEquals(defaultRange.value(), 50);
    }

    @Test
    public void minTest() {
        assertEquals(defaultRange.min(), 0);
        assertEquals(minMaxRange.min(), 1);
        assertEquals(fractionalRange.min(), 2);
    }

    @Test
    public void maxTest() {
        assertEquals(defaultRange.max(), 100);
        assertEquals(minMaxRange.max(), 10);
        assertEquals(fractionalRange.max(), 7);
    }

    @Test
    public void stepTest() {
        assertEquals(defaultRange.step(), 1);
        assertEquals(minMaxRange.step(), 2);
        assertEquals(fractionalRange.step(), 0.5);
    }

    @Test
    public void setupValueTest() {
        defaultRange.setupValue(65);
        assertEquals(defaultRange.value(), 65);

        minMaxRange.setupValue(3);
        assertEquals(minMaxRange.value(), 3);

        fractionalRange.setupValue(3.5);
        assertEquals(fractionalRange.value(), 3.5);
    }

    @Test
    public void isValidationTest() {
        defaultRange.is().enabled();
        defaultRange.assertThat().minValue(0).and().maxValue(100).and().step(1);
        defaultRange.is().value(greaterThanOrEqualTo(10.0));
        defaultRange.is().value(lessThanOrEqualTo(100.0));
        defaultRange.has().value(50);
    }

    @Test
    public void labelTest() {
        assertEquals(defaultRange.label().getText(), "Default range 0-100");
        defaultRange.label().is().text(containsString("range 0-100"));
        defaultRange.label().assertThat().text(equalToIgnoringCase("default range 0-100"));
    }

    @Test
    public void assertValidationTest() {
        disabledRange.assertThat().value(greaterThan(0.0));
        disabledRange.assertThat().value(lessThan(200.0));
        disabledRange.assertThat().value(50);
    }

    @Test
    public void customRangeTest() {
        rangeControl.increase(2);
        rangeControl.assertThat().value(60);
        rangeControl.decrease(3);
        rangeControl.assertThat().value(45);
        WebPage.refresh();
    }

    @Test
    public void baseValidationTest() {
        baseValidation(defaultRange);
    }
}
