package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.SystemBar;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SystemBarAssert extends BasicBarAssert<SystemBarAssert, SystemBar>
		implements ThemeAssert<SystemBarAssert, SystemBar>, MeasurementAssert<SystemBarAssert, SystemBar> {

	@JDIAction("Assert that '{name}' is lights out")
	public SystemBarAssert lightsOut() {
		jdiAssert(element().isLightsOut(), Matchers.is(true), "Element is not lights-out");
		return this;
	}

	@JDIAction("Assert that '{name}' is not lights out")
	public SystemBarAssert notLightsOut() {
		jdiAssert(element().isLightsOut(), Matchers.is(false), "Element is lights-out");
		return this;
	}

	@JDIAction("Assert that '{name}' is window")
	public SystemBarAssert window() {
		jdiAssert(element().isWindow(), Matchers.is(true), "Element is not window");
		return this;
	}

	@JDIAction("Assert that '{name}' is not window")
	public SystemBarAssert notWindow() {
		jdiAssert(element().isWindow(), Matchers.is(false), "Element is window");
		return this;
	}

	@JDIAction("Assert that '{name}' has title text '{0}'")
	public SystemBarAssert titleText(String titleText) {
		String actualTitleText = element().title().getText();
		jdiAssert(actualTitleText, Matchers.equalTo(titleText), String.format("Element's title text" +
				" '%s' is not equal to expected '%s'", actualTitleText, titleText));
		return this;
	}
}
