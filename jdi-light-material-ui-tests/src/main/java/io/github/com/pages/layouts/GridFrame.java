package io.github.com.pages.layouts;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class GridFrame extends Section {

    @UI(".MuiGrid-root[1]")
    public static UIElement rootGrid;

    @UI(".MuiButton-root[1]")
    public static UIElement firstButton;

    @UI(".MuiButton-root[2]")
    public static UIElement secondButton;
}
