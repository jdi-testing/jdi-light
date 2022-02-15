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

    @JProgress(root = "(//div[@aria-valuenow='25'])[1]")
    public static CircularProgress circularProgressDeterminateWithValue25;

    @JProgress(root = "(//div[@aria-valuenow='50'])[1]")
    public static CircularProgress circularProgressDeterminateWithValue50;

    @JProgress(root = "(//div[@aria-valuenow='75'])[1]")
    public static CircularProgress circularProgressDeterminateWithValue75;

    @JProgress(root = "(//div[@aria-valuenow='100'])[1]")
    public static CircularProgress circularProgressDeterminateWithValue100;

    @JProgress(root = "(//div[@aria-valuenow='100']/following-sibling::div)[1]")
    public static CircularProgress circularProgressDeterminate;

    @JProgress(root = "(//h2[text()='Circular determinate']/following::div[@role='progressbar'])[6]")
    public static CircularProgress circularProgressDeterminateIndeterminate;

    @UI("//button[@aria-label='save']")
    public static Button saveButton;

    @JProgress(root = "//button[@aria-label='save']/following-sibling::div")
    public static CircularProgress saveCircularProgress;

    @UI(".MuiButton-containedPrimary")
    public static Button acceptTermsButton;

    @JProgress(root = "//button[contains(@class, 'MuiButton-containedPrimary')]/following-sibling::div")
    public static CircularProgress acceptTermsCircularProgress;

    @JProgress(root = "(//h2[text()='Circular with label']/following::div[@role='progressbar'])[1]",
            label = "div.MuiTypography-caption")
    public static CircularProgress circularProgressWithLabel;

    @JProgress(root = "(//h2[text()='Linear indeterminate']/following::div)[2]",
            bar1 = ".MuiLinearProgress-bar1Indeterminate",
            bar2 = ".MuiLinearProgress-bar2Indeterminate")
    public static LinearProgress linearProgressIndeterminate;

    @JProgress(root = "(//h2[text()='Linear determinate']/following::div)[2]")
    public static LinearProgress linearProgressDeterminate;

    @JProgress(root = "(//h2[text()='Linear buffer']/following::div)[2]")
    public static LinearProgress linearProgressBuffer;

    @JProgress(root = "//h2[text()='Linear with label']/following::*[contains(@class, 'MuiLinearProgress-root')]",
            label = "p.MuiTypography-root")
    public static LinearProgress linearProgressWithLabel;

    @JProgress(root = "(//h2[text()='Customized progress']/following::div[@role='progressbar'])[2]")
    public static CircularProgress customizedCircularProgress;

    @JProgress(root = "(//h2[text()='Customized progress']/following::div[@role='progressbar'])[3]")
    public static LinearProgress customizedLinearProgress;

    @UI("//*[text()='Loading']/..")
    public static Button startLoadingButton;

    @JProgress(root = "//*[text()='Stop loading']/../../div/div")
    public static CircularProgress loadingCircularProgress;

    @UI("//*[text()='Simulate a load']")
    public static Button simulateLoadButton;

    @JProgress(root = "//*[text()='Reset']/../preceding-sibling::div[1]/div")
    public static CircularProgress simulateLoadCircularProgress;

    @UI("//p[text()='Success!']")
    public static Text successMessage;
}
