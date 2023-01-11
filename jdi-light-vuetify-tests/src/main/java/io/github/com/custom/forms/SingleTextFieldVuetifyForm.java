package io.github.com.custom.forms;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.composite.VuetifyForm;
import io.github.com.entities.form.SingleTextField;

public class SingleTextFieldVuetifyForm extends VuetifyForm<SingleTextField> {
	@UI(".v-input")
	public TextField firstName;
}
