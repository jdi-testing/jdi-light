package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class FormAutoSizingAll extends Section {

    @UI("#inlineFormInput")
    public TextField name;
    @UI(".input-group-text")
    public TextField atSign;
    @UI("//input[@id='inlineFormInput']/..")
    public Text colParameterName;
    @UI("#inlineFormInputGroup")
    public TextField email;
    @UI("//label[@for='inlineFormInputGroup']/..")
    public Text colParameterEmail;
    @UI("#autoSizingCheck")
    public Checkbox rememberMeCheckbox;
    @UI("//input[@id='autoSizingCheck']/../..")
    public Text colParameterCheckbox;
    @UI("button")
    public Button submit;
    @UI("//button/..")
    public Button colParameterButton;
}
