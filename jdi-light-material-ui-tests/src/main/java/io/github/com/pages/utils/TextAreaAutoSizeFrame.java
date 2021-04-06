package io.github.com.pages.utils;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.utils.TextAreaAutoSize;

public class TextAreaAutoSizeFrame extends Section {
    @UI("textarea[rows]")
    public TextAreaAutoSize textAreaAutoSize;
}
