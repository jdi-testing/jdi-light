package io.github.com.sections.form;

import com.epam.jdi.light.elements.pageobjects.annotations.Name;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.composite.Form;
import com.epam.jdi.light.ui.html.elements.common.TextArea;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import io.github.com.entities.SupportMessage;

public class SupportMessageForm extends Form<SupportMessage> {

    public TextField supportEmail;
    public TextArea supportMessage;

    @UI("#support-button-submit")
    @Name(value = "submit")
    public Button supportButtonSubmit;

    @UI("#support-button-clear")
    @Name(value = "clear")
    public Button supportButtonClear;
}
