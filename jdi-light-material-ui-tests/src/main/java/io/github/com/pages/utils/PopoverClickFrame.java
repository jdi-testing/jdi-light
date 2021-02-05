package io.github.com.pages.utils;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.Popover;

public class PopoverClickFrame extends Section {

    @UI(".MuiButton-root")
    public UIElement buttonToClick;

    @UI(".MuiPopover-paper")
    public Popover popover;
}
