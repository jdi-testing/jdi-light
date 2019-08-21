package cucmberTests.stepdefs;


import com.epam.jdi.light.elements.base.BaseUIElement;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static com.epam.jdi.bdd.Utils.getUI;
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

    @Then("^\"([^\"]*)\" is basically valid$")
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

}