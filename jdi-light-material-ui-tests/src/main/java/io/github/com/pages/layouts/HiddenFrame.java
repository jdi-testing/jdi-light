package io.github.com.pages.layouts;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.layouts.Hidden;

public class HiddenFrame extends Section {
    @UI(".MuiTypography-root")
    public Hidden currentWidth;

    @UI("//div[contains(text(),'xsDown')]")
    public Hidden xsDown;

    @UI("//div[text()='smDown']")
    public Hidden smDown;

    @UI("//div[text()='mdDown']")
    public Hidden mdDown;

    @UI("//div[text()='lgDown']")
    public Hidden lgDown;

    @UI("//div[text()='xlDown']")
    public Hidden xlDown;

}
