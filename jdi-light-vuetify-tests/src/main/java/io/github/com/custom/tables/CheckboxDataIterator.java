package io.github.com.custom.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import io.github.com.custom.asserts.CheckboxDataIteratorAssert;

import java.util.List;
import java.util.stream.Collectors;

public class CheckboxDataIterator extends DataIterator<Checkbox> {
	public CheckboxDataIterator(Class<Checkbox> type) {
		super(type);
	}

	@Override
	public CheckboxDataIteratorAssert is() {
		return (CheckboxDataIteratorAssert) new CheckboxDataIteratorAssert().set(this);
	}
	@JDIAction("Get '{name}' checkboxes")
	public List<Checkbox> checkboxes() {
		return finds(".v-input--checkbox")
				.stream()
				.map((e) -> new Checkbox().setCore(Checkbox.class, e))
				.collect(Collectors.toList());
	}

	@JDIAction("Check that '{name}' is checked")
	public boolean isChecked(int index) {
		return checkboxes().get(index).hasClass("v-input--is-dirty");
	}
}
