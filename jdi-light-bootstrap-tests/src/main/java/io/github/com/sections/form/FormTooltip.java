package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.FormContacts;

public class FormTooltip extends Form<FormContacts> {

    @UI("#validationTooltip01")
    public TextField name;
    @UI("#validationTooltip02")
    public TextField lastName;
    @UI("#validationTooltipUsername")
    public TextField userName;
    @UI("#validationTooltip03")
    public TextField city;
    @UI("#validationTooltip04")
    public TextField state;
    @UI("#validationTooltip05")
    public TextField zip;

    @UI("//input[@id='validationTooltip01']/../div")
    public Text tooltipName;
    @UI("//input[@id='validationTooltip02']/../div")
    public Text tooltipLastName;
    @UI("//input[@id='validationTooltipUsername']/../div[2]")
    public Text tooltipUserName;
    @UI("//input[@id='validationTooltip03']/../div")
    public Text tooltipCity;
    @UI("//input[@id='validationTooltip04']/../div")
    public Text tooltipState;
    @UI("//input[@id='validationTooltip05']/../div")
    public Text tooltipZip;

    @UI("button")
    public Button submit;

}
