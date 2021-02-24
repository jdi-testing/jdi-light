package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Typography;

public class TypographyFrame extends Section {

    @UI(".MuiTypography-root.MuiTypography-h1")
    public Typography h1Typography;

    @UI(".MuiTypography-root.MuiTypography-subtitle2")
    public Typography subtitle2Typography;

    @UI(".MuiTypography-root.MuiTypography-button")
    public Typography buttonTypography;

}
