package io.github.com.custom;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import io.github.com.entities.Contacts;

import java.lang.reflect.Field;

public class ContactFormCustomFill extends Form<Contacts> {
    TextField name,  lastName, position, passportNumber, passportSeria;

    Dropdown gender;
    IsCombobox religion;

    Checkbox passport, acceptConditions;
    TextArea description;

    @UI("['Submit']") public Button submit;

    @Override
    public void fillAction(Field field, Object element, Object parent, String setValue) {
        String value = setValue;
        if (field.getName().equals("name"))
            value = setValue.toUpperCase();
        super.fillAction(field, element, parent, value);
    }
}
