package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import com.epam.jdi.light.ui.html.complex.MultiDropdown;
import org.mytests.uiobjects.example.entities.Contacts;

import java.lang.reflect.Field;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class ContactForm extends Form<Contacts> {
	TextField name, lastName, position, passportNumber, passportSeria;

	Dropdown gender;
	Combobox religion;
	MultiDropdown weather;

	Checkbox passport, acceptConditions;
	TextArea description;

	//@UI("['Submit']") public Button submit;

	@Override
	public void fillAction(Field field, Object element, Object parent, String setValue) {
		if (isInterface(field, TextField.class))
			((TextField)element).highlight();
		super.fillAction(field, element, parent, setValue);
	}
}