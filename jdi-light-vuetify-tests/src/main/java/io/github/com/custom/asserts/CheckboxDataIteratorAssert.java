package io.github.com.custom.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.asserts.tables.DataIteratorAssert;
import io.github.com.custom.tables.CheckboxDataIterator;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class CheckboxDataIteratorAssert extends DataIteratorAssert {
	@Override
	public CheckboxDataIterator element() {
		return (CheckboxDataIterator) super.element();
	}

	@JDIAction("Assert that '{name}' is checked")
	public CheckboxDataIteratorAssert checked(int index) {
		jdiAssert(element().isChecked(index), Matchers.is(true), "Element is unchecked");
		return this;
	}

	@JDIAction("Assert that '{name}' is unchecked")
	public CheckboxDataIteratorAssert unchecked(int index) {
		jdiAssert(element().isChecked(index), Matchers.is(false), "Element is checked");
		return this;
	}
}
