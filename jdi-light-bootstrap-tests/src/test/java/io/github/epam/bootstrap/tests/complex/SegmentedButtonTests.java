package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.light.elements.common.Alerts.validateAlert;
import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.segmentedButton;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.hamcrest.Matchers.is;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class SegmentedButtonTests extends TestsInit {

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    String testText = "Test text";
    String action = "Action";
    String anotherAction = "Another action";
    String somethingElseHere = "Something else here";
    String separatedLink = "Separated link";
    String buttonClickActionAlert = "Action Alert";
    String buttonClickAnotherActionAlert = "Another Action Alert";
    String buttonClickSomethingElseHereAlert = "Something Else Here Alert";
    String buttonClickSeparatedLinkAlert = "Separated Link Alert";
    String actionButtonClickAlert = "Action Button Alert";

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
        segmentedButton.dropdownMenu.list().get(0).is().text(action);
        segmentedButton.dropdownMenu.list().get(1).is().text(anotherAction);
        segmentedButton.dropdownMenu.list().get(2).is().text(somethingElseHere);
        segmentedButton.dropdownMenu.list().get(3).is().text(separatedLink);
        segmentedButton.dropdownMenu.select(action);
        validateAlert(is(buttonClickActionAlert));
        segmentedButton.dropdownMenu.select(anotherAction);
        validateAlert(is(buttonClickAnotherActionAlert));
        segmentedButton.dropdownMenu.select(somethingElseHere);
        validateAlert(is(buttonClickSomethingElseHereAlert));
        segmentedButton.dropdownMenu.select(separatedLink);
        validateAlert(is(buttonClickSeparatedLinkAlert));
    }

    @Test
    public void dropdownButtonTests() {
        segmentedButton.actionButton.is().displayed();
        segmentedButton.actionButton.is().enabled();
        segmentedButton.actionButton.is().text(action);
        segmentedButton.actionButton.click();
        validateAlert(is(actionButtonClickAlert));
    }

    @Test
    public void dropdownButtonIsValidationTests() {
        segmentedButton.dropdownMenu.is()
                .core()
                .attr("type", "button")
                .attr("data-toggle", "dropdown")
                .attr("aria-haspopup", "true")
                .attr("aria-expanded", "false")
                .tag("button");
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
                .attr("aria-label", "Text input with dropdown button")
                .tag("input");
    }

}
