package io.github.com.custom;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.interfaces.complex.IsCombobox;
import com.epam.jdi.light.elements.pageobjects.annotations.Mandatory;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.Contacts;

@SuppressWarnings("unused")
public class ContactFormCustom extends Form<Contacts> {
    private @Mandatory TextField name;
    public TextField lastName;
    public TextField position;
    public TextField passportNumber;
    public TextField passportSerial;

    public Dropdown gender;
    public IsCombobox religion;

    public Checkbox passport;
    public Checkbox acceptConditions;
    public TextArea description;

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
