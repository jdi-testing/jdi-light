package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Avatar;

public class AvatarFrame extends Section {
    @UI("//*[name()='svg']")
    public Avatar noImage;

    @UI(".MuiAvatar-img")
    public Avatar circle;

    @UI(".MuiAvatar-img")
    public Avatar square;

    @UI(".MuiAvatar-img")
    public Avatar rounded;

    @UI(".MuiAvatar-root")
    public Avatar fallbackAlt;

    @UI(".MuiAvatar-root")
    public Avatar letter;

    @UI("//*[name()='svg']")
    public Avatar icon;
}
