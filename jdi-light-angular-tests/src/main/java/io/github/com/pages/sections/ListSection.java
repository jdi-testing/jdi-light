package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class ListSection {

    @UI("#basic-list mat-list-item")
    public JList<Label> basicList;

    @UI("#list-with-sections mat-list-item")
    public JList<Label> listWithSection;

}
