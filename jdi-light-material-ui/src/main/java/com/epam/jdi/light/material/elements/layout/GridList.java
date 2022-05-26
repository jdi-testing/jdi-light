package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.material.asserts.layout.GridListAssert;
import com.epam.jdi.light.material.interfaces.base.HasImage;

/**
 * Represents Grid List MUI component on GUI.
 * <p>
 * Grid lists display a collection of images in an organized grid.
 *
 * @see <a href="https://v3.mui.com/demos/grid-list/#grid-list">Grid List MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class GridList extends UIListBase<GridListAssert> implements HasImage {

    @JDIAction("Check that '{name}' have image")
    public boolean hasImage(int index) {
        return get(index).core().find("img").isExist();
    }

    @JDIAction("Get '{name}' image alternative name")
    public String altImgName(int numEl) {
        return get(numEl).core().find("img").attr("alt");
    }

    @JDIAction("Get '{name}' title")
    public String title(int numEl) {
        return get(numEl).core().find("div[class*='title']").text().replaceAll("[\\t\\n\\r]+", " ");
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }
}
