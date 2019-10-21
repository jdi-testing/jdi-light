package io.github.com.sections.navbar;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.sections.inputgroup.InputGroupInputWithText;

public class NavbarWithInputGroupForm extends Section implements PageObject {
    @UI(".input-group") public InputGroupInputWithText inputGroup;
    @UI("form") public Form form;

}
