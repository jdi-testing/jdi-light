package cucmberTests;


import com.epam.jdi.light.elements.base.BaseUIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.epam.jdi.bdd.Utils.getBaseUIElement;
import static io.github.com.StaticSite.homePage;
import static io.github.com.entities.Users.DEFAULT_USER;
import static io.github.com.pages.Header.*;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

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

    @Then("^Base validation of \"([^\"]*)\"$")
    public void baseValidation(String name) {
        BaseUIElement el = getBaseUIElement(name);
        assertTrue(el.isEnabled());
        assertTrue(el.isDisplayed());
        assertFalse(el.isDisabled());
        assertFalse(el.isHidden());
        Point location = el.getLocation();
        assertTrue("Location: " + location, location.x > 0 && location.y > 0);
        Dimension size = el.getSize();
        assertTrue("Size: " + location, size.height > 0 && size.width > 0);
        el.setAttribute("test-jdi", "test-value");
        assertEquals(el.getAttribute("test-jdi"), "test-value");
        el.highlight("blue");
        el.highlight();
        el.show();
    }

    @Given("^I should be login$")
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
}