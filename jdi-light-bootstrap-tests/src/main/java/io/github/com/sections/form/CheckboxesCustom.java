package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;

public class CheckboxesCustom extends Section {

    @UI("#customCheck1-div") public Checkbox checkboxContainer;
    @UI("#customCheck1") public Checkbox checkbox;

}
