package cucmberTests.stepdefs;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.elements.common.FileInput;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;

import static com.epam.jdi.bdd.BDDUtils.core;
import static com.epam.jdi.bdd.stepdefs.CheckListSteps.multiSelect;
import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.light.elements.init.entities.collection.EntitiesCollection.getUI;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;
import static java.util.Arrays.asList;
import static org.testng.Assert.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitry_Lebedev1 on 1/12/2016.
 */
public class UserStepdefs {

    @Then("^the \"([^\"]*)\" is basically valid$")
    public void baseValidation(String name) {
        UIElement el = core(name);
        assertTrue(el.isEnabled());
        assertTrue(el.isDisplayed());
        assertFalse(el.isDisabled());
        assertFalse(el.isHidden());
        Point location = el.getLocation();
        assertTrue(location.x > 0 && location.y > 0, "Location: " + location);
        Dimension size = el.getSize();
        assertTrue(size.height > 0 && size.width > 0, "Size: " + location);
        el.setAttribute("test-jdi", "test-value");
        assertEquals(el.getAttribute("test-jdi"), "test-value");
        el.highlight("blue");
        el.highlight();
        el.show();
    }
    @Given("^I should be logged in$")
    public void iShouldBeLogin() {
        String url = WebPage.getUrl();
        if (!url.contains("https://jdi-testing.github.io/jdi-light/")
                || url.contains("issue")) {
            homePage.open();
        }
        if (userName.isHidden()) {
            if (loginForm.isHidden()) {
                userIcon.click();
            }
            loginForm.submit(DEFAULT_USER);
        }
    }

    @When("^I try to upload file \"([^\"]*)\" by \"([^\"]*)\" file input element$")
    public void iTryToUploadFileByFileInputElement(String pathToFile, String elementName) {
        FileInput fileInput = getUI(elementName, FileInput.class);
        try {
            fileInput.uploadFile(mergePath(PROJECT_PATH, pathToFile));
        } catch (Exception e) {
            assertTrue(e.getLocalizedMessage().contains("Failed to execute 'uploadFile' for element"));
        }
    }
    @When("^I select \"([^\"]*)\" disabled option \"([^\"]*)\"")
    public void iSelectDisabled(String name, String option) {
        try {
            multiSelect(name, asList(option));
            fail("Select disabled should throw exception");
        } catch (Exception ignore) {}
    }
}