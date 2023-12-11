package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class GridListPage extends NewAngularPage {

    @UI("#dynamic-grid-list")
    public static GridList dynamicGridList;
}
