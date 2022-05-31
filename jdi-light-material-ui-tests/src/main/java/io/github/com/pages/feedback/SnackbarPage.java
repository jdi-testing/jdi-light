package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;

public class SnackbarPage extends WebPage {

    @UI("//span[text()='Open simple snackbar']/parent::button")
    public static Button simpleSnackbarButton;

    @UI("[direction='up']")
    public static Snackbar simpleSnackbar;

    @UI("//span[text()='Open success snackbar']/parent::button")
    public static Button successSnackbarButton;

    @UI("//div[@direction]/..")
    public static Snackbar successSnackbar;

    @UI("//div[@class='MuiAlert-message']/parent::div")
    public static List<Snackbar> customizedSnackbar;

    @UI("//h2[text()='Message Length']/preceding::button/span[@class='MuiButton-label' and not(text()='Open simple snackbar') and not(text()='Open success snackbar')]")
    public static List<Button> positionedSnackbarButtons;

    @UI("//div[contains(@class,'MuiSnackbar-root')]")
    public static Snackbar positionedSnackbar;

    @UI("//div[@class='MuiSnackbarContent-message']/parent::div")
    public static List<Snackbar> messageLength;

    @UI("//h2[text()='Consecutive Snackbars']/following::div[1]/button")
    public static List<Button> showMessageButtons;

    @UI("//h2[text() = 'Consecutive Snackbars']/following::div[1]//div[@role='alert']")
    public static Snackbar consecutiveSnackbar;

    @UI("//h2[text() = 'Consecutive Snackbars']/following::div[1]//div[@role='alert']")
    public static List<Snackbar> consecutiveSnackbarList;

    @UI("//h2[text()='Change Transition']/following::div[1]/button")
    public static List<Button> transitionButtons;

    @UI("//h2[text() = 'Change Transition']/following::div[1]//div[@role='alert']")
    public static Snackbar changeTransitionSnackbar;

    @UI("//h2[text()='Control Slide direction']/following::div[1]/button")
    public static List<Button> directionButtons;

    @UI("//h2[text() = 'Control Slide direction']/following::div[1]//div[@role='alert']")
    public static Snackbar controlSlideDirectionSnackbar;

    @UI("//h2[text()='Complementary projects']/following::button")
    public static List<Button> showSnackbarButtons;

    @UI("//div[@id='notistack-snackbar']")
    public static Snackbar complementaryProjectsSnackbar;

    @UI("//div[@id='notistack-snackbar']")
    public static List<Snackbar> complementaryProjectsSnackbarList;

}
