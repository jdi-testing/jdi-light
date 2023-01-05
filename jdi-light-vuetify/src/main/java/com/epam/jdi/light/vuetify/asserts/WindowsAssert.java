package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Windows;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class WindowsAssert extends UIAssert<WindowsAssert, Windows> implements ThemeAssert<WindowsAssert, Windows> {
	@JDIAction("Assert that '{name}' shows arrows on hover")
	public WindowsAssert showArrowsOnHover() {
		jdiAssert(element().showArrowsOnHover(), Matchers.is(true), "Element doesn't show arrows on hover");
		return this;
	}

	@JDIAction("Assert that '{name}' doesn't show arrows on hover")
	public WindowsAssert notShowArrowsOnHover() {
		jdiAssert(element().showArrowsOnHover(), Matchers.is(false), "Element shows arrows on hover");
		return this;
	}

	@JDIAction("Assert that '{name}' has previous actions button")
	public WindowsAssert previousActionsButton() {
		jdiAssert(element().previousActionsButtonExists(), Matchers.is(true), "Element's previous " +
				"actions button doesn't exist");
		return this;
	}

	@JDIAction("Assert that '{name}' has no previous actions button")
	public WindowsAssert noPreviousActionsButton() {
		jdiAssert(element().previousActionsButtonExists(), Matchers.is(false), "Element's previous " +
				"actions button exists");
		return this;
	}

	@JDIAction("Assert that '{name}' has next actions button")
	public WindowsAssert nextActionsButton() {
		jdiAssert(element().nextActionsButtonExists(), Matchers.is(true), "Element's next actions " +
				"button doesn't exist");
		return this;
	}

	@JDIAction("Assert that '{name}' has no next actions button")
	public WindowsAssert noNextActionsButton() {
		jdiAssert(element().nextActionsButtonExists(), Matchers.is(false), "Element's next actions " +
				"button exists");
		return this;
	}

	@JDIAction("Assert that '{name}' has previous button")
	public WindowsAssert previousButton() {
		jdiAssert(element().previousButtonExists(), Matchers.is(true), "Element's previous " +
				"button doesn't exist");
		return this;
	}

	@JDIAction("Assert that '{name}' has no previous button")
	public WindowsAssert noPreviousButton() {
		jdiAssert(element().previousButtonExists(), Matchers.is(false), "Element's previous " +
				"button exists");
		return this;
	}

	@JDIAction("Assert that '{name}' has next button")
	public WindowsAssert nextButton() {
		jdiAssert(element().nextButtonExists(), Matchers.is(true), "Element's next " +
				"button doesn't exist");
		return this;
	}

	@JDIAction("Assert that '{name}' has no next button")
	public WindowsAssert noNextButton() {
		jdiAssert(element().nextButtonExists(), Matchers.is(false), "Element's next " +
				"button exists");
		return this;
	}

	@JDIAction("Assert that '{name}' has navigation buttons")
	public WindowsAssert navigationButtons() {
		jdiAssert(element().navigationButtonsExist(), Matchers.is(true), "Element's navigation " +
				"buttons don't exist");
		return this;
	}

	@JDIAction("Assert that '{name}' has no navigation buttons")
	public WindowsAssert noNavigationButtons() {
		jdiAssert(element().navigationButtonsExist(), Matchers.is(false), "Element's navigation " +
				"buttons exist");
		return this;
	}

	@JDIAction("Assert that '{name}' has navigation buttons")
	public WindowsAssert navigationButtonsNumber(int n) {
		int actualNavigationButtonsNumber = element().navigationButtonsNumber();
		jdiAssert(actualNavigationButtonsNumber, Matchers.is(n), String.format("Element's actual number of " +
				"navigation buttons '%s' is not equal to expected '%s'", actualNavigationButtonsNumber, n));
		return this;
	}
}
