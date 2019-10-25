package io.github.com.sections.form;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;

public class CheckboxesDefaultInline {

    //@UI("#inlineCheckbox1")
    @UI("//input[@id='inlineCheckbox1']/..")
    public Checkbox checkboxOne;
    //@UI("#inlineCheckbox2")
    @UI("//input[@id='inlineCheckbox2']/..")
    public Checkbox checkboxTwo;
    //@UI("#inlineCheckbox3")
    @UI("//input[@id='inlineCheckbox3']/..")
    public Checkbox checkboxThree;

}
