package com.epam.jdi.bdd.stepdefs;

import com.epam.jdi.light.ui.html.common.Link;
import cucumber.api.java.en.Then;

import static com.epam.jdi.bdd.Utils.getUI;
import static org.hamcrest.Matchers.*;

/**
 * Created by Ekaterina Vasilkova on 19.08.2019
 */

public class LinkSteps {

    @Then("^the \"([^\"]*)\" reference equals to \"([^\"]*)\"$")
    public void refEquals(String name, String expectedText) {
        Link link = getUI(name, Link.class);
        link.is().ref(equalTo(expectedText));
    }

    @Then("^the \"([^\"]*)\" reference contains \"([^\"]*)\"$")
    public void refContains(String name, String expectedText) {
        Link link = getUI(name, Link.class);
        link.is().ref(containsString(expectedText));
    }

    @Then("^the \"([^\"]*)\" reference match to \"([^\"]*)\"$")
    public void refMatchRegex(String name, String regex) {
        Link link = getUI(name, Link.class);
        link.is().ref(matchesPattern(regex));
    }

    @Then("^the \"([^\"]*)\" alt text equals to \"([^\"]*)\"$")
    public void altEquals(String name, String expectedText) {
        Link link = getUI(name, Link.class);
        link.is().alt(equalTo(expectedText));
    }

    @Then("^the \"([^\"]*)\" alt text contains \"([^\"]*)\"$")
    public void altContains(String name, String expectedText) {
        Link link = getUI(name, Link.class);
        link.is().alt(containsString(expectedText));
    }

    @Then("^the \"([^\"]*)\" alt text match to \"([^\"]*)\"$")
    public void altMatchRegex(String name, String regex) {
        Link link = getUI(name, Link.class);
        link.is().alt(matchesPattern(regex));
    }

}