package io.github.com.pages.feedback;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDIProgressBar;
import com.epam.jdi.light.material.elements.feedback.ProgressBar;
import com.epam.jdi.light.material.elements.inputs.Button;
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

    @JDIProgressBar(root ="(//h2[text()='Circular determinate']/following::div/div)[5]")
    public static ProgressBar circularDeterminateProgress;

    @JDIProgressBar(root ="//h2[text()='Circular with label']/following::div[2]")
    public static ProgressBar circularDeterminateProgressWithLabel;

    //ToDo удалить c web-страницы
    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-indeterminate')])[2]")
    public static ProgressBar circularIndeterminate2;

    //ToDo разбить на 2 элемента
    @JDIProgressBar(root ="(//*[contains(@class, 'MuiCircularProgress-indeterminate')])[3]")
    public static ProgressBar circularIndeterminateCustomizedProgress;

    @JDIProgressBar(root ="//h2[text()='Linear indeterminate']/following::div[2]")
    public static ProgressBar linearIndeterminate;

    @JDIProgressBar(root ="//h2[text()='Linear determinate']/following::div[2]")
    public static ProgressBar linearDeterminate;

    @JDIProgressBar(root ="//h2[text()='Linear buffer']/following::div[2]")
    public static ProgressBar linearBuffer;

    @JDIProgressBar(root ="//h2[text()='Linear with label']/following::div[4]")
    public static ProgressBar linearWithLabel;

    //ToDo локатор указывает на Customized - уже есть, удалить
    @JDIProgressBar(root ="(//*[contains(@class, 'MuiLinearProgress-root')])[5]")
    public static ProgressBar delayingAppearance;

    @UI("//*[contains(@class, 'MuiFab-primary')]")
    public static Button interactiveIntegrationCircularButton;

    //ToDo элемент локатора быстро исчезает
    @JDIProgressBar(root = "//*[contains(@class, 'MuiFab-primary')]/following-sibling::div")
    public static ProgressBar interactiveIntegrationCircularIndeterminate;

    @UI("//*[text()='Loading']/..")
    public static Button startLoadingButton;

    @JDIProgressBar(root = "//h2[text()='Delaying appearance']/following::div[2]")
    public static ProgressBar loadingCircularIndeterminate;

    @UI("//*[text()='Simulate a load']")
    public static Button simulateLoadButton;

    //ToDo элемент локатора быстро исчезает
    @JDIProgressBar(root = "//*[text()='Reset']/../../div[2]/div")
    public static ProgressBar simulateLoadCircularIndeterminate;

    @UI("//p[text()='Success!']")
    public static Text successMessage;
}
