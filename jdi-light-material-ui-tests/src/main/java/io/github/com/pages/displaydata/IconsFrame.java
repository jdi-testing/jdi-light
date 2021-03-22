package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.datadisplay.Icons;

public class IconsFrame extends Section {
    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][1]/*[name()='svg'][1]")
    public Icons filled1;

    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][1]/*[name()='svg'][2]")
    public Icons filled2;

    @UI("//div[contains(@class, 'MuiGrid-grid-xs-8')][2]/*[name()='svg'][1]")
    public Icons oulined1;

    @UI(".MuiSvgIcon-root[1]")
    public Icons svg1;

    @UI(".MuiSvgIcon-root[2]")
    public Icons svg2;
}
