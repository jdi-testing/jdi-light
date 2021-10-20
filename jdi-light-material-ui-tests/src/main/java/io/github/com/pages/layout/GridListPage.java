package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.GridList;

public class GridListPage extends WebPage {

    @UI(".MuiGridList-root.jss3")
    public static GridList imageGridList;

    @UI(".MuiGridList-root.jss5")
    public static GridList singleLineGridList;

    @UI(".MuiGridList-root.jss9")
    public static GridList titleBarGridList;
}
