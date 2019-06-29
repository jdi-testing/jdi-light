package io.github.com.custom;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.Combobox;
import com.epam.jdi.light.ui.html.elements.complex.Dropdown;
import io.github.com.entities.Contacts;

import java.lang.reflect.Field;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class ContactFormCustomGet extends Form<Contacts> {
    TextField name;
    TextField lastName, position, passportNumber, passportSeria;

    Dropdown gender;
    Combobox religion;

    Checkbox passport, acceptConditions;
    TextArea description;

    @UI("['Submit']") public Button submit;

    @Override
    public String getAction(Field field, Object element, Object parent) {
        logger.info("* Get " + element.toString());
        return super.getAction(field, element, parent);
    }
}
