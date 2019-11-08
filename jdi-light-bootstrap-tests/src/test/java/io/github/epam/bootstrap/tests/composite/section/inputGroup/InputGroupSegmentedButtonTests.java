package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static com.epam.jdi.light.elements.common.WindowsManager.closeWindow;
import static com.epam.jdi.light.elements.common.WindowsManager.switchToNewWindow;
import static com.epam.jdi.light.elements.composite.WebPage.getTitle;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.segmentedButton;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;
import static org.testng.Assert.assertEquals;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class InputGroupSegmentedButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    private String testText = "Test text";
    private String action = "Action";
    private String anotherAction = "Another action";
    private String somethingElseHere = "Something else here";
    private String separatedLink = "Separated link";
    private String pageTitle = "Home Page";
    private String actionButtonClickAlert = "Action Button Alert";

    @Test
    public void dropdownMenuIsValidationTests() {
        segmentedButton.dropdownMenu.is().displayed();
        segmentedButton.dropdownMenu.is().enabled();
    }

    @Test
    public void textInputAreaTests() {
        segmentedButton.textInputArea.sendKeys(testText);
        segmentedButton.textInputArea.is().text(testText);
        segmentedButton.textInputArea.sendKeys(testText);
        segmentedButton.textInputArea.is().text(testText + testText);
        segmentedButton.textInputArea.clear();
        segmentedButton.textInputArea.is().text("");
    }

    @Test
    public void dropdownMenuTests() {
        segmentedButton.dropdownMenu.expand();
        segmentedButton.dropdownMenu.is().expanded();
        segmentedButton.dropdownMenu.is().size(4);
        segmentedButton.dropdownMenu.list().get(1).is().text(action);
        segmentedButton.dropdownMenu.list().get(2).is().text(anotherAction);
        segmentedButton.dropdownMenu.list().get(3).is().text(somethingElseHere);
        segmentedButton.dropdownMenu.list().get(4).is().text(separatedLink);
        segmentedButton.dropdownMenu.select(action);
        newWindowTitleCheck();
        segmentedButton.dropdownMenu.select(anotherAction);
        newWindowTitleCheck();
        segmentedButton.dropdownMenu.select(somethingElseHere);
        newWindowTitleCheck();
        segmentedButton.dropdownMenu.select(separatedLink);
        newWindowTitleCheck();
    }

    @Test
    public void actionButtonTests() {
        segmentedButton.actionButton.is().displayed();
        segmentedButton.actionButton.is().enabled();
        segmentedButton.actionButton.is().text(action);
        segmentedButton.actionButton.click();
        validateAlert(is(actionButtonClickAlert));
    }

    @Test
    public void textInputAreaIsValidationTests() {
        segmentedButton.textInputArea.is()
                .displayed()
                .enabled()
                .core()
                .hasClass("form-control")
                .css("font-size", "16px")
                .attr("type", "text")
                .attr("aria-label", "Text input with segmented dropdown button")
                .tag("input");
    }

    public void newWindowTitleCheck() {
        switchToNewWindow();
        assertEquals(getTitle(), pageTitle);
        closeWindow();
    }
}
