package io.github.com.pages.tooltip;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.tooltip.ToolTip;

public class ToolTipFrame extends Section {

    @UI("MuiButtonBase-root")
    public ToolTip toolTipButton;

    @UI("MuiIconButton-label")
    public ToolTip labelButton;

    @UI("MuiIconButton-colorPrimary")
    public ToolTip fadeButton;
}
