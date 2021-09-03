package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIProgressBar;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.light.material.elements.inputs.MaterialButton;
import com.epam.jdi.light.ui.html.elements.common.Text;

public class ProgressPage extends WebPage {
    @JDIProgressBar(root ="#circularIndeterminateProgress")
    public static ProgressBar circularIndeterminate;

    @JDIProgressBar(root ="(//div[@aria-valuenow='25'])[1]")
    public static ProgressBar circularDeterminateWithValue25;

    @JDIProgressBar(root ="(//div[@aria-valuenow='50'])[1]")
    public static ProgressBar circularDeterminateWithValue50;

    @JDIProgressBar(root ="(//div[@aria-valuenow='75'])[1]")
    public static ProgressBar circularDeterminateWithValue75;

    @JDIProgressBar(root ="(//div[@aria-valuenow='100'])[1]")
    public static ProgressBar circularDeterminateWithValue100;

    @JDIProgressBar(root ="(//div[@aria-valuenow='100']/following-sibling::div)[1]")
    public static ProgressBar circularDeterminateProgress;

    @JDIProgressBar(root ="(//h2[text()='Customized progress']/following::div)[3]")
    public static ProgressBar circularDeterminateProgressWithLabel;

    @JDIProgressBar(root ="(//h2[text()='Customized progress']/following::div[@role='progressbar'])[1]")
    public static ProgressBar circularIndeterminateCustomized;

    @JDIProgressBar(root ="(//h2[text()='Customized progress']/following::div[@role='progressbar'])[3]")
    public static ProgressBar circularDeterminateCustomized;

    @JDIProgressBar(root ="(//h2[text()='Linear indeterminate']/following::div)[2]")
    public static ProgressBar linearIndeterminate;

    @JDIProgressBar(root ="(//h2[text()='Linear determinate']/following::div)[2]")
    public static ProgressBar linearDeterminate;

    @JDIProgressBar(root ="(//h2[text()='Linear buffer']/following::div)[2]")
    public static ProgressBar linearBuffer;

    @JDIProgressBar(root ="(//h2[text()='Linear with label']/following::div[@role='progressbar'])[1]")
    public static ProgressBar linearWithLabel;

    @UI("//button[@aria-label='save']")
    public static MaterialButton interactiveIntegrationCircularButton;

    @JDIProgressBar(root = "//button[@aria-label='save']/following-sibling::div")
    public static ProgressBar interactiveIntegrationCircularIndeterminate;

    @UI("//*[text()='Loading']/..")
    public static MaterialButton startLoadingButton;

    @JDIProgressBar(root = "//*[text()='Stop loading']/../../div/div")
    public static ProgressBar loadingCircularIndeterminate;

    @UI("//*[text()='Simulate a load']")
    public static MaterialButton simulateLoadButton;

    @JDIProgressBar(root = "//*[text()='Reset']/../preceding-sibling::div[1]/div")
    public static ProgressBar simulateLoadCircularIndeterminate;

    @UI("//p[text()='Success!']")
    public static Text successMessage;
}