package io.github.com.pages.layouts;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Container;

public class ContainerFrame extends Section {
    @UI(".MuiTypography-root")
    public Container container;
}
