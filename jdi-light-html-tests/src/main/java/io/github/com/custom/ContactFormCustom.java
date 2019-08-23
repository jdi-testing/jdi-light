package io.github.com.custom;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.pageobjects.annotations.Mandatory;
import com.epam.jdi.light.elements.pageobjects.annotations.simple.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.complex.Dropdown;
import io.github.com.entities.Contacts;

public class ContactFormCustom extends Form<Contacts> {
    @Mandatory TextField name;
    TextField lastName, position, passportNumber, passportSeria;

    Dropdown gender;
    IsCombobox religion;

    Checkbox passport, acceptConditions;
    TextArea description;

    @UI("['Submit']") public Button submit;
    @UI("['Submit']") public Button custom;
    @UI("['Submit']") public Button send;
    @UI("['Submit']") public Button add;
    @UI("['Submit']") public Button publish;
    @UI("['Submit']") public Button save;
    @UI("['Submit']") public Button update;
    @UI("['Submit']") public Button cancel;
    @UI("['Submit']") public Button close;
    @UI("['Submit']") public Button back;
    @UI("['Submit']") public Button select;
    @UI("['Submit']") public Button next;
    @UI("['Submit']") public Button search;
}
