package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.Footer;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.TileAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class FooterAssert extends UIAssert<FooterAssert, Footer> implements ITextAssert<FooterAssert>,
		ColorAssert<FooterAssert, Footer>, ThemeAssert<FooterAssert, Footer>, ElevationAssert<FooterAssert, Footer>,
		MeasurementAssert<FooterAssert, Footer>, OutlinedAssert<FooterAssert, Footer>,
		RoundedAssert<FooterAssert, Footer>, ShapedAssert<FooterAssert, Footer>, TileAssert<FooterAssert, Footer> {
	@Override
	@JDIAction("Assert that '{name}' has text '{0}'")
	public FooterAssert text(Matcher<String> condition) {
		String actualText = element().getText();
		jdiAssert(actualText, condition, String.format("Actual element's text '%s' is not equal to expected '%s'",
				actualText, condition));
		return this;
	}

	@JDIAction("Assert that '{name}' is padless")
	public FooterAssert padless() {
		jdiAssert(element().isPadless(), Matchers.is(true), "Element is not padless");
		return this;
	}

	@JDIAction("Assert that '{name}' is not padless")
	public FooterAssert notPadless() {
		jdiAssert(element().isPadless(), Matchers.is(false), "Element is padless");
		return this;
	}

	@JDIAction("Assert that '{name}' is absolute")
	public FooterAssert absolute() {
		jdiAssert(element().isAbsolute(), Matchers.is(true), "Element is not absolute");
		return this;
	}

	@JDIAction("Assert that '{name}' is not absolute")
	public FooterAssert notAbsolute() {
		jdiAssert(element().isAbsolute(), Matchers.is(false), "Element is absolute");
		return this;
	}

	@JDIAction("Assert that '{name}' is fixed")
	public FooterAssert fixed() {
		jdiAssert(element().isFixed(), Matchers.is(true), "Element is not fixed");
		return this;
	}

	@JDIAction("Assert that '{name}' is not fixed")
	public FooterAssert notFixed() {
		jdiAssert(element().isFixed(), Matchers.is(false), "Element is fixed");
		return this;
	}

	@JDIAction("Assert that '{name}' max height is '{0}'")
	public FooterAssert maxHeight(int height) {
		int actualHeight = element().maxHeight();
		jdiAssert(actualHeight, Matchers.equalTo(height), String.format("Actual element's max height '%s px' is not " +
				"equal to expected '%s px'", actualHeight, height));
		return this;
	}

	@JDIAction("Assert that '{name}' max width is '{0}'")
	public FooterAssert maxWidth(int width) {
		int actualWidth = element().maxWidth();
		jdiAssert(actualWidth, Matchers.equalTo(width), String.format("Actual element's max width '%s px' is not " +
				"equal to expected '%s px'", actualWidth, width));
		return this;
	}

	@JDIAction("Assert that '{name}' min height is '{0}'")
	public FooterAssert minHeight(int height) {
		int actualHeight = element().minHeight();
		jdiAssert(actualHeight, Matchers.equalTo(height), String.format("Actual element's min height '%s px' is not " +
				"equal to expected '%s px'", actualHeight, height));
		return this;
	}

	@JDIAction("Assert that '{name}' min width is '{0}'")
	public FooterAssert minWidth(int width) {
		int actualWidth = element().minWidth();
		jdiAssert(actualWidth, Matchers.equalTo(width), String.format("Actual element's min width '%s px' is not " +
				"equal to expected '%s px'", actualWidth, width));
		return this;
	}
}
