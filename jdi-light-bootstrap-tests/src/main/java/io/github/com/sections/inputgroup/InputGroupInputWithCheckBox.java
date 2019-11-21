package io.github.com.sections.inputgroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.TextField;


public class InputGroupInputWithCheckBox extends Section{
    @UI("./div/div")
    public Checkbox checkbox;
    @Css(".form-control") public TextField input;
}
