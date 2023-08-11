package io.github.com.pages;

import com.epam.jdi.light.angular.elements.common.Button;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;

import java.util.List;

public class ButtonsPage extends NewAngularPage {

    @UI("[mat-button]:not([defaultcolor])")
    public static List<Button> basicButtons;
    @UI("#basic-buttons-label")
    public static Label basicbuttonLabel;

    @UI("[extended]")
    public static List<Button> extendedFabButtons;
    @UI("#matfab-extended-buttons-label")
    public static Label extendedFabLabel;

    @UI("[mat-fab]:not([extended])")
    public static List<Button> fabButtons;
    @UI("#fab-buttons-label")
    public static Label fabButtonLabel;

    @UI("[mat-flat-button]")
    public static List<Button> flatButtons;
    @UI("#flat-buttons-label")
    public static Label flatButtonLabel;

    @UI("[mat-icon-button]")
    public static List<Button> iconButtons;
    @UI("#icon-buttons-label")
    public static Label iconButtonLabel;

    @UI("[mat-mini-fab]")
    public static List<Button> miniFabButtons;
    @UI("#minifab-buttons-label")
    public static Label miniFabButtonLabel;

    @UI("[mat-raised-button]")
    public static List<Button> raisedButtons;
    @UI("#raised-buttons-label")
    public static Label raisedButtonLabel;

    @UI("[mat-stroked-button]")
    public static List<Button> strokedButtons;
    @UI("#stroked-buttons-label")
    public static Label strokedButtonLabel;

    @UI("#default-color-theme-palette")
    public static Button defaultColorButton;
}
