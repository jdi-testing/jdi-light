package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonWithDropdown;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class ButtonWithDropdownTests extends TestsInit {

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
    String dropdownButton = "Dropdown";

    @Test
    public void dropdownMenuIsValidationTests() {
        buttonWithDropdown.dropdownMenu.is().displayed();
        buttonWithDropdown.dropdownMenu.is().enabled();
    }

    @Test
    public void textInputAreaTests() {
        buttonWithDropdown.textInputArea.sendKeys(testText);
        buttonWithDropdown.textInputArea.is().text(testText);
        buttonWithDropdown.textInputArea.clear();
        buttonWithDropdown.textInputArea.is().text("");
    }

    @Test
    public void dropdownMenuTests() {
        buttonWithDropdown.dropdownMenu.expand();
        buttonWithDropdown.dropdownMenu.is().expanded();
        buttonWithDropdown.dropdownMenu.is().size(4);
        buttonWithDropdown.dropdownMenu.list().get(0).is().text(action);
        buttonWithDropdown.dropdownMenu.list().get(1).is().text(anotherAction);
        buttonWithDropdown.dropdownMenu.list().get(2).is().text(somethingElseHere);
        buttonWithDropdown.dropdownMenu.list().get(3).is().text(separatedLink);
        buttonWithDropdown.dropdownMenu.highlight();
        buttonWithDropdown.dropdownMenu.select(action);
        buttonWithDropdown.dropdownMenu.select(anotherAction);
        buttonWithDropdown.dropdownMenu.select(somethingElseHere);
        buttonWithDropdown.dropdownMenu.select(separatedLink);
    }

    @Test
    public void dropdownButtonTests() {
        buttonWithDropdown.dropdownButton.is().displayed();
        buttonWithDropdown.dropdownButton.is().enabled();
        buttonWithDropdown.dropdownButton.is().text(dropdownButton);
        buttonWithDropdown.dropdownButton.click();
        buttonWithDropdown.dropdownButton.is()
                .core()
                .attr("aria-expanded", "true");
    }

    @Test
    public void dropdownButtonIsValidationTests() {
        buttonWithDropdown.dropdownButton.is()
                .core()
                .attr("type", "button")
                .attr("data-toggle", "dropdown")
                .attr("aria-haspopup", "true")
                .attr("aria-expanded", "false")
                .tag("button");
    }

    @Test
    public void textInputAreaIsValidationTests() {
        buttonWithDropdown.textInputArea.is()
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
