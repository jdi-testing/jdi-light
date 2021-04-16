package io.github.com.sections;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.Contacts;


public class ContactForm extends Form<Contacts> {
	TextField firstName;
	TextField lastName;
	TextField position;
	TextField passportNumber;
	TextField passportSeria;

	Dropdown gender;
	IsCombobox religion;

	Checkbox passport;
	Checkbox acceptConditions;
	TextArea description;

	@UI("['Submit']") public Button submit;
}