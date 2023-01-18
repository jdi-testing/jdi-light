package com.epam.jdi.light.material.asserts.layout;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.material.elements.layout.GridListTileBar;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class GridListTileBarAssert extends UIAssert<GridListTileBarAssert, GridListTileBar> {
    public GridListTileBarAssert hasPosition(Position position) {
        jdiAssert(element().position(), Matchers.is(position));
        return this;
    }

    public GridListTileBarAssert title(String expTitle) {
        jdiAssert(element().title().getText(), Matchers.is(expTitle));
        return this;
    }

    public GridListTileBarAssert subtitle(String expTitle) {
        jdiAssert(element().subtitle().getText(), Matchers.is(expTitle));
        return this;
    }

    public GridListTileBarAssert hasAction() {
        jdiAssert(element().actionIcon().isExist(), Matchers.is(true), "Action doesn't exist in bar");
        return this;
    }

    public GridListTileBarAssert hasNoAction() {
        jdiAssert(element().actionIcon().isNotExist(), Matchers.is(true), "Action exists in bar");
        return this;
    }
}
