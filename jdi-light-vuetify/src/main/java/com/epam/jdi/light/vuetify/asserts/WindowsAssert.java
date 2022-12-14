package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Windows;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class WindowsAssert extends UIAssert<WindowsAssert, Windows> implements ThemeAssert<WindowsAssert, Windows> {
	@JDIAction("Assert thet '{name}' shows arrows on hover")
	public WindowsAssert showArrowsOnHover() {
		jdiAssert(element().showArrowsOnHover(), Matchers.is(true), "Element doesn't show arrows on hover");
		return this;
	}

	@JDIAction("Assert thet '{name}' doesn't show arrows on hover")
	public WindowsAssert notShowArrowsOnHover() {
		jdiAssert(element().showArrowsOnHover(), Matchers.is(false), "Element shows arrows on hover");
		return this;
	}
}
