package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class AppBarPage extends WebPage {
    @UI("//*[text()='App Bar with menu']/preceding::button[@aria-label='menu']")
    public static UIElement simpleMenu;

    @UI("//*[text()='App Bar with menu']/following::button[@aria-label='menu']")
    public static UIElement appBarMenu;

    @UI("//*[text()='Prominent App Bar']/following::button[@aria-label='open drawer']")
    public static UIElement prominentMenu;

    @UI("//*[text()='App Bar with menu']/preceding::h6")
    public static Text simpleText;

    @UI("//*[text()='App Bar with menu']/following::h6")
    public static Text appBarText;

    @UI("//*[text()='Prominent App Bar']/following::h5")
    public static Text prominentText;

    @UI("//*[text()='Simple App bar']/following::button[contains(@class,'MuiButton-text')]")
    public static Button simpleButton;

    @UI("//*[text()='App Bar with menu']/following::button[@aria-label='account of current user']")
    public static UIElement appBarIcon;

    @UI("//*[text()='Prominent App Bar']/following::button[@aria-label='search']")
    public static UIElement prominentSearch;

    @UI("//*[text()='Simple App bar']/following::button[@aria-label='display more actions']")
    public static UIElement prominentSecondMenu;

    @UI("[role='menuitem']")
    public static List<Button> appBarIconOptions;

    @UI("//span[contains(@class,'MuiSwitch-switchBase')]")
    public static Checkbox logoutSwitch;

    @UI(".MuiTypography-h6")
    public static UIElement topAppBar;

    @UI("header")
    public static UIElement elevateAppBar;

    @UI(".MuiFab-label")
    public static Button scrollBackToTopButton;

    @UI(".MuiBox-root .MuiContainer-root .MuiBox-root")
    public static Text scrollBackText;

    @UI(".MuiFab-secondary")
    public static Button bottomButton;

    @UI(".MuiIconButton-edgeStart")
    public static Button bottomMenuButton;

    @UI("//button[@aria-label='add']/following::button")
    public static List<Button> bottomButtons;
}
