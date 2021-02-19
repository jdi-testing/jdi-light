package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Divider;

public class VerticalDividerFrame extends Section {

    @UI(".MuiDivider-root")
    public Divider divider;

}
