package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Grid;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import java.util.List;

public class GridPage extends WebPage {

    @UI(".MuiContainer-root")
    public static Grid rootGrid;

    @UI("#basicGrid")
    public static Grid basicGrid;

    @UI("#complexGrid")
    public static Grid complexGrid;
}
