package io.github.com.sections.form;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;

public class CheckboxesDefaultInline {

    @UI("//input[@id='inlineCheckbox1']/..")
    public Checkbox checkboxOne;
    @UI("//input[@id='inlineCheckbox2']/..")
    public Checkbox checkboxTwo;
    @UI("//input[@id='inlineCheckbox3']/..")
    public Checkbox checkboxThree;

}
