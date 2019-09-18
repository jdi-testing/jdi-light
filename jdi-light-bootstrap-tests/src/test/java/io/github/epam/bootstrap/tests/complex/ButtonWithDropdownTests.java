package io.github.epam.bootstrap.tests.complex;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.github.com.StaticSite.bsPage;
import static io.github.com.pages.BootstrapPage.buttonWithDropdown;
import static io.github.epam.states.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        assertEquals(buttonWithDropdown.textInputArea.getText(), testText);
        buttonWithDropdown.textInputArea.clear();
        assertEquals(buttonWithDropdown.textInputArea.getText(), "");
    }

    @Test
    public void dropdownMenuTests() {
        buttonWithDropdown.dropdownMenu.expand();
        assertTrue(buttonWithDropdown.dropdownMenu.isExpanded());
        assertEquals(buttonWithDropdown.dropdownMenu.list().size(), 4);
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
