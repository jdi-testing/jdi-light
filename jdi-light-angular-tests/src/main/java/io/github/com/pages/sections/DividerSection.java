package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.common.Divider;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class DividerSection extends Section {

    @UI("#divider-list mat-divider")
    public JList<Divider> dividers;
}
