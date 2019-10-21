package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import org.mytests.uiobjects.example.entities.Contacts;
import org.mytests.uiobjects.example.site.custom.MultiDropdown;

import java.lang.reflect.Field;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class ContactForm extends Form<Contacts> {
	TextField name, lastName, position, passportNumber, passportSeria;

	DropdownSelect gender;
	DataListOptions religion;
	MultiDropdown weather;

	Checkbox passport, acceptConditions;
	TextArea description;

}