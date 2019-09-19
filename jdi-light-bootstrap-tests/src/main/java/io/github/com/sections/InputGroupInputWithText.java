package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Text;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class InputGroupInputWithText extends Section {
    @Css(".input-group-text") public Text text;
    @Css(".form-control") public TextField input;
}
