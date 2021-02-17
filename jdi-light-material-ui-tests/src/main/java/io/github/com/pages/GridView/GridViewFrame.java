package io.github.com.pages.GridView;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.annotations.JDIGridView;
import com.epam.jdi.light.material.elements.GridView.GridView;

public class GridViewFrame extends Section {

    @JDIGridView(
            root = "MuiGrid-root",
            button = "MuiButton-containedPrimary")
    public GridView gridView;
}
