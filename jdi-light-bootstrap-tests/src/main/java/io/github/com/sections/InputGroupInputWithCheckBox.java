package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;



public class InputGroupInputWithCheckBox extends Section{
    @Css("[type=\"checkbox\"]") public Checkbox checkbox;
    @Css(".form-control") public TextField input;
}
