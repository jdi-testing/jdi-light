package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Grid;

public class GridPage extends WebPage {

    @UI("#basicGrid .MuiGrid-root")
    public static Grid basicGrid;

    @UI("#complexGrid .MuiGrid-root")
    public static Grid complexGrid;
}
