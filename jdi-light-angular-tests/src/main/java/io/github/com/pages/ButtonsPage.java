package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

public class ButtonsPage extends NewAngularPage {

    @UI("#basic-basic-button")
    public static Button basicBasicButton;
    @UI("#basic-disabled-button")
    public static Button basicDisabledButton;
    @UI("#raised-primary-button")
    public static Button raisedPrimaryButton;
    @UI("#stroked-accent-button")
    public static Button strokedAccentButton;
    @UI("#flat-warn-button")
    public static Button flatWarnButton;
    @UI("#icon-primary-button")
    public static Button iconPrimaryButton;
    @UI("#fub-icon-link-button")
    public static Button fabLinkButton;
    @UI("#minifab-icon-button")
    public static Button miniFabHeartButton;
    @UI("#matfab-extended-accent-button")
    public static Button extendedFabAccentButton;
    @UI("#default-color-theme-palette")
    public static Button defaultColorButton;
}
