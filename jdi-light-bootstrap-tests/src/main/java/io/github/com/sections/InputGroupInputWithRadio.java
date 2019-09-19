package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.complex.RadioButtons;


public class InputGroupInputWithRadio extends Section{
    @Css("[type=\"radio\"]") public RadioButtons radio;
    @Css(".form-control") public TextField input;
}
