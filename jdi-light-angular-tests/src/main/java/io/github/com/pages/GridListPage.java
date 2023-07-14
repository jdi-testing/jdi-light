package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.GridList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class GridListPage extends NewAngularPage {

    @UI("#basic-grid-list")
    public static GridList basicGridList;

    @UI("#dynamic-grid-list")
    public static GridList dynamicGridList;
}
