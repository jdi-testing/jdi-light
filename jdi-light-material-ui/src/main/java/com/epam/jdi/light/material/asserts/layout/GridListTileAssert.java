package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.material.elements.layout.GridListTile;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class GridListTileAssert extends UIAssert<GridListTileAssert, GridListTile> {

    public GridListTileAssert alternativeImageText(String alt) {
        jdiAssert(element().image().alt(), Matchers.is(alt));
        return this;
    }

    public GridListTileAssert hasBar() {
        jdiAssert(element().tileBar().isExist(), Matchers.is(true), "Tile has no bar");
        return this;
    }

    public GridListTileAssert hasNoBar() {
        jdiAssert(element().tileBar().isNotExist(), Matchers.is(true), "Tile has bar");
        return this;
    }

    public GridListTileAssert isSubheader() {
        jdiAssert(element().subheader().isExist(), Matchers.is(true), "Tile has no subheader");
        return this;
    }

    public GridListTileAssert subheader(String expSubheader) {
        jdiAssert(element().subheader().getText(), Matchers.is(expSubheader));
        return this;
    }
}
