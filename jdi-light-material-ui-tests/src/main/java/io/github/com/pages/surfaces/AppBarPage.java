package io.github.com.pages.surfaces;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class AppBarPage extends WebPage {
    @UI("//span[text()='App Bar']")
    public static UIElement appBar;

    @UI("//*[text()='App Bar with menu']/preceding::button[@aria-label='menu']")
    public static UIElement simpleMenu;

    @UI("//*[text()='Prominent App Bar']/preceding::button[@aria-label='menu'][1]")
    public static UIElement appBarMenu;

    @UI("//*[text()='Prominent App Bar']/following::button[@aria-label='open drawer']")
    public static UIElement prominentMenu;

    @UI("//*[text()='Simple App bar']/following::h6[1]")
    public static Text simpleText;

    @UI("//*[text()='App Bar with menu']/following::h6")
    public static Text appBarText;

    @UI("//*[text()='Prominent App Bar']/following::h5")
    public static Text prominentText;

    @UI("//*[text()='Simple App bar']/following::button[2]")
    public static Button simpleButton;

    @UI("//*[text()='Simple App bar']/following::button[4]")
    public static UIElement appBarIcon;

    @UI("//*[text()='Simple App bar']/following::button[6]")
    public static UIElement prominentSearch;

    @UI("//*[text()='Simple App bar']/following::button[7]")
    public static UIElement prominentSecondMenu;

    @UI("[role='menuitem']")
    public static List<Button> appBarIconOptions;

    @UI("//*[@class='MuiSwitch-root']")
    public static Button logoutSwitchButton;

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

    @UI("//div/button[3]")
    public static Button bottomSearchButton;

    @UI(".MuiIconButton-edgeEnd")
    public static Button bottomSecondMenuButton;
}
