package io.github.com.sections.form;

import com.epam.jdi.light.elements.complex.dropdown.DropdownSelect;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import io.github.com.entities.FormContacts;

public class FormInlinePreference extends Form<FormContacts> {

    @UI("#inlineFormCustomSelectPref")
    public DropdownSelect preferenceSelect;
    @UI("#customControlInline")
    public Checkbox rememberPreference;
    @UI(".btn")
    public Button submit;
}
