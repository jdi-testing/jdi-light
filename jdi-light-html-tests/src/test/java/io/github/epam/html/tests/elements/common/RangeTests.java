package io.github.epam.html.tests.elements.common;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.html5Page;
import static io.github.com.pages.HtmlElementsPage.disabledRange;
import static io.github.com.pages.HtmlElementsPage.volume;
import static io.github.epam.html.tests.elements.BaseValidations.baseValidation;
import static io.github.epam.html.tests.site.steps.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.testng.Assert.assertEquals;

/**
 * Created by Roman Iovlev on 19.08.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class RangeTests extends TestsInit {

	@BeforeMethod
	public void before() {
		shouldBeLoggedIn();
		html5Page.shouldBeOpened();
		volume.setValue(90);
	}

	@Test
	public void getLabelTextTest() {
		assertEquals(volume.labelText(), "Volume");
	}

	@Test
	public void getValueTest() {
		assertEquals(disabledRange.value(), 50);
	}

	@Test
	public void minTest() {
		assertEquals(volume.min(), 10.0);
	}

	@Test
	public void maxTest() {
		assertEquals(volume.max(), 100.0);
	}

	@Test
	public void stepTest() {
		assertEquals(volume.step(), 5.0);
	}

	@Test
	public void setValueTest() {
		volume.setValue(10);
		assertEquals(volume.value(), 10);
	}

	@Test
	public void isValidationTest() {
		volume.is().enabled();
		volume.assertThat().minValue(is(10.0));
		volume.assertThat().maxValue(is(100.0));
		volume.assertThat().step(is(5.0));
		volume.is().value(greaterThanOrEqualTo(10.0));
		volume.is().value(lessThanOrEqualTo(100.0));
		volume.is().value(is(90.0));
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
		disabledRange.assertThat().value(is(50.0));
	}

	@Test
	public void baseValidationTest() {
		baseValidation(volume);
	}
}
