package cucmberTests.stepdefs;

import cucumber.api.java.en.Then;

import static io.github.com.pages.HomePage.githubLink;
import static org.hamcrest.Matchers.*;

//import static io.github.com.pages.HtmlElementsPage.githubLink;

/**
 * Created by Ekaterina Vasilkova on 19.08.2019
 */

public class LinkStepdefs {

    @Then("^Link text is \"([^\"]*)\"$")
    public void linkTextIs(String expectedText) {
        githubLink.is().text(is(expectedText));
    }

    @Then("^Link text ignoring case is \"([^\"]*)\"$")
    public void linkTextIgnorCaseIs(String expectedText) {
        githubLink.is().text(equalToIgnoringCase(expectedText));
    }

    @Then("^Link is enabled$")
    public void linkIsEnabled() {
        githubLink.is().enabled();
    }

    @Then("^Link alt contains \"([^\"]*)\"$")
    public void linkAltIs(String expectedText) {
        githubLink.is().alt(containsString(expectedText));
    }

    @Then("^Link ref contains \"([^\"]*)\"$")
    public void linkRefIs(String expectedText) {
        githubLink.is().ref(containsString(expectedText));
    }

    @Then("^Link asserts that link text is \"([^\"]*)\"$")
    public void linkAssertTextIs(String expectedText) {
        githubLink.assertThat().text(is(expectedText));
    }

}