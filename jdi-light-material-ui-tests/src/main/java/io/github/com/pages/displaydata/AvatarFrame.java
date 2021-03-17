package io.github.com.pages.displaydata;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.displaydata.Avatar;

public class AvatarFrame extends Section {
    @UI(".MuiAvatar-circle")
    public Avatar noImage;

    @UI(".MuiAvatar-circle")
    public Avatar circle;

    @UI(".MuiAvatar-square")
    public Avatar square;

    @UI(".MuiAvatar-rounded")
    public Avatar rounded;

    @UI(".MuiAvatar-circle")
    public Avatar fallbackAlt;

    @UI(".MuiAvatar-circle")
    public Avatar letter;

    @UI(".MuiAvatar-circle")
    public Avatar icon;
}
