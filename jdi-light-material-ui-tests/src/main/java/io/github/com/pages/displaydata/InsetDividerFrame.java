package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Divider;

public class InsetDividerFrame extends Section {

    @UI("(//li[contains(@class, 'MuiDivider-root')])[2]")
    public Divider divider;

}
