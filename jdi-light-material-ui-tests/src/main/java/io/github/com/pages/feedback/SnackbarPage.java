package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

import java.util.List;

public class SnackbarPage extends WebPage {

    @UI("//span[text()='Open simple snackbar']/parent::button")
    public static Button simpleSnackbarButton;

    @UI("//div[@direction='up']/div[@class='MuiSnackbarContent-message']")
    public static Text simpleSnackbarPopUp;

    @UI("//span[text()='Open success snackbar']/parent::button")
    public static Button successSnackbarButton;

    @UI("//h2[text()='Message Length']/preceding::button/span[@class='MuiButton-label' and not(text()='Open simple snackbar') and not(text()='Open success snackbar')]")
    public static List<Button> positionedSnackbarButtons;

    @UI("//h2[text()='Message Length']/following::div[contains(@class,'MuiPaper-elevation6')]/div[@class='MuiSnackbarContent-message']")
    public static List<Text> messageLengthContent;

    @UI("//div[@class='MuiSnackbarContent-action']/descendant::span[@class='MuiButton-label']")
    public static List<Button> messageLengthContentButtons;

    @UI("//h2[text()='Consecutive Snackbars']/following::button/span[@class='MuiButton-label']")
    public static List<Button> otherButtons;

    @UI("//div[@style]/div[@class='MuiSnackbarContent-message']")
    public static Text snackbarPopUpText;

    @UI("//div[@id='notistack-snackbar']")
    public static Text notisnackPopUpText;

    @UI("//div[contains(@class,'MuiSnackbar-root')]")
    public static Text positionedSnackbarPopUp;

    @UI("//div[@direction]/div[@class='MuiAlert-message']/parent::div")
    public static Text successSnackbarPopUp;

    @UI("//div[@class='MuiAlert-message']")
    public static List<Text> customizedSnackbarPopUpTitles;

    @UI("//div[@class='MuiAlert-message']/parent::div")
    public static List<Text> customizedSnackbarPopUpStyles;

    @UI("//div[@class='MuiSnackbarContent-action']//span[text()='UNDO']")
    public static Button undoSnackbarButton;

    @UI("//div[contains(@class,'MuiSnackbar-root')]//span[@class='MuiIconButton-label']/parent::button")
    public static Button closePopUpSnackbarButton;

    @UI("//div[@class='MuiAlert-action']/button")
    public static Button closePopUpSuccessButton;
}
