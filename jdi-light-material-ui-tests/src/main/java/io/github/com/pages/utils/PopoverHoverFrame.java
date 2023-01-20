package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.utils.Popover;


public class PopoverHoverFrame extends Section {

    @UI(".MuiTypography-root")
    public Typography labelToHover;

    @UI(".MuiPopover-paper")
    public Popover popover;
}
