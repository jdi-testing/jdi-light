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

    @Test
    public void textInputAreaIsValidationTests() {
        buttonWithDropdown.textInputArea.is().displayed();
        buttonWithDropdown.textInputArea.is().enabled();
    }

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
        assertEquals(buttonWithDropdown.dropdownMenu.listEnabled().size(), 4);
        assertEquals(buttonWithDropdown.dropdownMenu.list().get(0).getText(), action);
        assertEquals(buttonWithDropdown.dropdownMenu.list().get(1).getText(), anotherAction);
        assertEquals(buttonWithDropdown.dropdownMenu.list().get(2).getText(), somethingElseHere);
        assertEquals(buttonWithDropdown.dropdownMenu.list().get(3).getText(), separatedLink);
        buttonWithDropdown.dropdownMenu.select(action);
        buttonWithDropdown.dropdownMenu.select(anotherAction);
        buttonWithDropdown.dropdownMenu.select(somethingElseHere);
        buttonWithDropdown.dropdownMenu.select(separatedLink);
    }

    @Test
    public void dropdownButtonTests() {
        buttonWithDropdown.dropdownButton.is().displayed();
        buttonWithDropdown.dropdownButton.is().enabled();
        assertTrue(buttonWithDropdown.dropdownButton.core().isClickable());
        buttonWithDropdown.dropdownButton.is().text("Dropdown");
        buttonWithDropdown.click();
    }


}
