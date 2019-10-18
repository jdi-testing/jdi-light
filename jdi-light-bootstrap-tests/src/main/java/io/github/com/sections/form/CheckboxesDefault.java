package io.github.com.sections.form;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Checkbox;

public class CheckboxesDefault extends Section {

    @UI("#defaultCheck1") public Checkbox checkboxOne;
    @UI("#defaultCheck2") public Checkbox checkboxTwo;

}
