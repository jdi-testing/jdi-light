package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JProgress;
import com.epam.jdi.light.material.elements.feedback.progress.CircularProgress;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ProgressPage extends WebPage {

    @JProgress(root = "#circularIndeterminateProgress")
    public static CircularProgress circularProgressIndeterminate;

    @JProgress(root = "div[aria-valuenow='25'][1]")
    public static CircularProgress circularProgressDeterminateWithValue25;

    @JProgress(root = "div[aria-valuenow='50'][1]")
    public static CircularProgress circularProgressDeterminateWithValue50;

    @JProgress(root = "div[aria-valuenow='75'][1]")
    public static CircularProgress circularProgressDeterminateWithValue75;

    @JProgress(root = "div[aria-valuenow='100'][1]")
    public static CircularProgress circularProgressDeterminateWithValue100;

    @JProgress(root = "div[role='progressbar'][6]")
    public static CircularProgress circularProgressDeterminate;

    @JProgress(root = "div[role='progressbar'][7]")
    public static CircularProgress circularProgressDeterminateIndeterminate;

    @UI("button[aria-label='save']")
    public static Button saveButton;

    @JProgress(root = "button[aria-label='save'] + div")
    public static CircularProgress saveCircularProgress;

    @UI(".MuiButton-containedPrimary")
    public static Button acceptTermsButton;

    @JProgress(root = "button.MuiButton-containedPrimary ~ div")
    public static CircularProgress acceptTermsCircularProgress;

    // @todo #5340 Label is not a part of CurcularProgress, should be removed
    @JProgress(root = "(//h2[text()='Circular with label']/following::div[@role='progressbar'])[1]",
        label = "div.MuiTypography-caption")
    public static CircularProgress circularProgressWithLabel;

    // @todo #5340 there is no first and second, there is a buffer and main progress,
    //  should be renamed
    @JProgress(root = "(//h2[text()='Linear indeterminate']/following::div)[2]",
        firstBar = ".MuiLinearProgress-bar1Indeterminate",
        secondBar = ".MuiLinearProgress-bar2Indeterminate")
    public static LinearProgress linearProgressIndeterminate;

    @JProgress(root = "(//h2[text()='Linear determinate']/following::div)[2]",
        firstBar = ".MuiLinearProgress-bar")
    public static LinearProgress linearProgressDeterminate;

    @JProgress(root = "(//h2[text()='Linear buffer']/following::div)[2]")
    public static LinearProgress linearProgressBuffer;

    @JProgress(root = "//h2[text()='Linear with label']/following::*[contains(@class, 'MuiLinearProgress-root')]",
        label = "p.MuiTypography-root",
        firstBar = ".MuiLinearProgress-bar")
    public static LinearProgress linearProgressWithLabel;

    @JProgress(root = "(//h2[text()='Customized progress']/following::div[@role='progressbar'])[2]")
    public static CircularProgress customizedCircularProgress;

    @JProgress(root = "(//h2[text()='Customized progress']/following::div[@role='progressbar'])[3]",
        firstBar = ".MuiLinearProgress-bar")
    public static LinearProgress customizedLinearProgress;

    @UI("['Loading'] < *")
    public static Button startLoadingButton;

    @JProgress(root = "//*[text()='Stop loading']/../../div/div")
    public static CircularProgress loadingCircularProgress;

    @UI("['Simulate a load']")
    public static Button simulateLoadButton;

    @JProgress(root = "//*[text()='Reset']/../preceding-sibling::div[1]/div")
    public static CircularProgress simulateLoadCircularProgress;

    @UI("['Success!']")
    public static Text successMessage;
}
