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
	public TextField name;
	public TextField lastName;
	public TextField position;
	public TextField passportNumber;
	public TextField passportSerial;

	public Dropdown gender;
	public IsCombobox religion;

	public Checkbox passport;
	public Checkbox acceptConditions;
	public TextArea description;

	@UI("['Submit']") public Button submit;
}