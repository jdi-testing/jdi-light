package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.material.asserts.layout.GridListAssert;

/**
 *
 * @see <a href="https://material-ui.com/components/hidden/">Hidden MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */


public class GridList extends UIListBase<GridListAssert> {

    @JDIAction("Check that '{name}' have image")
    public boolean hasImage(int index) {
        return get(index).core().find("img").isExist();
    }

    @JDIAction("Get '{name}' image alternative name")
    public String getAltImgName(int numEl) {
        return get(numEl).core().find("img").attr("alt");
    }

    @JDIAction("Get '{name}' title")
    public String getTitle(int numEl) {
        return get(numEl).core().find("div[class*='title']").text().replaceAll("[\\t\\n\\r]+", " ");
    }

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }
}
