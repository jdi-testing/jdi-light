package io.github.com.pages.layout;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layout.Box;

public class BoxPage extends WebPage {
    @UI("//button[contains(@class,'MuiButton-contained')]")
    public Box containedBox;

    @UI("//button[contains(@class,'MuiButton-outlined')]")
    public Box outlinedBox;

    @UI("//button[contains(@class,'Mui-disabled')]")
    public Box disabledBox;

    @UI("#lastClickContent")
    public Box lastClickContent;
}
