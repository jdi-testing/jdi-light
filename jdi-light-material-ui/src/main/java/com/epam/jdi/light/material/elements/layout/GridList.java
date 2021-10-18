package com.epam.jdi.light.material.elements.layout;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.material.asserts.layout.GridListAssert;

public class GridList extends UIListBase<GridListAssert> {

    @Override
    public GridListAssert is() {
        return new GridListAssert().set(this);
    }

    @JDIAction("Is {name} have image")
    public boolean hasImage(int index) {
        return get(index).find("img").isExist();
    }

    @JDIAction("Get {name} image alternative name")
    public String getAltImgName(int numEl) {
        return get(numEl).find("img").attr("alt");
    }

    @JDIAction("Get {name} title")
    public String getTitle(int numEl) {
        return get(numEl).find("div[class*='title']").text().replaceAll("[\\t\\n\\r]+", " ");
    }
}
