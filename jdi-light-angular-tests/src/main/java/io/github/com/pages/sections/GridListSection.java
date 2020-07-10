package io.github.com.pages.sections;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class GridListSection {
    @UI("#basic-grid-list mat-grid-tile")
    public JList<Label> basicGridList;

    @UI("#dynamic-grid-list mat-grid-tile")
    public JList<Label> dynamicGridList;
}
