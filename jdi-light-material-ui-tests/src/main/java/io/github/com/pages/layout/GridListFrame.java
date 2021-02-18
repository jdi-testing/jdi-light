package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIGridList;
import com.epam.jdi.light.material.elements.layout.GridList;

public class GridListFrame extends Section {

    @JDIGridList(gridActionButton = ".MuiGridListTileBar-actionIcon .MuiIconButton-root")
    public GridList gridList;

}
