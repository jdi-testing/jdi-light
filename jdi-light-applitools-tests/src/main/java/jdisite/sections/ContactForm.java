package jdisite.sections;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.DataListOptions;
import jdisite.custom.MultiSelect;
import jdisite.entities.ContactInfo;

public class ContactForm extends Form<ContactInfo> {
    TextField name;
    TextField lastName;
    TextField position;
    TextField passportNumber;
    TextField passportSeria;

    DropdownSelect gender;
    DataListOptions religion;
    @UI("#weather")
    MultiSelect weather;

    Checkbox passport;
    Checkbox acceptConditions;
    TextArea description;
}