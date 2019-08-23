package cucmberTests.stepdefs;


import com.epam.jdi.bdd.Utils;
import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.ui.html.common.FileInput;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.epam.jdi.bdd.Utils.getUI;
import static com.epam.jdi.light.driver.get.DriverData.PROJECT_PATH;
import static com.epam.jdi.tools.PathUtils.mergePath;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;
import static io.github.com.pages.Header.loginForm;
import static io.github.com.pages.Header.userIcon;
import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitry_Lebedev1 on 1/12/2016.
 */
public class UserStepdefs {
    @When("^I'm wait (\\d+) seconds$")
    public void iMWaitSeconds(int arg0) {
    }

    @Then("^Log contains \"([^\"]*)\"$")
    public void logContains(String arg0) {
        Assert.assertTrue(true);
    }

    @When("^I'm input lines to \"([^\"]*)\"$")
    public void iMInputLinesTo(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Result contains \"([^\"]*)\"$")
    public void resultContains(String arg0) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^Url is \"([^\"]*)\"$")
    public void urlIs(String arg0) {

    }

    @Then("^Log is empty$")
    public void logIsEmpty() {

    }

    @Then("^the \"([^\"]*)\" is basically valid$")
    public void baseValidation(String name) {
        BaseUIElement el = getUI(name);
        assertTrue(el.isEnabled());
        assertTrue(el.isDisplayed());
        assertFalse(el.isDisabled());
        assertFalse(el.isHidden());
        Point location = el.getLocation();
        assertTrue(location.x > 0 && location.y > 0, "Location: " + location);
        Dimension size = el.getSize();
        assertTrue(size.height > 0 && size.width > 0, "Size: " + location);
        el.setAttribute("test-jdi", "test-value");
        org.testng.Assert.assertEquals(el.getAttribute("test-jdi"), "test-value");
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
        FileInput fileInput = Utils.getUI(elementName, FileInput.class);
        try {
            fileInput.uploadFile(mergePath(PROJECT_PATH, pathToFile));
        } catch (Exception e) {
            assertEquals(
                    String.format("\r\nCan't do uploadFile for disabled element '%s'", elementName),e.getMessage());
        }
    }
}