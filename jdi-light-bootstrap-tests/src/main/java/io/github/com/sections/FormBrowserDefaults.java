package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.FormContacts;

public class FormBrowserDefaults extends Form<FormContacts> {

    @UI("#validationDefault01")
    public TextField name;
    @UI("#validationDefault02")
    public TextField lastName;
    @UI("#validationDefaultUsername")
    public TextField userName;
    @UI("#validationDefault03")
    public TextField city;
    @UI("#validationDefault04")
    public TextField state;
    @UI("#validationDefault05")
    public TextField zip;

    @UI("#invalidCheck2")
    public Checkbox accept;

    @UI("button")
    public Button submit;

}
