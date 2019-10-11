package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.bootstrap.elements.complex.DataListOptions;

public class FormsSizing extends Section {
    @UI("#form-sizing-lg") public TextField largeTextField;
    @UI("#form-sizing-default") public TextField defaultTextField;
    @UI("#form-sizing-sm") public TextField smallTextField;
    @UI("#form-sizing-select-lg") public DataListOptions largeSelect;
    @UI("#form-sizing-select-default") public DataListOptions defaultSelect;
    @UI("#form-sizing-select-sm") public DataListOptions smallSelect;
}
