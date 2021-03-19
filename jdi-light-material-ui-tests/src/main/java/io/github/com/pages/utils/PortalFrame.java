package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.material.elements.utils.Portal;

public class PortalFrame extends Section {
    @UI("//button")
    public Button button;

    // TODO update with public Label or etc.
    @UI("//button/following::div[1]")
    public Portal field1;

    @UI("//button/following::div[2]")
    public Portal field2;
}
