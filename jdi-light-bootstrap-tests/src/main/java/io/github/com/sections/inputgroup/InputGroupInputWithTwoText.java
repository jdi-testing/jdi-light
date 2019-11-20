package io.github.com.sections.inputgroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;
import com.epam.jdi.light.ui.html.elements.common.Text;


public class InputGroupInputWithTwoText extends Section{
    @UI(".input-group-prepend .input-group-text") public Text text_pretend;
    @UI(".input-group-append .input-group-text") public Text text_append;
    @UI(".form-control") public TextField input;
}
