package com.epam.jdi.light.vuetify.asserts.breadcrumbs;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.breadcrumbs.Breadcrumb;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BreadcrumbAssert extends UIAssert<BreadcrumbAssert, Breadcrumb> implements ITextAssert {
	@Override
	@JDIAction("Assert that '{name}' has text '{0}'")
	public BreadcrumbAssert text(Matcher condition) {
		String actualText = element().getText();
		jdiAssert(actualText, condition, String.format("Element's actual text '%s' is not equal to expected '%s'",
				actualText, condition));
		return this;
	}
}
