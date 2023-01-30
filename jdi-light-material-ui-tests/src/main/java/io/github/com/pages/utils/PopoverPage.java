package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.Popover;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class PopoverPage extends WebPage {

    @UI(".MuiPopover-root .MuiPaper-root")
    public static Popover popover;

    @UI(".MuiButton-root")
    public static Button popoverButton;

    @UI("//span[text()='[Hover to open Popover]']")
    public static Button popoverButtonHover;
}
