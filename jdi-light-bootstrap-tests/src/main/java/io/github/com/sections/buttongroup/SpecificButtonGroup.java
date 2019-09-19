package io.github.com.sections.buttongroup;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.bootstrap.elements.common.Button;

public class SpecificButtonGroup extends Section {

    @Css(".btn-info")
    public static Button cyanButton;

    @Css(".btn-primary")
    public static Button disabledButton;
}