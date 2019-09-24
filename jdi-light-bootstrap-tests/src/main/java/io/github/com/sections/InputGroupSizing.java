package io.github.com.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

public class InputGroupSizing extends Section {

    @Css(".input-group-prepend") public Label label;
    @Css(".form-control") public TextField input;
}