package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.feedback.Alert;
import com.epam.jdi.light.material.elements.feedback.Snackbar;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;

public class SnackbarPage extends WebPage {

    @UI("button['Open simple snackbar']")
    public static Button simpleSnackbarButton;

    @UI("//h2[text() = 'Simple snackbar']/following::div[1]/div[contains(@class, 'MuiSnackbar-root')]")
    public static Snackbar simpleSnackbar;

    @UI("button['Open success snackbar']")
    public static Button successSnackbarButton;

    @UI("//h2[text() = 'Customized snackbars']/following::div[1]/div[contains(@class, 'MuiSnackbar-root')]")
    public static Snackbar successSnackbar;

    @UI(".MuiAlert-root")
    public static List<Alert> customizedAlerts;

    @UI("button[*'-']")
    public static List<Button> positionedSnackbarButtons;

    @UI("//h2[text() = 'Positioned snackbars']/following::div[1]/div[contains(@class, 'MuiSnackbar-root')]")
    public static Snackbar positionedSnackbar;

    @UI("//h2[text() = 'Message Length']/following::div[1]/div[contains(@class, 'MuiSnackbarContent-root')]")
    public static List<Snackbar> messageLengthSnackbars;

    @UI("button[*'Show message']")
    public static List<Button> showMessageButtons;

    @UI(".MuiSnackbar-root div[role='alert']")
    public static Snackbar consecutiveSnackbar;

    @UI("button[*'Transition']")
    public static List<Button> transitionButtons;

    @UI("//h2[text() = 'Change Transition']/following::div[1]//div[@role='alert']")
    public static Snackbar changeTransitionSnackbar;

    @UI("//h2[text()='Control Slide direction']/following::div[1]/button")
    public static List<Button> directionButtons;

    @UI("//h2[text() = 'Control Slide direction']/following::div[1]//div[@role='alert']")
    public static Snackbar controlSlideDirectionSnackbar;

    @UI("button[*'Show s']")
    public static List<Button> showSnackbarButtons;

    @UI(".MuiCollapse-wrapperInner [role='alert']")
    public static List<Snackbar> complementaryProjectsSnackbarList;
}
