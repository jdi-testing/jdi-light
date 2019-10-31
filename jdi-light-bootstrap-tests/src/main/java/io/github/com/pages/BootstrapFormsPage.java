package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.entities.SupportMessage;
import io.github.com.sections.form.SuperheroForm;

public class BootstrapFormsPage extends WebPage {
    @UI("#support-form")
    public static Form<SupportMessage> supportMessageForm;

    @UI("#superhero-creation-form")
    public static SuperheroForm superheroForm;
}
