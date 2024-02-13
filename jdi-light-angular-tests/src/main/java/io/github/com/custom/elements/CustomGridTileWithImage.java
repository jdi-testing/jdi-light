package io.github.com.custom.elements;

import com.epam.jdi.light.angular.elements.complex.gridlist.GridTile;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class CustomGridTileWithImage extends GridTile {

    @UI("#dynamic-grid-item-avatar")
    public UIElement image;
}
