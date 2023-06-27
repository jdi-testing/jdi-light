package io.github.com.pages.sections;

import com.epam.jdi.light.angular.elements.complex.GridList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class GridListSection extends Section {
    @UI("#basic-grid-list")
    public GridList basicGridList;

    @UI("#dynamic-grid-list")
    public GridList dynamicGridList;
}
