package com.epam.jdi.light.vuetify.asserts.breadcrumbs;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.breadcrumbs.Breadcrumbs;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BreadcrumbsAssert extends UISelectAssert<BreadcrumbsAssert, Breadcrumbs> implements
		ThemeAssert<BreadcrumbsAssert, Breadcrumbs> {
	@JDIAction("Assert that '{0}' dividers satisfy a predicate '{1}'")
	public BreadcrumbsAssert dividerType(String symbol) {
		element().dividers().forEach(e -> jdiAssert(e.text().equals(symbol), Matchers.is(true), String.format(
				"Actual divider type '%s' is not equal to expected '%s'", e.text(), symbol)));
		return this;
	}

	@JDIAction("Assert that '{0}' dividers satisfy a predicate '{1}'")
	public BreadcrumbsAssert iconDivider(String iconClass) {
		element().dividers().forEach(e -> jdiAssert(e.find("i").hasClass(iconClass), Matchers.is(true), String.format(
				"Actual divider type '%s' is not equal to expected '%s'", e.text(), iconClass)));
		return this;
	}

	@JDIAction("Assert that '{name}' is large")
	public BreadcrumbsAssert large() {
		jdiAssert(element().isLarge(), Matchers.is(true), "Element is not large");
		return this;
	}

	@JDIAction("Assert that '{name}' is not large")
	public BreadcrumbsAssert notLarge() {
		jdiAssert(element().isLarge(), Matchers.is(false), "Element is large");
		return this;
	}

	@JDIAction("Assert that '{name}' is selected")
	public BreadcrumbsAssert selected(String item) {
		jdiAssert(element().selected(item), Matchers.is(true), "Element is not selected");
		return this;
	}

	@JDIAction("Assert that '{name}' is not selected")
	public BreadcrumbsAssert notSelected(String item) {
		jdiAssert(element().selected(item), Matchers.is(false), "Element is selected");
		return this;
	}
}
