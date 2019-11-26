package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.complex.RadioButtons;

public class FormValidationSection extends Section {

    @UI(".custom-control-input")
    private RadioButtons radioButtons;

    @UI("#validated-form")
    private FormValidationForm validatedForm;

    public void switchToBrowserValidation() {
        radioButtons.select("Browser validation");
    }

    public void switchToCustomValidation() {
        radioButtons.select("Custom validation");
    }

    public FormValidationForm getForm() {
        return validatedForm;
    }

}
