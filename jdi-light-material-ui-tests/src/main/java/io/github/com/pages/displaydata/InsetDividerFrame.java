package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIDivider;
import com.epam.jdi.light.material.elements.displaydata.Divider;
import com.epam.jdi.light.material.elements.inputs.Button;

public class InsetDividerFrame extends Section {

    @JDIDivider(root = "#root", divider = "(//li[contains(@class, 'MuiDivider-inset')])[1]")
    public Divider divider;

}
