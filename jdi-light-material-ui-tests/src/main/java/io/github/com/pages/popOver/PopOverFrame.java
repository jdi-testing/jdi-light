package io.github.com.pages.popOver;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.popover.HoverOverPop;
import com.epam.jdi.light.material.elements.popover.PopOver;

public class PopOverFrame extends Section {

    @UI("MuiButtonBase-root")
    public PopOver popOver;

    @UI("MuiTypography-root")
    public HoverOverPop hoverOverPop;

}
