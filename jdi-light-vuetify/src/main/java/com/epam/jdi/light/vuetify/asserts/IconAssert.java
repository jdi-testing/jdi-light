package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.Icon;
import com.epam.jdi.light.vuetify.interfaces.asserts.AlignmentAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.CursorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class IconAssert extends UIAssert<IconAssert, Icon> implements CursorAssert<IconAssert, Icon>,
		AlignmentAssert<IconAssert, Icon>, ThemeAssert<IconAssert, Icon>, MeasurementAssert<IconAssert, Icon> {

	@JDIAction("Assert that '{name}' is clickable")
	public IconAssert clickable() {
		jdiAssert(element().core().isClickable(), Matchers.is(true), "Element is not clickable");
		return this;
	}

	@JDIAction("Assert that '{name}' has expected type")
	public IconAssert type(String iconType) {
		String actualIconType = element().hasType();
		jdiAssert(actualIconType, Matchers.is(iconType), String.format("Element's actual icon type '%s' is not equal " +
				"to expected '%s'", actualIconType, iconType));
		return this;
	}

	@JDIAction("Assert that '{name}' has expected color")
	public IconAssert color(String color) {
		String actualColor = element().color();
		jdiAssert(actualColor, Matchers.is(color), String.format("Actual element's color '%s' is not equal to " +
				"expected '%s'", actualColor, color));
		return this;
	}

	@JDIAction("Assert that '{name}' has alert after clicking on it")
	public IconAssert alertTextOnIconClick(String text) {
		String actualAlertText = element().getAlertTextOnIconClick();
		jdiAssert(actualAlertText, Matchers.is(text), String.format("Actual element's alert text '%s' is not equal " +
				"to expected '%s'", actualAlertText, text));
		return this;
	}

	@JDIAction("Assert that '{name}' has not label")
	public IconAssert hasNoLabel() {
		jdiAssert(element().hasLabel(), Matchers.is(false), "There a label for element");
		return this;
	}

	@JDIAction("Assert that '{name}' has icon name '{0}'")
	public IconAssert mdiIconName(String iconName) {
		String actualIconName = element().getMdiIconName();
		jdiAssert(actualIconName, Matchers.is(iconName), String.format("Actual element's mdi icon name '%s' is not " +
				"equal to expected '%s'", actualIconName, iconName));
		return this;
	}
}
