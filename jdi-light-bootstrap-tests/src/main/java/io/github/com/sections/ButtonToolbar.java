package io.github.com.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;
import com.epam.jdi.light.ui.bootstrap.elements.common.TextField;

import java.util.List;

public class ButtonToolbar extends Section {

    @UI("button") public List<Button> buttonsInToolbar;

    @UI("input") public TextField inputAreaInToolbar;
}
