package io.github.com.custom.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import io.github.com.entities.form.SingleTextField;

public class SingleTextFieldVuetifyForm extends Form<SingleTextField> {
	@UI(".v-input")
	public TextField firstName;

	@Override
	public void fill(SingleTextField entity) {
		firstName.setText(entity.firstName);
	}
}
