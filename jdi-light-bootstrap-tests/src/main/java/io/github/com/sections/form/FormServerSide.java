package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.FormContacts;

public class FormServerSide extends Form<FormContacts> {

    @UI("#validationServer01")
    public TextField name;
    @UI("#validationServer02")
    public TextField lastName;
    @UI("#validationServerUsername")
    public TextField userName;
    @UI("#validationServer03")
    public TextField city;
    @UI("#validationServer04")
    public TextField state;
    @UI("#validationServer05")
    public TextField zip;

    @UI("//input[@id='validationServer01']/../div")
    public Text feedbackName;
    @UI("//input[@id='validationServer02']/../div")
    public Text feedbackLastName;
    @UI("//input[@id='validationServerUsername']/../div[2]")
    public Text feedbackUserName;
    @UI("//input[@id='validationServer03']/../div")
    public Text feedbackCity;
    @UI("//input[@id='validationServer04']/../div")
    public Text feedbackState;
    @UI("//input[@id='validationServer05']/../div")
    public Text feedbackZip;
    @UI("//input[@id='invalidCheck3']/../div")
    public Text feedbackAccept;

    @UI("//input[@id='invalidCheck3']/..")
    public Checkbox accept;

    @UI("button")
    public Button submit;

}
