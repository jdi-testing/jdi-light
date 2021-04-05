package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Box;

public class BoxFrame extends Section {

    @UI("//button[contains(@class,'MuiButton-contained')]")
    public Box containedBox;

    @UI("//button[contains(@class,'MuiButton-outlined')]")
    public Box outlinedBox;

    @UI("//button[contains(@class,'Mui-disabled')]")
    public Box disabledBox;

    @UI(".MuiBox-root[1]")
    public Box rootContainedBox;
}
