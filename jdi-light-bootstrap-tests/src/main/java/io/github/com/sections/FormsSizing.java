package io.github.com.sections;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class FormsSizing extends Section {
    @UI("form-sizing-lg") public TextField largeField;
    @UI("form-sizing-default") public TextField defaultField;
    @UI("form-sizing-sm") public TextField smallField;
    @UI("form-sizing-select-lg") public Dropdown largeSelect;
    @UI("form-sizing-default-lg") public Dropdown defaultSelect;
    @UI("form-sizing-sm-lg") public Dropdown smallSelect;
}
