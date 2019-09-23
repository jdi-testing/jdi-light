package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.RadioButton;

public class RadioButtonGroup extends Section {

    @UI("#radio1") public RadioButton radio1;
    @UI("#radio2") public RadioButton radio2;
    @UI("#radio3") public RadioButton radio3;

}
