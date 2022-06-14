package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.material.asserts.layout.GridListAssert;
import com.epam.jdi.light.ui.html.elements.common.Image;

/**
 * Represents Grid List MUI component on GUI.
 * <p>
 * Grid lists display a collection of images in an organized grid.
 * </p>
 * @see <a href="https://v3.mui.com/demos/grid-list/#grid-list">Grid List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class GridList extends UIListBase<GridListAssert> {

    /**
     * Checks if item by index has image or not
     *
     * @param index item to check
     * @return {@code true} if item has image, otherwise {@code false}
     */
    @JDIAction("Check that '{name}' item '{0}' has image")
    public boolean hasImage(int index) {
        return image(index).isExist();
    }

    /**
     * Get image text by index
     *
     * @param index item to get image
     * @return alternate image as {@link Image}
     */
    @JDIAction("Get '{name}' item '{0}' image alternative name")
    public Image image(int index) {
        return new Image().setCore(Image.class, get(index).find("img"));
    }

    /**
     * Get item title by index
     *
     * @param index item to get title
     * @return item title as {@link String}
     */
    @JDIAction("Get '{name}' item '{0}' title")
    public String title(int index) {
        return get(index).find("div[class*='title']").text().replaceAll("[\\t\\n\\r]+", " ");
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }
}
