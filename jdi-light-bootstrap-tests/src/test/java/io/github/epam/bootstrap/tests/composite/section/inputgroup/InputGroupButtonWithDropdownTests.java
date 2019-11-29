package io.github.epam.bootstrap.tests.composite.section.inputGroup;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.inputGroupButtonWithDropdown;
import static io.github.epam.states.States.shouldBeLoggedIn;

/**
 * Created by Dmitrii Pavlov on 19.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class InputGroupButtonWithDropdownTests extends TestsInit {

    private String testText = "Test text";
    private String action = "Action";
    private String anotherAction = "Another action";
    private String somethingElseHere = "Something else here";
    private String separatedLink = "Separated link";
    private String dropdownButton = "Dropdown";

    @BeforeMethod
    public void before() {
        shouldBeLoggedIn();
        bsPage.shouldBeOpened();
    }

    @Test
    public void dropdownMenuIsValidationTests() {
        inputGroupButtonWithDropdown.dropdownMenu.is().displayed();
        inputGroupButtonWithDropdown.dropdownMenu.is().enabled();
    }

    @Test
    public void textInputAreaTests() {
        inputGroupButtonWithDropdown.textInputArea.sendKeys(testText);
        inputGroupButtonWithDropdown.textInputArea.is().text(testText);
        inputGroupButtonWithDropdown.textInputArea.clear();
        inputGroupButtonWithDropdown.textInputArea.is().text("");
    }

    @Test
    public void dropdownMenuTests() {
        inputGroupButtonWithDropdown.dropdownMenu.expand();
        inputGroupButtonWithDropdown.dropdownMenu.is().expanded();
        inputGroupButtonWithDropdown.dropdownMenu.is().size(4);
        inputGroupButtonWithDropdown.dropdownMenu.list().get(1).is().text(action);
        inputGroupButtonWithDropdown.dropdownMenu.list().get(2).is().text(anotherAction);
        inputGroupButtonWithDropdown.dropdownMenu.list().get(3).is().text(somethingElseHere);
        inputGroupButtonWithDropdown.dropdownMenu.list().get(4).is().text(separatedLink);
        inputGroupButtonWithDropdown.dropdownMenu.highlight();
        inputGroupButtonWithDropdown.dropdownMenu.select(action);
        inputGroupButtonWithDropdown.dropdownMenu.select(anotherAction);
        inputGroupButtonWithDropdown.dropdownMenu.select(somethingElseHere);
        inputGroupButtonWithDropdown.dropdownMenu.select(separatedLink);
    }

    @Test
    public void dropdownButtonTests() {
        inputGroupButtonWithDropdown.dropdownButton.is().displayed();
        inputGroupButtonWithDropdown.dropdownButton.is().enabled();
        inputGroupButtonWithDropdown.dropdownButton.is().text(dropdownButton);
        inputGroupButtonWithDropdown.dropdownButton.click();
        inputGroupButtonWithDropdown.dropdownButton.is()
                .core()
                .attr("aria-expanded", "true");
    }

    @Test
    public void dropdownButtonIsValidationTests() {
        inputGroupButtonWithDropdown.dropdownButton.is()
                .core()
                .attr("type", "button")
                .attr("data-toggle", "dropdown")
                .attr("aria-haspopup", "true")
                .attr("aria-expanded", "false")
                .tag("button");
    }

    @Test
    public void textInputAreaIsValidationTests() {
        inputGroupButtonWithDropdown.textInputArea.is()
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
