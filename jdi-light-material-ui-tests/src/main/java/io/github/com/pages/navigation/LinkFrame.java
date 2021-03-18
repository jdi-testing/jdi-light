package io.github.com.pages.navigation;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.navigation.Link;

public class LinkFrame extends Section {
    @UI("//a[text()='Link']")
    public Link link;
}
