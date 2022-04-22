package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;

public class SnackbarPage extends WebPage {

    @UI("//span[text()='Open simple snackbar']")
    public static Button simpleSnackbarButton;

    @UI("[direction='up']")
    public static Snackbar simpleSnackbar;

    @UI("//span[text()='Open success snackbar']")
    public static Button successSnackbarButton;

    @UI("//div[@direction]/div[@class='MuiAlert-message']/parent::div")
    public static Snackbar successSnackbar;

    @UI(".MuiAlert-root")
    public static List<Alert> customizedSnackbar;

    @UI("//*[contains(@class, 'MuiButton-root')]//span[contains(text(), '-')]")
    public static List<Button> positionedSnackbarButtons;

    @UI("//div[contains(@class,'MuiSnackbar-root')]")
    public static Snackbar positionedSnackbar;

    @UI("//div[@class='MuiSnackbarContent-message']")
    public static List<Snackbar> messageLength;

    @UI("//span[contains(text(), 'Show message')]")
    public static List<Button> showMessageButtons;

    @UI(".MuiSnackbar-root div[role='alert']")
    public static Snackbar consecutiveSnackbar;

    @UI("//h2[text() = 'Consecutive Snackbars']/following::div[1]//div[@role='alert']")
    public static List<Snackbar> consecutiveSnackbarList;

    @UI("//button[contains(@class, 'MuiButton-root')]//span[contains(text(), 'Transition')]")
    public static List<Button> transitionButtons;

    @UI("//h2[text() = 'Change Transition']/following::div[1]//div[@role='alert']")
    public static Snackbar changeTransitionSnackbar;

    @UI("//h2[text()='Control Slide direction']/following::div[1]/button")
    public static List<Button> directionButtons;

    @UI("//div[contains(@class, 'MuiSnackbar-root')]//div[@class='MuiSnackbarContent-message']")
    public static Snackbar controlSlideDirectionSnackbar;

    @UI("//h2[text()='Complementary projects']/following::button")
    public static List<Button> showSnackbarButtons;

    @UI("//div[@id='notistack-snackbar']")
    public static Snackbar complementaryProjectsSnackbar;

    @UI("//div[@id='notistack-snackbar']")
    public static List<Snackbar> complementaryProjectsSnackbarList;

}
