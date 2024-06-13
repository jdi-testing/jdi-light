package io.github.com.pages;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import io.github.com.custom.elements.CustomGridTileWithImage;

public class GridListPage extends NewAngularPage {

    @UI("#dynamic-grid-list")
    public static GridList dynamicGridList;

    @UI("#dynamic-grid-list-two")
    public static CustomGridTileWithImage tileWithImage;
}
