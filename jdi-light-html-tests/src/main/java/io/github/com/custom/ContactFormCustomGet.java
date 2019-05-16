package io.github.com.custom;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.common.Button;
import com.epam.jdi.light.ui.html.common.Checkbox;
import com.epam.jdi.light.ui.html.common.TextArea;
import com.epam.jdi.light.ui.html.common.TextField;
import com.epam.jdi.light.ui.html.complex.Combobox;
import com.epam.jdi.light.ui.html.complex.Dropdown;
import io.github.com.entities.Contacts;

import java.lang.reflect.Field;

public class ContactFormCustomGet extends Form<Contacts> {
    @FirstTokenCapitalisation TextField name;
    TextField lastName, position, passportNumber, passportSeria;

    Dropdown gender;
    Combobox religion;

    Checkbox passport, acceptConditions;
    TextArea description;

    @UI("['Submit']") public Button submit;

    @Override
    public String getAction(Field field, Object element, Object parent) {
        if (field.isAnnotationPresent(FirstTokenCapitalisation.class)) {
            String getValue = super.getAction(field, element, parent);
            return getValue.substring(0, 1).toUpperCase() + getValue.substring(1);
        } else {
            return super.getAction(field, element, parent);
        }
    }
}
