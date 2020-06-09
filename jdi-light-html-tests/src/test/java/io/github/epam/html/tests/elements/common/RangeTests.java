package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.*;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class RangeTests implements TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        html5Page.shouldBeOpened();
        volume.setupValue(90);
    }

    @Test
    public void getLabelTextTest() {
        assertEquals(volume.labelText(), "Volume");
    }

    @Test
    public void getValueTest() {
        assertEquals(disabledRange.value(), 50.0);
    }
    @Test
    public void minTest() {
        assertEquals(volume.min(), 10.0);
        assertEquals(defaultRange.min(), 0.0);
        assertEquals(minMaxRange.min(), 1.0);
        assertEquals(fractionalRange.min(), 2.0);
    }
    @Test
    public void maxTest() {
        assertEquals(volume.max(), 100.0);
        assertEquals(defaultRange.max(), 100.0);
        assertEquals(minMaxRange.max(), 10.0);
        assertEquals(fractionalRange.max(), 7.0);
    }
    @Test
    public void stepTest() {
        assertEquals(volume.step(), 5.0);
        assertEquals(defaultRange.step(), 1.0);
        assertEquals(minMaxRange.step(), 2.0);
        assertEquals(fractionalRange.step(), 0.5);
    }

    @Test
    public void setupValueTest() {
        volume.setupValue(10);
        assertEquals(volume.value(), 10.0);

        defaultRange.setupValue(65);
        assertEquals(defaultRange.value(), 65.0);

        minMaxRange.setupValue(3);
        assertEquals(minMaxRange.value(), 3.0);

        fractionalRange.setupValue(3.5);
        assertEquals(fractionalRange.value(), 3.5);
    }

    @Test
    public void isValidationTest() {
        volume.is().enabled();
        volume.assertThat().minValue(10).and().maxValue(100).and().step(5);
        volume.is().value(greaterThanOrEqualTo(10.0));
        volume.is().value(lessThanOrEqualTo(100.0));
        volume.has().value(90);
    }

    @Test
    public void labelTest() {
        assertEquals(volume.label().getText(), "Volume");
        volume.label().is().text(containsString("lume"));
        volume.label().assertThat().text(equalToIgnoringCase("volume"));
    }

    @Test
    public void assertValidationTest() {
        volume.assertThat().value(greaterThan(0.0));
        volume.assertThat().value(lessThan(200.0));
        disabledRange.assertThat().value(50);
    }

    @Test
    public void baseValidationTest() {
        baseValidation(volume);
    }
}
