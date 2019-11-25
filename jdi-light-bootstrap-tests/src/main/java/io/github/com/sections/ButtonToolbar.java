package io.github.com.sections;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.TextField;

public class ButtonToolbar extends Section {
    @UI("button") public WebList buttonsInToolbar;
    @UI("input") public TextField inputAreaInToolbar;
}
