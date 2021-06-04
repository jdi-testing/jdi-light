package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIProgressBar;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.light.material.elements.inputs.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ProgressPage extends WebPage {
    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[1]")
    public static ProgressBar circularDefault;

    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-root')])[6]")
    public static ProgressBar circularIndeterminate;

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



