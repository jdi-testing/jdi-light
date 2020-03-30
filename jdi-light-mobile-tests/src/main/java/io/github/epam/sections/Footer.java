package io.github.epam.sections;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.ByText;
import com.epam.jdi.light.mobile.elements.common.Icon;

public class Footer extends Section {
    @ByText("About") public static Icon aboutLink;
}