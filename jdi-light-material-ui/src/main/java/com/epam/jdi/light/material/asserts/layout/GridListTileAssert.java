package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.layout.GridListTile;
import com.epam.jdi.light.ui.html.asserts.HasImageAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class GridListTileAssert extends UIAssert<GridListTileAssert, GridListTile> implements HasImageAssert<GridListTileAssert, GridListTile> {

    @JDIAction(value = "Assert that '{name}' has alt text {0}", isAssert = true)
    public GridListTileAssert alternativeImageText(String alt) {
        jdiAssert(element().image().alt(), Matchers.is(alt));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has bar", isAssert = true)
    public GridListTileAssert hasBar() {
        jdiAssert(element().tileBar().isExist(), Matchers.is(true), "Tile has no bar");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no bar", isAssert = true)
    public GridListTileAssert hasNoBar() {
        jdiAssert(element().tileBar().isNotExist(), Matchers.is(true), "Tile has bar");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has subheader", isAssert = true)
    public GridListTileAssert subheader() {
        jdiAssert(element().subheader().isExist(), Matchers.is(true), "Tile has no subheader");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has subheader {0}", isAssert = true)
    public GridListTileAssert subheader(String expSubheader) {
        jdiAssert(element().subheader().getText(), Matchers.is(expSubheader));
        return this;
    }
}
