package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.surfaces.Accordion;
import com.epam.jdi.light.material.elements.inputs.Checkbox;

public class MaterialPage extends Section {

    @UI("//div[contains(@class,'MuiAccordion-root')]")
    public Accordion accordion;

    @UI("//span[contains(@class,'MuiButtonBase-root')]")
    public Checkbox checkbox;
}
