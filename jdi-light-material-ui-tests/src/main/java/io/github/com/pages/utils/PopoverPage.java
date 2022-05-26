package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.Popover;

public class PopoverPage extends WebPage {

    @UI(".MuiPopover-root .MuiPaper-root")
    public static Popover popover;
}