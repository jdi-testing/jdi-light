package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIProgressBar;
import com.epam.jdi.light.material.elements.feedback.progress.CircularProgress;
import com.epam.jdi.light.material.elements.feedback.progress.LinearProgress;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ProgressPage extends WebPage {
    @JDIProgressBar(root = "#circularIndeterminateProgress")
    public static CircularProgress circularIndeterminate;

    @JDIProgressBar(root = "(//div[@aria-valuenow='25'])[1]")
    public static CircularProgress circularDeterminateWithValue25;

    @JDIProgressBar(root = "(//div[@aria-valuenow='50'])[1]")
    public static CircularProgress circularDeterminateWithValue50;

    @JDIProgressBar(root = "(//div[@aria-valuenow='75'])[1]")
    public static CircularProgress circularDeterminateWithValue75;

    @JDIProgressBar(root = "(//div[@aria-valuenow='100'])[1]")
    public static CircularProgress circularDeterminateWithValue100;

    @JDIProgressBar(root = "(//div[@aria-valuenow='100']/following-sibling::div)[1]")
    public static CircularProgress circularDeterminateProgress;

    @JDIProgressBar(root = "(//h2[text()='Circular determinate']/following::div[@role='progressbar'])[6]")
    public static CircularProgress circularDeterminateIndeterminateProgress;

    @UI("//button[@aria-label='save']")
    public static MaterialButton interactiveIntegrationCircularButton;

    @JDIProgressBar(root = "//button[@aria-label='save']/following-sibling::div")
    public static CircularProgress interactiveIntegrationCircularIndeterminate;

    @JDIProgressBar(root = "(//h2[text()='Circular with label']/following::div[@role='progressbar'])[1]",
            label = "div.MuiTypography-caption")
    public static CircularProgress circularDeterminateProgressWithLabel;

    @JDIProgressBar(root = "(//h2[text()='Linear indeterminate']/following::div)[2]",
            bar1 = ".MuiLinearProgress-bar1Indeterminate",
            bar2 = ".MuiLinearProgress-bar2Indeterminate")
    public static LinearProgress linearIndeterminate;

    @JDIProgressBar(root = "(//h2[text()='Linear determinate']/following::div)[2]")
    public static LinearProgress linearDeterminate;

    @JDIProgressBar(root = "(//h2[text()='Linear buffer']/following::div)[2]")
    public static LinearProgress linearBuffer;

    @JDIProgressBar(root = "//h2[text()='Linear with label']/following::*[contains(@class, 'MuiLinearProgress-root')]",
            label = "p.MuiTypography-root")
    public static LinearProgress linearWithLabel;

    @JDIProgressBar(root = "(//h2[text()='Customized progress']/following::div[@role='progressbar'])[2]")
    public static CircularProgress circularIndeterminateCustomized;

    @JDIProgressBar(root = "(//h2[text()='Customized progress']/following::div[@role='progressbar'])[3]")
    public static LinearProgress linearDeterminateCustomized;

    @UI("//*[text()='Loading']/..")
    public static MaterialButton startLoadingButton;

    @JDIProgressBar(root = "//*[text()='Stop loading']/../../div/div")
    public static CircularProgress loadingCircularIndeterminate;

    @UI("//*[text()='Simulate a load']")
    public static MaterialButton simulateLoadButton;

    @JDIProgressBar(root = "//*[text()='Reset']/../preceding-sibling::div[1]/div")
    public static CircularProgress simulateLoadCircularIndeterminate;

    @UI("//p[text()='Success!']")
    public static Text successMessage;
}
