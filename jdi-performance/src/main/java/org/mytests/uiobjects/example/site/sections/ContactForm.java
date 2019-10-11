package org.mytests.uiobjects.example.site.sections;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.mytests.uiobjects.example.entities.Contacts;
import org.mytests.uiobjects.example.site.custom.MultiDropdown;

import java.lang.reflect.Field;

import static com.epam.jdi.tools.ReflectionUtils.isInterface;

public class ContactForm extends Form<Contacts> {
	public TextField name;
	public TextField lastName;
	public TextField position;
	public TextField passportNumber;
	public TextField passportSerial;

	public DropdownSelect gender;
	public IsCombobox religion;
	public MultiDropdown weather;

	public Checkbox passport;
	public Checkbox acceptConditions;
	public TextArea description;

	//@UI("['Submit']") public Button submit;

	@Override
	public void fillAction(Field field, Object element, Object parent, String setValue) {
		if (isInterface(field, TextField.class))
			((TextField)element).highlight();
		super.fillAction(field, element, parent, setValue);
	}
}