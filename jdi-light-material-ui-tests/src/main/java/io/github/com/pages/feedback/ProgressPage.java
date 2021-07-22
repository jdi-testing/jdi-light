package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIProgressBar;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ProgressPage extends WebPage {
    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[1]")
    public static ProgressBar circularIndeterminate;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[1]")
    public static ProgressBar circularDeterminate1;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[2]")
    public static ProgressBar circularDeterminate2;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[3]")
    public static ProgressBar circularDeterminate3;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[4]")
    public static ProgressBar circularDeterminate4;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[5]")
    public static ProgressBar circularDeterminate5;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[6]")
    public static ProgressBar circularDeterminate6;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[7]")
    public static ProgressBar circularDeterminate7;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[8]")
    public static ProgressBar circularDeterminate8;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[9]")
    public static ProgressBar circularDeterminate9;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiLinearProgress-root')])[1]")
    public static ProgressBar linearIndeterminate;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiLinearProgress-root')])[2]")
    public static ProgressBar linearDeterminate;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiLinearProgress-root')])[3]")
    public static ProgressBar linearBuffer;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiLinearProgress-root')])[4]")
    public static ProgressBar linearWithLabel;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiLinearProgress-root')])[5]")
    public static ProgressBar delayingAppearance;

    @UI("//*[contains(@class, 'MuiFab-primary')]")
    public static Button interactiveIntegrationCircularButton;

    @JDIProgressBar(root = "//*[contains(@class, 'MuiFab-primary')]/following-sibling::div")
    public static ProgressBar interactiveIntegrationCircularIndeterminate;

    @UI("//*[text()='Loading']/..")
    public static Button startLoadingButton;

    @JDIProgressBar(root = "//*[text()='Stop loading']/../../div/div")
    public static ProgressBar loadingCircularIndeterminate;

    @UI("//*[text()='Simulate a load']")
    public static Button simulateLoadButton;

    @JDIProgressBar(root = "//*[text()='Reset']/../../div[2]/div")
    public static ProgressBar simulateLoadCircularIndeterminate;

    @UI("//p[text()='Success!']")
    public static Text successMessage;
}
