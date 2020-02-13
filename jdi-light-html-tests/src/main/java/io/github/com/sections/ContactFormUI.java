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

public class ContactFormUI extends Form<Contacts> {
	@UI("#name") TextField name;
	@UI("#last-name") TextField lastName;
	@UI("#position") TextField position;
	@UI("#passport-number") TextField passportNumber;
	@UI("#passport-seria") TextField passportSeria;

	@UI("#gender") Dropdown gender;
	@UI("#religion") IsCombobox religion;

	@UI("#passport") Checkbox passport;
	@UI("#accept-conditions") Checkbox acceptConditions;
	@UI("#description") TextArea description;

	@UI("['Submit']") public Button submit;
}