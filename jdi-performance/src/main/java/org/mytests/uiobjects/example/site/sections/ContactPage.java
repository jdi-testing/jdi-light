package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.complex.Droplist;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.MultiSelect;
import org.mytests.uiobjects.example.entities.Contacts;

public class ContactPage extends Form<Contacts> {
	TextField name, lastName, position, passportNumber, passportSeria;

	Droplist gender;
	Combobox religion;
	// HtmlMultiDropdown
	MultiSelect weather;

	public Checkbox passport, acceptConditions;
	TextArea description;

	@UI("['Submit']") public Button submit;
}