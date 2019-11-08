package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import io.github.com.sections.form.FormValidationSection;
import io.github.com.sections.form.SuperheroForm;
import io.github.com.sections.form.SupportMessageForm;

public class BootstrapFormsPage extends WebPage {
    @UI("#support-form")
    public static SupportMessageForm supportMessageForm;

    @UI("#superhero-creation-form")
    public static SuperheroForm superheroForm;

    @UI(".logs  li:first-child")
    public static Text lastLogEntry;

    public FormValidationSection formValidationSection;
}
