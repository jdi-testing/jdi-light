package io.github.com.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.sections.form.FormValidationSection;

public class BootstrapFormPage extends WebPage {

    @UI("body")
    public FormValidationSection formValidationSection;

}
