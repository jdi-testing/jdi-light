package io.github.com.sections.form;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import io.github.com.entities.FormSignUp;

public class FormOverview extends Form<FormSignUp> {
    @UI(".//*[@for='exampleInputEmail1']")
    public Label emailLabel;
    @UI("#exampleInputEmail1")
    public TextField email;
    @UI("#emailHelp")
    public Label help;

    @UI(".//*[@for='exampleInputPassword1']")
    public Label passwordLabel;
    @UI("#exampleInputPassword1")
    public TextField password;

    @UI(".//*[@for='exampleCheck1']")
    public Label acceptLabel;
    @UI("//input[@id='exampleCheck1']/..")
    public Checkbox accept;

    @UI("button")
    public Button submit;
}
