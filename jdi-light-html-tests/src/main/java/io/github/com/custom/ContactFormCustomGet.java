package io.github.com.custom;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.Contacts;

import java.lang.reflect.Field;

public class ContactFormCustomGet extends Form<Contacts> {
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

    @Override
    public String getAction(Field field, Object element, Object parent) {
        String value = super.getAction(field, element, parent);
        return field.getName().equals("firstName")
            ? value.toLowerCase()
            : value;
    }
}
