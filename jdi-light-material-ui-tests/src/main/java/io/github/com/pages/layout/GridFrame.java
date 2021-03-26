package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Grid;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class GridFrame extends Section {

    @UI("//div[@id='root']/div[contains(@class,'MuiGrid-root')]")
    public Grid rootGrid;

    @UI(".MuiButton-root[1]")
    public Button firstButton;

    @UI(".MuiButton-root[2]")
    public Button secondButton;
}
